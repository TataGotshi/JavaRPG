package skills;

import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;

public class Charge implements Skill {
	
	private int ap=2;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		double chargedamage = hero.getStrong()*5; 
		enemies.get(0).takeDamage(chargedamage);
		hero.setInactiveturns(1);
	}

	@Override
	public String getName() {
		
		return "Charge";
	}

	public int getAp() {
		return ap;
	}

}
