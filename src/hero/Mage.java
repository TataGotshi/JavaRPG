package hero;

import skills.*;

public class Mage extends Hero {

	private static final int MAX_HP=100;
	private static final int STR=4;
	private static final int INT=20;
	private static final int DEF=5;
	private static final int AGIL=14;
	private static final String CLASS_NAME ="Mage";
	private static final String DESCRIPTION="The mage can manage from deal manage to keep everyone little bit more safe. "
			+ "Just be careful The Mage is is super intelligent but is also super weak againts enemies attcks so you better hurry up to defeat them before they can hit you!";
	
	public Mage () {
		
		super(MAX_HP, STR, INT, DEF, AGIL);
		this.setClassName(CLASS_NAME);
		this.setDescription(DESCRIPTION);
		this.getSkills().add(new DrainLife());
		this.getSkills().add(new Frozen());
		this.getSkills().add(new MeteoriteRain());
		this.getSkills().add(new ShieldParty());
	}
	
	@Override
	protected double caldamage() {
		double damage= AGIL*.5 + INT*1 + STR*.1;
		return damage;
	}

}
