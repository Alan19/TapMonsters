package main;

import guiPractice.GUIApplication;

public class AhmedDemo extends GUIApplication{

	public AhmedDemo() {
	}

	@Override
	protected void initScreen() {
		StoreScreen store = new StoreScreen(width, height);
		setScreen(store);
	}

	public static void main(String[] args){
		AhmedDemo game = new AhmedDemo();
		Thread app = new Thread(game);
		app.start();
	}
}
