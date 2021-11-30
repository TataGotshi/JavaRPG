package skills;
import java.util.List;

import hero.Hero;
import rpg.Enemy;
import rpg.Skill;

public class Heal implements Skill {
	
	private int ap=2;
	@Override
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies) {
		
		double healamount = hero.getIntelligence()*1.75; 
		heroes.get(0).heal(healamount);
	}

	@Override
	public String getName() {
		
		return "Heal";
	}

	public int getAp() {
		return ap;
	}
	
}
