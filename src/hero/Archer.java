package hero;

import skills.*;


public class Archer extends Hero {

	private static final int MAX_HP=100;
	private static final int STR=8;
	private static final int INT=10;
	private static final int DEF=6;
	private static final int AGIL=20;
	private static final String CLASS_NAME ="Archer";
	private static final String DESCRIPTION="This class bla bla bla mostly elf";
	
	public Archer () {
		
		super(MAX_HP, STR, INT, DEF, AGIL);
		this.setClassName(CLASS_NAME);
		this.setDescription(DESCRIPTION);
		this.getSkills().add(new SuperArrow());
		this.getSkills().add(new ArrowThree());
		this.getSkills().add(new ArrowRain());
	}
	
	@Override
	protected double caldamage() {
		double damage= AGIL + INT*.5 + STR*.1;
		return damage;
	}

}
