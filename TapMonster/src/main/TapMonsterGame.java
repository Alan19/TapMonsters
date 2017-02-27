package main;

import guiPractice.GUIApplication;
import guiPractice.Screen;

public class TapMonsterGame extends GUIApplication {


	public static TapMonsterGame game;
	public static IntroScreen intro;
	public static StoreScreen store;
	public static InventoryScreen inventory;
	public static DeathScreen death;
	//public static MonsterDex monsterScreen;
	public static Screen main;
	
	
	public TapMonsterGame(int width, int height) {
		super(width,height);
	}

	@Override
	public void initScreen() {
		main = new TapMonsterScreen(getWidth(),getHeight());
		intro = new IntroScreen(getWidth(),getHeight());
		store = new StoreScreen(getWidth(),getHeight());
		inventory = new InventoryScreen(getWidth(),getHeight());
		//monsterScreen = new MonsterDex(getWidth(),getHeight());
		//death = new DeathScreen(1,5, getWidth(), getHeight(), null,null);
		setScreen(intro);
	}

	public static void main(String[] args) {
		game = new TapMonsterGame(1200, 800);
		Thread app = new Thread(game);
		app.start();
	}

}