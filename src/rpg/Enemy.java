package rpg;

import java.util.*;

import hero.Hero;

public class Enemy implements Player{

	private double hp;
	private int maxhp;
	private int str; 
	private int def;
	private int inactiveturns;
	EnemyConfig enconfig = new EnemyConfig();
	
	
	public Enemy (String type){
		
		this.maxhp= enconfig.getEnemytype().get(type).maxhp;
		this.str=enconfig.getEnemytype().get(type).str;
		this.def=enconfig.getEnemytype().get(type).def;
		
		
		this.hp=this.maxhp;
		this.inactiveturns = 0;
	}
	
	public boolean isalive() {
		return hp>0;
	}
	
	public void takeDamage(double d) {
		double takendamage =  d-def<0?0:d-def;
		hp -= takendamage;
		if (hp<=0) {
			hp=0;
		}
		System.out.printf("Enemy takes %.2f damage, HP is now %.2f \n",takendamage, hp);				
		if (hp<=0) {
			System.out.printf("RIP \n");	
		}
		
	}
	
	public void  doDamage(Hero hero) {
		hero.takeDamage(str);
	}

	public int getInactiveturns() {
		return inactiveturns;
	}

	public void setInactiveturns(int inactiveturns) {
		this.inactiveturns = inactiveturns;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}
	
	public int getMaxhp() {
		return maxhp;
	}



}
