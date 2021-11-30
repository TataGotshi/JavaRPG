package skills;

import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;
public class DrainLife implements Skill {
	private int ap=3;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		double drain = enemies.get(0).getHp()*.15;
		enemies.get(0).takeDamage(drain);
		hero.heal(drain);
	}

	@Override
	public String getName() {

		return "Drain Life";
	}

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

}
