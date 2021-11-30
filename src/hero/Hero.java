package hero;
import java.util.*;

import rpg.Enemy;
import rpg.Player;
import rpg.Skill;

public abstract class Hero implements Player {
	
	private int maxhp;
	private double hp;
	private int strong;
	private int intelligence;
	private double def;
	private int agil;
	private int ap;
	private int inactiveturns;
	private List<Skill> skills= new ArrayList<>();
	private String className;
	private String description;
	
	private static int INITIALAP = 3;
	
	Hero(int maxhp, int strong, int intelligence, int def, int agil){
	this.maxhp=maxhp;
	this.hp=maxhp;
	this.strong=strong;
	this.intelligence=intelligence;
	this.def=def;
	this.agil=agil;
	this.inactiveturns=0;
	this.ap= INITIALAP;
	}
	
	public void takeDamage(double d) {
		if(d < hp+def) {
			double takendamage =  d-def<0?0:d-def;
			hp = hp-takendamage;
			System.out.printf("Hero takes %.2f damage, %s HP is now %.2f \n",takendamage, className, hp);
			}		
		else {
			hp=0;
			System.out.printf("RIP \n");	
		}
	}
	
	public boolean isalive() {
		return hp>0;
	}
	
	public void heal(double h) {
		if(hp<maxhp) {
			if(hp+h <= maxhp) {
				hp= hp+h;
			}
			if(hp+h > maxhp) {
				hp = maxhp;
			}
			System.out.printf("HP is now %f \n", hp);
		}
		else {
		System.out.printf("You already have full HP \n");	
		}
					
	}
	
	public void basicAttack(Enemy enemy) {
			enemy.takeDamage(caldamage()); 
	}
	
	protected abstract double caldamage();

	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public int getStrong() {
		return strong;
	}

	public void setStrong(int strong) {
		this.strong = strong;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public double getDef() {
		return def;
	}

	public void setDef(double def) {
		this.def = def;
	}

	public int getAgil() {
		return agil;
	}

	public void setAgil(int agil) {
		this.agil = agil;
	}

	public int getInactiveturns() {
		return inactiveturns;
	}

	public void setInactiveturns(int inactiveturns) {
		this.inactiveturns = inactiveturns;
	}

	public List<Skill> getSkills() {
		return skills;
	}


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}
	
}
