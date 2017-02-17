package JaviyDemo;

import guiPractice.GUIApplication;
import guiPractice.Screen;

public class TapMonsterGame extends GUIApplication {

	//public static TapMonsterGame game;
	
	public static Screen intro;
	public static Screen store;
	public static InventoryScreen inventory;
	public static Screen death;
	
	public TapMonsterGame(int width, int height) {
		super();
	}

	@Override
	public void initScreen() {
		Screen main = new TapMonsterScreen(getWidth(),getHeight());
//		Screen intro = new IntroScreen(getWidth(),getHeight());
//		Screen store = new StoreScreen(getWidth(),getHeight());
//		Screen inventory = new InventoryScreen(getWidth(),getHeight());
//		Screen death = new DeathScreen(getWidth(),getHeight());
		setScreen(main);
	}

	public static void main(String[] args) {
		TapMonsterGame game = new TapMonsterGame(1000, 800);
		Thread app = new Thread(game);
		app.start();
	}

}