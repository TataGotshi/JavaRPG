package skills;

import rpg.Enemy;
import rpg.Skill;

import java.util.List;
import java.util.Random;

import hero.Hero;

public class MeteoriteRain implements Skill {
	private int ap=3;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		Random random =  new Random();
		for(@SuppressWarnings("unused") Enemy e: enemies) {
			int renemies= random.nextInt(enemies.size());
			double mdamage = random.nextDouble()*hero.getIntelligence();
			enemies.get(renemies).takeDamage(mdamage);
		}
	}

	@Override
	public String getName() {
		
		return "Meteorite Rain";
	}

	public int getAp() {
		return ap;
	}

}
