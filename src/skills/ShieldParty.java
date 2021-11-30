package skills;

import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;

public class ShieldParty implements Skill {
	private int ap=4;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		double defplus = hero.getIntelligence()*.10; 
		for(Hero h : heroes) {
			h.setDef(h.getDef()+defplus);
		}

	}

	@Override
	public String getName() {
		
		return "Shield Party ";
	}

	public int getAp() {
		return ap;
	}

}
