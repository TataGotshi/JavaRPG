package rpg;

public class Game {

	Setup setup =new Setup();
	

	public void start () {
		
		setup.displaybanner();
		setup.menu();
		System.out.printf("Dificulty: %d \n", setup.getDif());
		MainLoop mainloop = new MainLoop(setup.getDif());
		mainloop.turn();
	}

}
