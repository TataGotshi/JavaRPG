package rpg;
import java.util.*;
import hero.*
;public class Setup {
	
	Scanner in = new Scanner(System.in);
	List <Hero> heroes = new ArrayList<>();
	private int dif =2;
	private int opt;
	
	public Setup(){
		heroes.add(new Warrior());
		heroes.add(new Archer());
		heroes.add(new Paladin());
		heroes.add(new Mage());
	}
	
	public void displaybanner(){
		System.out.println("  __ ___       __     _    _   _   __ \r\n"
				+ " (_   |  |\\ | /__ |  |_   |_) |_) /__ \r\n"
				+ " __) _|_ | \\| \\_| |_ |_   | \\ |   \\_| ");
	}
	
	public void menu(){
		do {
			System.out.printf("1.Classes \n2.Dificulty \n3.Start \n4.Exit \n");
			opt = in.nextInt();
			if (opt<1 || opt>4) {
				System.out.printf("No valid option.");
			}
			if (opt == 1) {
				for(Hero hero : heroes) {
					System.out.printf("%s: %s \nStats: \n Max hp: %d\n Str: %d\n Agil: %d\n Int: %d\n Def: %.0f\n",
							hero.getClassName(), 
							hero.getDescription(), 
							hero.getMaxhp(), 
							hero.getStrong(), 
							hero.getAgil(), 
							hero.getIntelligence(), 
							hero.getDef() );
 				}
				
			} else if(opt ==2) {
				int validdif;
				do {
					System.out.printf("Select your difficulty level:\n"
						+ "1.Easy\n"
						+ "2.Medium\n"
						+ "3.Hard");
					validdif= in.nextInt();
				}while(validdif<1 || validdif>3);
				dif = validdif;
			}
		}while(opt != 4 && opt !=3 );
		
		
		
	}

	public int getDif() {
		return dif;
	}

	public void setDif(int dif) {
		this.dif = dif;
	}

	public int getOpt() {
		return opt;
	}
	

}
