package MonsterDex;

import guiPractice.GUIApplication;

public class MonsterDexScreen extends GUIApplication{
	
	public static MonsterDexScreen profile;

	public static void main(String[] args) {
		MonsterDexScreen profile = new MonsterDexScreen();
		Thread app = new Thread(profile);
		app.start();
	}
	
	@Override
	protected void initScreen() {
		MonsterDex dex = 
				new MonsterDex(getWidth(),getHeight());
		setScreen(dex);
	}
	
	public MonsterDexScreen() {
		super(1000,800);
	}
	

}
