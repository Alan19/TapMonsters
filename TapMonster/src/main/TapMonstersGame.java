package guiPractice.TapMonsters;

import guiPractice.GUIApplication;
import guiPractice.Simon.SimonGameSimon;
import guiPractice.Simon.SimonScreenSimon;

public class TapMonstersGame extends GUIApplication {

	public TapMonstersGame(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		TapMonstersScreen tapScreen = new TapMonstersScreen(getWidth(), getHeight());
		setScreen(tapScreen);
	}

	public static void main(String[] args) {
		TapMonstersGame game = new TapMonstersGame(600, 500);
		Thread app = new Thread(game);
		app.start();
	}

}
