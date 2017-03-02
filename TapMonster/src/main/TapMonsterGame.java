package main;

import java.util.ArrayList;
import artifacts.Artifact;


import guiPractice.GUIApplication;
import guiPractice.Screen;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.HoverableClickable;
import rewards.Reward;

public class TapMonsterGame extends GUIApplication {

	public static TapMonsterGame game;
	public static Screen intro;
	public static StoreScreen store;
	public static InventoryScreen inventory;
	public static DeathScreen death;
	public static ArrayList<Artifact> artifacts;
	public static ArrayList<Reward> rewards;
	public static ArrayList<HoverableClickable> artifactPictures;
	public static TapMonsterScreen main;
	public static MonsterDexScreen monsterdex;
	public static SequenceScreen2 fightScreen;
	
	public TapMonsterGame(int width, int height) {
		super(width,height);
	}

	@Override
	public void initScreen() {	
		main = new TapMonsterScreen(getWidth(),getHeight());
		death =  new DeathScreen(1,5,getWidth(), getHeight(), null);
		intro = new IntroScreen(getWidth(),getHeight());
		artifactPictures = new ArrayList<HoverableClickable>();
		artifacts = new ArrayList<Artifact>();
		rewards = new ArrayList<Reward>();
		store = new StoreScreen(getWidth(),getHeight());
		fightScreen = new SequenceScreen2(getWidth(), getHeight());
	//	inventory = new InventoryScreen(getWidth(),getHeight());
	//	monsterdex = new MonsterDexScreen(getWidth(),getHeight());

		setScreen(intro);
	}
	
	public void newFight(){
		fightScreen = new SequenceScreen2(getWidth(), getHeight());
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