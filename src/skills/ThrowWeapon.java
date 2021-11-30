package skills;

import rpg.Enemy;
import rpg.Skill;

import java.util.List;
import java.util.Random;

import hero.Hero;

public class ThrowWeapon implements Skill {
	private int ap=3;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		double weapondamage = hero.getStrong()*1.75; 
			Random random =  new Random();
			int r1= random.nextInt(enemies.size());
			int r2= random.nextInt(enemies.size());
			enemies.get(r1).takeDamage(weapondamage);
			enemies.get(r2).takeDamage(weapondamage);
			
	}


	@Override
	public String getName() {
	
		return "Throw Weapon";
	}


	public int getAp() {
		return ap;
	}

}
