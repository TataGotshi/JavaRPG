package rpg;

import java.util.*;

import hero.*;

public class MainLoop {
	
	UIManager ui = new UIManager();
	EnemyConfig econfig = new EnemyConfig();
	List <Hero> heroesplaying = new ArrayList<>();
	List <Player> players = new ArrayList<>();
	List <Enemy> enemies = new ArrayList<>();

	int turnnum=0;
	
	public MainLoop(int dif) {
		heroesplaying.add(new Warrior());
		heroesplaying.add(new Archer());
		heroesplaying.add(new Paladin());
		heroesplaying.add(new Mage());
		
		enemybydif(dif);
		playerList();
		shufflePlayers();
	}
	
	private void enemybydif (int dif) {
		
		Map<String, Integer> map1= econfig.getDifmap().get(dif);
		
		for(String key:map1.keySet()) {
			int numenemy= map1.get(key);
			for(int i=0; i<numenemy; i++) {
				Enemy enemy = new Enemy(key); 
				enemies.add(enemy);
			}
		}
	}
	
	private void playerList() {
		for(Hero hero:heroesplaying) {
			players.add(hero);
		}
		for(Enemy enemy:enemies) {
			players.add(enemy);
		}
	}
	
	private void shufflePlayers() {
		Collections.shuffle(players);
	}
	
	private Hero randomhero() {
		Random random =  new Random();
		int randomheroindex = random.nextInt(heroesplaying.size());
		if (!heroesplaying.get(randomheroindex).isalive()) {
			return randomhero();
		}
		return heroesplaying.get(randomheroindex);
	}
	
	private Enemy enemyattacked() {
		for(Enemy e:enemies) {
			if (e.isalive()) {
				return e;
			}
		}
		return null;
	}
	
	private void nextturn() {
		turnnum++;
		if(turnnum >= players.size()) {
			turnnum=0;
		}	
		turn();
	}
	
	private void enemyturn(Enemy enemyinturn) {
		UIManager.msg("Enemy turn");
		if (!enemyinturn.isalive()) {
			UIManager.msg("Enemy is dead");
			nextturn();
		}else {
			if(enemyinturn.getInactiveturns()>0) {
				int inactive= enemyinturn.getInactiveturns();
				inactive--;
				enemyinturn.setInactiveturns(inactive);
				UIManager.msg("Enemy is inactive");
				nextturn();
			}else {
				Hero ranhero=randomhero();
				UIManager.msg("Enemy attacks "+ranhero.getClassName());
				enemyinturn.doDamage(ranhero);
				nextturn();
			}
		}
	}
	
	private List <Enemy> liveenemies() {
		List <Enemy> liveenemies = new ArrayList<>();
		for(Enemy e:enemies) {
			if(e.isalive()) {
				liveenemies.add(e);
			}
		}
		return liveenemies;
	}
	
	private void exitoption() {
		System.exit(0);
	}
	
	private boolean youwin() {
		for(Enemy e:enemies) {
			if(e.isalive()) {
				return false;
			}	
		}
		return true;
	}
	
	private boolean youlose(){
		for(Hero h:heroesplaying) {
			if(h.isalive()) {
				return false;
			}	
		}
		return true;
	}
	
	private boolean enoughap(Hero herointurn) {
		int currentap = herointurn.getAp();
		for(Skill s:herointurn.getSkills()) {
			if (currentap>= s.getAp() ) {
				return true;
			}
		}
		return false;
	} 
	
	private void heroturn(Hero herointurn) {
		UIManager.msg("Hero in turn:"+herointurn.getClassName());
		if (!herointurn.isalive()) {
			UIManager.msg("Hero "+herointurn.getClassName()+" is dead");
			nextturn();
		}else {
			herointurn.setAp(herointurn.getAp()+1);
			if(herointurn.getInactiveturns()>0) {
				int inactive= herointurn.getInactiveturns();
				inactive--;
				herointurn.setInactiveturns(inactive);
				UIManager.msg("Hero "+herointurn.getClassName()+" is inactive");
				nextturn();
			}else {
				int heroselection = ui.heromenuoption();
				if(heroselection == 1) {					
					int attacktypeselection = ui.heroattackmenu(enoughap(herointurn));
					if(attacktypeselection == 1) {
						Enemy bringenemy= enemyattacked();
						if(bringenemy!=null) {
							UIManager.msg("Hero "+herointurn.getClassName()+" is now attacking");
							herointurn.basicAttack(bringenemy);
							nextturn();
						}else {
							ui.victory();
							exitoption();
						}
					}else {
						int skillselection = ui.skillsmenu(herointurn);
						 Skill usedskill = herointurn.getSkills().get(skillselection);
						 UIManager.msg("Hero "+herointurn.getClassName()+" is now attacking with skill "
								 +usedskill.getName());
						 usedskill.execute(herointurn, heroesplaying, liveenemies());
						 herointurn.setAp(herointurn.getAp()-usedskill.getAp());
						 nextturn();
					}
				}else if (heroselection == 2) {
					nextturn();
				}else {
					exitoption();
				}
			}
			
			
		}
	}
	
	
	public void turn() {
		if(youwin()) {
			ui.victory();
			exitoption();
		}else if(youlose()) {
			ui.lose();
			exitoption();
		}else {
			Player playerinturn = players.get(turnnum);
			ui.displayingame(players, heroesplaying, enemies, playerinturn);
			if(playerinturn instanceof Enemy) {
				Enemy enemyinturn=(Enemy) playerinturn;
				enemyturn(enemyinturn);
			}else {
				Hero herointurn=(Hero) playerinturn;
				heroturn(herointurn);
			}
		}
	}
		
}
