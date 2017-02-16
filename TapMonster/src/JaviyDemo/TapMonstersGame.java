package JaviyDemo;

import guiPractice.GUIApplication;
import guiPractice.Screen;

public class TapMonstersGame extends GUIApplication {
public static Screen storeScreen;
public static Screen deathScreen;
public static Screen inventoryScreen;
public static TapMonstersGame game;
	public TapMonstersGame(int width, int height) {
		super(1000,500);
	}

	@Override
	public void initScreen() {
		Screen tapScreen = new TapMonstersScreen(getWidth(), getHeight());
		setScreen(tapScreen);
	}

	public static void main(String[] args) {
		TapMonstersGame game = new TapMonstersGame(1000, 500);
		Thread app = new Thread(game);
		app.start();
	}

}
