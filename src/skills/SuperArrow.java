package skills;

import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;

public class SuperArrow  implements Skill{
	private int ap=3;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		
		double arrowdamage = hero.getAgil()*3; 
		enemies.get(0).takeDamage(arrowdamage);
	}

	@Override
	public String getName() {
	
		return "Super Arrow";
	}

	public int getAp() {
		return ap;
	}
}
