package main;

import guiPractice.GUIApplication;

public class MonsterDexGame extends GUIApplication{
	
	public MonsterDexGame() {
		super(1200,800);
	}
	
	@Override
	protected void initScreen() {
		MonsterDexScreen dex = 
				new MonsterDexScreen(1000,800);
		setScreen(dex);
	}
	
	public static void main(String[] args) {
		MonsterDexGame profile = new MonsterDexGame();
		Thread app = new Thread(profile);
		app.start();
	}
	

}
