package rpg;

import java.util.*;

import hero.Hero;

public class UIManager {
	Scanner in = new Scanner(System.in);
	
	public int heromenuoption() {
		int opt;
		do {
			System.out.printf("What action do you want to do?\n"
					+"1.Attck\n"
					+"2.Pass turn\n"
					+"3.Exit\n");
			opt = in.nextInt();
			if (opt<1 || opt>3) {
				System.out.printf("No valid option.");
			}
		} while(opt<1 || opt>3 );
		return opt;
	}
	
	public int heroattackmenu(boolean enoughap) {
		int opt;
		boolean flag = false;
		do {
			flag =false;
			System.out.printf("Please select the attack type:\n"
					+ "1.Basic Attack\n"
					+ "2.Skill Attack\n");
			opt = in.nextInt();
			if (opt<1 || opt>2) {
				System.out.printf("No valid option.");
			}
			if (opt ==2 && !enoughap) {
				System.out.printf("You do not have enough AP to use a skill :(");
				flag = true;
			}
			
		}while(opt<1 || opt>2 || flag );
		return opt;
	}
	
	public int skillsmenu(Hero herointurn) {
		int opt;
		boolean okflag = true;
		int skillsize=herointurn.getSkills().size();
		do {
			okflag = true;
			System.out.printf("Please select the skill:\n");		
			for(int i=0; i <skillsize; i++) {
				System.out.printf("%d.- %s \n", i, herointurn.getSkills().get(i).getName());
			}
			opt = in.nextInt();
			if (opt<0 || opt>skillsize-1) {
				System.out.printf("No valid option.");
				okflag=false;
				continue;
			}
			if(herointurn.getAp()<herointurn.getSkills().get(opt).getAp()) {
				System.out.printf("You don't have enough AP to use this Skill");
				okflag=false;
				continue;
			}	
		}while(!okflag); 
		return opt;
	}
	
	public void victory() {
		System.out.printf("Congratulations there are no more enemies. \n"
				+"YOU WIN!");
	}
	public void lose() {
		System.out.printf("There are not more alive heroes. \n"
				+"YOU LOSE!");
	}
	private void displayturn(List <Player> playerslist) {
		String turndisplay = "";
		for(Player p:playerslist) {
			if(p instanceof Enemy) {
				turndisplay+="x";
			}else {
				Hero hero=(Hero)p;
				if(hero.getClassName() == "Mage") {
					turndisplay+="M";
				}else if (hero.getClassName() == "Paladin") {
					turndisplay+="P";
				}else if (hero.getClassName() == "Warrior") {
					turndisplay+="W";
				}else {
					turndisplay+="A";
				}
				
			}
			
		}
		System.out.printf("TURN QUEUE: \n %s \n\n", turndisplay);
		
	}
	
	private void herostatsdisplay(List <Hero> heroeslist, Player playerinturn) {
		for(Hero h:heroeslist) {
			System.out.printf("%s%s,	HP:%.2f/%d,	AP:%d,	Def:%.2f \n",
					heroindicator(h,playerinturn),
					h.getClassName(),
					h.getHp(),
					h.getMaxhp(),
					h.getAp(),
					h.getDef());
		}		
	}
	
	
	private String heroindicator(Hero hero, Player playerinturn) {
		if(playerinturn instanceof Hero) {
			Hero heroplaying = (Hero)playerinturn;
			if(heroplaying.getClassName()==hero.getClassName()) {
				return ">>>";
			}else {
				return "";
			}
		}else {
			return "";
		}
	}
	
	
	private void enemystatsdisplay(List <Enemy> enemylist) {
		for(Enemy e:enemylist) {
			System.out.printf("[%.2f/%d]\t", e.getHp(), e.getMaxhp());	
		}
		System.out.println("");
	}
	
	public void displayingame(
			List <Player> playerslist, 
			List <Hero> heroeslist, 
			List<Enemy> enemieslist, 
			Player playerinturn ) {
	
		displayturn(playerslist);
		herostatsdisplay(heroeslist, playerinturn);
		enemystatsdisplay(enemieslist);
	}
	
	public static void msg(String s, int i) {
		System.out.println(s);
		wait(i);
		
	}
	
	public static void msg(String s) {
		msg(s, 500);
	}
	
	public static void wait(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
	
}
