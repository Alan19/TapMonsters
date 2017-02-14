package main;

import guiPractice.GUIApplication;

public class AhmedDemo extends GUIApplication{

	public AhmedDemo(int width, int height) {
		super();
	}

	@Override
	protected void initScreen() {
		StoreScreen store = new StoreScreen(getWidth(), getHeight());
		setScreen(store);
	}

	public static void main(String[] args){
		AhmedDemo game = new AhmedDemo(2000, 2000);
		Thread app = new Thread(game);
		app.start();
	}
}
