package main;

import java.util.ArrayList;
import artifacts.Artifact;


import guiPractice.GUIApplication;
import guiPractice.Screen;
import guiPractice.components.ClickableGraphic;

public class TapMonsterGame extends GUIApplication {

	public static TapMonsterGame game;
	public static Screen intro;
	public static StoreScreen store;
	public static InventoryScreen inventory;
	public static Screen death;
	public static ArrayList<Artifact> artifacts;
	public static ArrayList<ClickableGraphic> artifactPictures;
	public static TapMonsterScreen main;
	public static MonsterDexScreen monsterdex;
	public static SequenceScreen2 fightScreen;
	
	public TapMonsterGame(int width, int height) {
		super(width,height);
	}

	@Override
	public void initScreen() {
		
		main = new TapMonsterScreen(getWidth(),getHeight());
		intro = new IntroScreen(getWidth(),getHeight());
		store = new StoreScreen(getWidth(),getHeight());
<<<<<<< HEAD
		artifactPictures = new ArrayList<ClickableGraphic>();
		artifacts = new ArrayList();
=======
		fightScreen = new SequenceScreen2(getWidth(), getHeight());
>>>>>>> branch 'develop' of https://github.com/Alan19/TapMonsters.git
		store.createArtifacts();
		store.createArtifactPics();
		//inventory = new InventoryScreen(getWidth(),getHeight());
		//monsterdex = new MonsterDexScreen(getWidth(),getHeight());
<<<<<<< HEAD
		//death = new DeathScreen(1,5,getWidth(),getHeight(), null,null);
=======

>>>>>>> branch 'develop' of https://github.com/Alan19/TapMonsters.git
		setScreen(intro);
	}

	public static void main(String[] args) {
		game = new TapMonsterGame(1200, 800);
		Thread app = new Thread(game);
		app.start();
	}

	public static void newFightScreen() {
		// TODO Auto-generated method stub
		fightScreen = new SequenceScreen2(1200, 800);
//		return fightScreen;
	}
	
	

}