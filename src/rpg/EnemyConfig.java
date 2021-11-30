package rpg;

import java.util.*;


public class EnemyConfig {
	
	Map <Integer, Map<String, Integer>> difmap = new HashMap<>();
	Map <String, EnemyData> enemytype = new HashMap<>();
	
	public class EnemyData{
		public int maxhp;
		public int str;
		public int def;
		
		public EnemyData(int maxhp, int str, int def) {
			this.maxhp=maxhp;
			this.str=str;
			this.def=def;
		}
		
	}
	public EnemyConfig() {
		
		
		enemytype.put("minion", new EnemyData(20,8,4));
		enemytype.put("orc", new EnemyData(50,16,6));
		enemytype.put("boss", new EnemyData(120,30,20));
		
		Map <String, Integer> enemycant1 = new LinkedHashMap<>();
		enemycant1.put("minion",15);
		
		Map <String, Integer> enemycant2 = new LinkedHashMap<>();
		enemycant2.put("minion",10);
		enemycant2.put("orc", 2);
		
		Map <String, Integer> enemycant3 = new LinkedHashMap<>();
		enemycant3.put("minion",10);
		enemycant3.put("orc", 1);
		enemycant3.put("boss", 1);
		
		
		difmap.put(1, enemycant1);
		difmap.put(2, enemycant2);
		difmap.put(3, enemycant3);
		
	}
	public Map<Integer, Map<String, Integer>> getDifmap() {
		return difmap;
	}
	public Map<String, EnemyData> getEnemytype() {
		return enemytype;
	}

}
