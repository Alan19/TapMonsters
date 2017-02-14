package MonsterDex;

import guiPractice.GUIApplication;

public class MonsterDexScreen extends GUIApplication{

	public MonsterDexScreen() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		MonsterDex dex = 
				new MonsterDex(getWidth(),getHeight());
		setScreen(dex);
	}
	
	public static void main(String[] args) {
		MonsterDexScreen profile = new MonsterDexScreen();
		Thread app = new Thread(profile);
		app.start();
	}

}
