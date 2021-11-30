package skills;

import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;

public class HealAll implements Skill {
	private int ap=4;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		double healamount = hero.getIntelligence()*.75; 
		for(Hero h :heroes) {
			if(h.isalive()) {
				h.heal(healamount);
			}
		}
	}

	@Override
	public String getName() {
		
		return "Heal All";
	}

	public int getAp() {
		return ap;
	}
}
