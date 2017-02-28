package MonsterDex;

import guiPractice.GUIApplication;
import main.MonsterDexScreen;

public class MonsterDexGame extends GUIApplication{
	
	public MonsterDexGame() {
		super(1000,800);
	}
	
	@Override
	protected void initScreen() {
		MonsterDexScreen dex = 
				new MonsterDexScreen(getWidth(),getHeight());
		setScreen(dex);
	}
	
	public static void main(String[] args) {
		MonsterDexGame profile = new MonsterDexGame();
		Thread app = new Thread(profile);
		app.start();
	}
	

}
