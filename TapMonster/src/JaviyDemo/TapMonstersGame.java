package JaviyDemo;

import guiPractice.GUIApplication;
import guiPractice.Screen;

public class TapMonstersGame extends GUIApplication {

	public TapMonstersGame(int width, int height) {
		super();
	}

	@Override
	public void initScreen() {
		TapMonstersScreen tapScreen = new TapMonstersScreen(getWidth(), getHeight());
		setScreen(tapScreen);
	}

	public static void main(String[] args) {
		TapMonstersGame game = new TapMonstersGame(1000, 5);
		Thread app = new Thread(game);
		app.start();
	}

}
