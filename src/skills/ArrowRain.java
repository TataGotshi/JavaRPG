package skills;

import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;

public class ArrowRain implements Skill {
	
	private int ap=2;
	
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		double arrowdamage = hero.getAgil()*.25; 
		for(Enemy e :enemies) {
			e.takeDamage(arrowdamage);
		}
	}

	@Override
	public String getName() {
		return "Arrow Rain"; 
	}

	public int getAp() {
		return ap;
	}
	

}
