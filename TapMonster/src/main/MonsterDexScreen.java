package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import interfaces.MonDexInterface;
import main.MonsterGraphic;

public class MonsterDexScreen extends ClickableScreen implements Runnable,MonDexInterface{
	
	private static ArrayList<Graphic> Monsters;

	private Button next;
	private Button back;
	private Button home;
	private Graphic background;
	private static Graphic monsterImg1;
	private static Graphic monsterImg2;
	private static TextArea Description;
	private TextLabel Name;
	
	private String[] trait1 = {"This"+""+"gives out an aura that scare any who come near it",
			"This"+""+" towers above the others.",
			"This"+""+"  has a very unusual size.",
			"This"+""+"is known for the number of adventurers it has killed.",
			"This"+""+"has a temper.",
			"This"+""+"has a streak of sadistic acts.",
			"This"+""+"is not dangerous,but have caution when near it",
			"This "+""+" can be left with children if trained properly.",
			"Its is said that the sight of this "+""+"will kill any who see it",
			"This"+""+" is rarely seen near others."};
	private String[] trait2 = {"It thinks every action through, taking care to never make a mistake.",
			"It rushes through everything, causing it to be clumsy and uncoordinated.",
			"It lays about, doing the bare minimum just to stay alive.",
			"It constantly walks the border between life and death, due to its uncaring nature to life itself",
			"If you find an injured animal, you can guarentee finding this animal nearby taking care of it. ",
			"It exaggerates everything to the point that animals, predator or prey, purposefully avoid it",
			"In groups, you can find it leading the charge and taking risks to survive.",
			"It will only hunt uninjured prey, and never takes them by surprise as a show of resspect.",
			"Because of its fluffiness, no one takes it seriously, but looks can be deceiving...",
			"It only hunts prey that have no chance of winning. Because of that it has never fought a real threat before."};
	private String[] trait3 = {"A animal, a creature that can be found anywhere in the world. You've fought many like it, but they can still trake you by surprise.",
			"One of nature's greatest creations corrupted, used for whatever heinous purpose leads it.",
			"Few of these exist anymore, which is surprising due to their size. They are the most dangerous creatrures alive, and living to tell the tale of its existence is an achievement in and of itself",
			"They exist mainly in the other world, but can sometimes enter our world. When they do they can stir up any amount of trouble",
			"The things are despicable creatures, whose appetites consist mainly of anything it can get its hands/tentacles/etc. on",
			"It can hardly be called a creature, much less a 'thing'. Due to their rarity, they are difficult to fight, since few have seen them and even fewer kill them."};

	private Graphic monsterImg3;

	private Graphic monsterImg4;

	private Graphic monsterImg5;

	private Graphic monsterImg6;
		
	public MonsterDexScreen(int width,int height) {
		super(1000, 800);
		Thread play = new Thread(this);
		play.start();
	}
	
	
//	public void initObjects(ArrayList<Visible> viewObjects){
//		
//	}
//


	public void run() {
		// TODO Auto-generated method stub
		
	}

	public void SetDescription(String des) {
		// TODO Auto-generated method stub
		
	}


	public int setNumEncountered(int encounters) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getImagePath() {
		return null;
		
	}


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void setMonsters(ArrayList<Graphic> monsters) {
		Monsters = monsters;
	}

	public ArrayList<Graphic> getMonsters() {
		return Monsters;
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		next = new Button(getWidth() - 110, getHeight() - 70, 90, 50, "Next", Color.decode("#a52a2a"), null);
		back = new Button(20, getHeight() - 70, 90, 50, "Back", Color.decode("#a52a2a"), new Action() {
			public void act() {
				monsterImg1.loadImages(main.MonsterGraphic.getMonster("Beast"), 100, 100);
				monsterImg2.loadImages(main.MonsterGraphic.getMonster("Beast"), 100, 100);
			}
		});
		home = new Button(10,10,100,50, "Home", Color.red, new Action(){
			public void act(){
				TapMonsterGame.game.setScreen(TapMonsterGame.main);
			}
		});
		background = new Graphic(0,0,getWidth(),getHeight(),"src/resources/background.jpg");
		monsterImg1 = new Graphic(100,100,100,100,main.MonsterGraphic.getMonster("Titan")); 
		monsterImg2 = new Graphic(200,200,100,100,main.MonsterGraphic.getMonster("Beast")); 
		monsterImg3 = new Graphic(300,300,100,100,main.MonsterGraphic.getMonster("Titan")); 
		monsterImg4 = new Graphic(400,400,100,100,main.MonsterGraphic.getMonster("Beast")); 
		monsterImg5 = new Graphic(500,500,100,100,main.MonsterGraphic.getMonster("Beast")); 
		monsterImg6 = new Graphic(600,600,100,100,main.MonsterGraphic.getMonster("Titan")); 
		
		viewObjects.add(background);
		viewObjects.add(next);
		viewObjects.add(back);	
		viewObjects.add(home);	
		viewObjects.add(monsterImg1);
		viewObjects.add(monsterImg2);
		viewObjects.add(monsterImg3);
		viewObjects.add(monsterImg4);
		viewObjects.add(monsterImg5);
		viewObjects.add(monsterImg6);

	}

}