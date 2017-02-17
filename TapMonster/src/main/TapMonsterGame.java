package main;

import guiPractice.GUIApplication;
import guiPractice.Screen;

public class TapMonsterGame extends GUIApplication {

	//public static TapMonsterGame game;
	
	public static Screen intro;
	public static Screen store;
	public static InventoryScreen inventory;
	public static Screen death;
	
	public TapMonsterGame(int width, int height) {
		super(width,height);
	}

	@Override
	public void initScreen() {
		Screen main = new TapMonsterScreen(getWidth(),getHeight());
		intro = new IntroScreen(getWidth(),getHeight());
		store = new StoreScreen(getWidth(),getHeight());
		inventory = new InventoryScreen(getWidth(),getHeight());
		death = new DeathScreen(getWidth(),getHeight(), getDefaultCloseOperation(), getDefaultCloseOperation(), null);
		setScreen(main);
	}

	public static void main(String[] args) {
		TapMonsterGame game = new TapMonsterGame(1200, 800);
		Thread app = new Thread(game);
		app.start();
	}

}