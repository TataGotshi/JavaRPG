package hero;

//import java.util.*;
//import rpg.Skill;
import skills.*;

public class Warrior extends Hero {

	private static final int MAX_HP=100;
	private static final int STR=20;
	private static final int INT=4;
	private static final int DEF=10;
	private static final int AGIL=12;
	private static final String CLASS_NAME ="Warrior";
	private static final String DESCRIPTION="This class is prue brute force";
	
	public Warrior () {
		
		super(MAX_HP, STR, INT, DEF, AGIL);
		this.setClassName(CLASS_NAME);
		this.setDescription(DESCRIPTION);
		ThrowWeapon skill1 = new ThrowWeapon();
		this.getSkills().add(skill1);
		this.getSkills().add(new Charge());
		this.getSkills().add(new Stun());
	}
	
	@Override
	protected double caldamage() {
		double damage= STR + AGIL*.5 + INT*.1;
		return damage;
	}

}
