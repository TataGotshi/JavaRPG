package hero;

import skills.*;

public class Paladin extends Hero {

	private static final int MAX_HP=100;
	private static final int STR=14;
	private static final int INT=16;
	private static final int DEF=10;
	private static final int AGIL=8;
	private static final String CLASS_NAME ="Paladin";
	private static final String DESCRIPTION="Some call the doctor!  Well is here it's ready to gives you some paracetamol and ready to use the defribillator on you!";
	
	public Paladin () {
		
		super(MAX_HP, STR, INT, DEF, AGIL);
		this.setClassName(CLASS_NAME);
		this.setDescription(DESCRIPTION);
		this.getSkills().add(new Heal());
		this.getSkills().add(new HealAll());
		this.getSkills().add(new Revive());
	}
	
	@Override
	protected double caldamage() {
		double damage= AGIL*.1 + INT*.5 + STR*.5;
		return damage;
	}
}
