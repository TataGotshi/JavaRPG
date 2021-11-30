package skills;

import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;

public class Revive implements Skill {
	private int ap=3;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		for(Hero h :heroes) {
			if(!h.isalive()) {
				h.heal(h.getMaxhp()*.10);
			}
			
		}

	}

	@Override
	public String getName() {
	
		return "Revive";
	}

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

}
