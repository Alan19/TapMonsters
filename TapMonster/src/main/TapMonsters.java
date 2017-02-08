package main;

import guiPractice.GUIApplication;

public class TapMonsters extends GUIApplication {

	/*
	 * Static Fields
	 * */
	public static TapMonsters game;
	
	
	public TapMonsters(int x, int y) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		game = new TapMonsters(1000, 1000);
		Thread go = new Thread(game);
		go.start();
	}

}
