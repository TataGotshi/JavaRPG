package rpg;
import java.util.*;

import hero.Hero;

public interface Skill {
         
	public void execute(Hero hero, List<Hero> heroes, List<Enemy> enemies);
	
	public String getName();
	
	public int getAp();
}
                                                                                  