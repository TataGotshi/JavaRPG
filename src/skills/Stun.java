package skills;

import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;

public class Stun implements Skill {
	private int ap=3;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) { 
		for(int i=0; i<enemies.size()&&i<5; i++) {
			enemies.get(i).setInactiveturns(1);
		}
	} 

	@Override
	public String getName() {
		
		return "Stun";
	}

	public int getAp() {
		return ap;
	}

}
