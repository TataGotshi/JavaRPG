package skills;

import rpg.Enemy;
import rpg.Skill;

import java.util.List;
import java.util.Random;

import hero.Hero;

public class Frozen implements Skill {
	private int ap=2;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		Random random =  new Random();
		int r1= random.nextInt(enemies.size());
		enemies.get(r1).setInactiveturns(3);

	}

	@Override
	public String getName() {
		
		return "Frozen";
	}

	public int getAp() {
		return ap;
	}

}
