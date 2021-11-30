package skills;

import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;

public class ArrowThree implements Skill {
	private int ap=2;

	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		double arrowdamage = hero.getAgil()*.25; 
		for(int i=0; i<enemies.size()&&i<3; i++) {
			enemies.get(i).takeDamage(arrowdamage);
		}
	}

	@Override
	public String getName() {
		
		return "Arrow Three";
	}

	public int getAp() {
		return ap;
	}

}
