package main;

import java.awt.Color;
import java.awt.Font;
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

public class MonsterDexScreen extends ClickableScreen implements Runnable,MonDexInterface,MonsterAbility,FindMonster{

	Monster monsters;
	private Button next;
	private Button back;
	private Button home;
	private Graphic background;
	private Graphic monsterImg1;
	private static Graphic monsterImg2;
	private static Graphic monsterImg3;
	private static Graphic monsterImg4;
	private static Graphic monsterImg5;
	private static Graphic monsterImg6;
	private static TextArea description;
	private static String textHolder = "";
	private TextLabel name;
	private static String[] nameHolder;
	private int monID = 0;
	private boolean invisWall = false;
	
	
	
	private static String[] trait1 = {"It gives out an aura that scare any who come near it.",
			"It towers above the others.",
			"It has a very unusual size.",
			"It is known for the number of adventurers it has killed.",
			"It has a temper.",
			"It has a streak of sadistic acts.",
			"It is not dangerous,but have caution when near it.",
			"It can be left with children if trained properly.",
			"Its is said that the sight of It will kill any who see it.",
			"It is rarely seen near others."};
	private static String[] trait2 = {" It thinks every action through, taking care to never make a mistake.",
			" It rushes through everything, causing it to be clumsy and uncoordinated.",
			" It lays about, doing the bare minimum just to stay alive.",
			" It constantly walks the border between life and death, due to its uncaring nature to life itself.",
			" If you find an injured animal, you can guarentee finding this animal nearby taking care of it. ",
			" It exaggerates everything to the point that animals, predator or prey, purposefully avoid it.",
			" In groups, you can find it leading the charge and taking risks to survive.",
			" It will only hunt uninjured prey, and never takes them by surprise as a show of resspect.",
			" Because of its fluffiness, no one takes it seriously, but looks can be deceiving...",
			" It only hunts prey that have no chance of winning. Because of that it has never fought a real threat before."};
	private static String[] trait3 = {" A animal, a creature that can be found anywhere in the world. You've fought many like it, but they can still take you by surprise.",
			" One of nature's greatest creations corrupted, used for whatever heinous purpose leads it.",
			" Few of these exist anymore, which is surprising due to their size. They are the most dangerous creatrures alive, and living to tell the tale of its existence is an achievement in and of itself.",
			" They exist mainly in the other world, but can sometimes enter our world. When they do they can stir up any amount of trouble.",
			" The things are despicable creatures, whose appetites consist mainly of anything it can get its hands/tentacles/etc. on.",
			" It can hardly be called a creature, much less a 'thing'. Due to their rarity, they are difficult to fight, since few have seen them and even fewer kill them."};
	
		
	public MonsterDexScreen(int width,int height) {
		super(1200,800);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//monsters = new Monster(TapMonsterGame.main, 0,0);
		next = new Button(50,getHeight()-200, 90, 50, "Next", Color.decode("#a52a2a"), new Action() {
			public void act() {
				changeMonsters(1);
			}

		});
		
		back = new Button(getWidth()-140,getHeight()-200, 90, 50, "Back", Color.decode("#a52a2a"), new Action() {
			public void act() {
				changeMonsters(0);
			}
		});
		
		home = new Button(10,10,100,50, "Home", Color.red, new Action(){
			public void act(){
				TapMonsterGame.game.setScreen(TapMonsterGame.main);
			}
		});
		
		
		background = new Graphic(0,0,getWidth(),getHeight(),"src/resources/background.jpg");
		
		viewObjects.add(background);
		viewObjects.add(next);
		viewObjects.add(back);	
		viewObjects.add(home);	
		
		setMonsterDex();
		setMonNames();
	}
	
	private void setMonNames() {
		for(int i = monID; i < monID+6; i++){
			while(i < Monster.returnNames().size()){
				name = new TextLabel((100*i)+50,(100*i),500,100,getSpecies(monID));
				viewObjects.add(name);
				i++;
			}	
		}	
	}

	private void setMonsterDex() {
		if (invisWall == false){	
				for(int i = monID; i < Monster.returnNames().size()+1; i++){
					if(i == 0){
	                    monsterImg1 = new Graphic((100*i)+50,(100*i)+100,100,100,MonsterGraphic.getFilePaths().get(i+1));
	                    getSpecies(monID);
	                    description = new TextArea((100*i)+150,(100*i)+100,800,100,getDesc());
	                    viewObjects.add(description);
	                    viewObjects.add(monsterImg1); 
	                    monID+=2;
					}
//					if(i == 1){
//						monsterImg2 = new Graphic((100*i)+50,(100*i)+100,100,100,MonsterGraphic.getFilePaths().get(i*2));
//	                    getSpecies(monID);
//	                    description = new TextArea((100*i)+150,(100*i)+100,800,100,getDesc());
//	                    viewObjects.add(description);
//	                    viewObjects.add(monsterImg2); 
//	                    monID+=2;
//					}
//					if(i == 2){
//						monsterImg3 = new Graphic((100*i)+50,(100*i)+100,100,100,MonsterGraphic.getFilePaths().get(i*2));
//	                    getSpecies(monID);
//	                    description = new TextArea((100*i)+150,(100*i)+100,800,100,getDesc());
//	                    viewObjects.add(description);
//	                    viewObjects.add(monsterImg3); 
//	                    monID+=2;
//					}
//					if(i == 3){
//						monsterImg4 = new Graphic((100*i)+50,(100*i)+100,100,100,MonsterGraphic.getFilePaths().get(i*2));
//	                    getSpecies(monID);
//	                    description = new TextArea((100*i)+150,(100*i)+100,800,100,getDesc());
//	                    viewObjects.add(description);
//	                    viewObjects.add(monsterImg4); 
//	                    monID+=2;
//					}
//					if(i == 4){
//						monsterImg5 = new Graphic((100*i)+50,(100*i)+100,100,100,MonsterGraphic.getFilePaths().get(i*2));
//	                    getSpecies(monID);
//	                    description = new TextArea((100*i)+150,(100*i)+100,800,100,getDesc());
//	                    viewObjects.add(description);
//	                    viewObjects.add(monsterImg5); 
//	                    monID+=2;				
//					}
//					if(i == 5){
//						monsterImg6 = new Graphic((100*i)+50,(100*i)+100,100,100,MonsterGraphic.getFilePaths().get(i*2));
//	                    getSpecies(monID);
//	                    description = new TextArea((100*i)+150,(100*i)+100,800,100,getDesc());
//	                    viewObjects.add(description);
//	                    viewObjects.add(monsterImg6); 
//	                    monID+=2;				
//	                    invisWall = true;
//					}
				}
			}						
         }

	//gets the randomized name from javiy and splits it into an array.
	public String getSpecies(int monID) {
		String x = Monster.returnNames().get(monID);
		String[] y = x.split(" ");
		nameHolder = y;
		System.out.println(y[4]);
		return y[4];
	}	
	
	//makes a description by using getTrait
	public static String getDesc(){
		System.out.print(nameHolder[1]);
		System.out.print(nameHolder[2]);
		System.out.print(nameHolder[3]);
		System.out.print(nameHolder[4]);
		textHolder += getTrait(Monster.getName1(),nameHolder[1],1);
		textHolder += getTrait(Monster.getName2(),nameHolder[3],2);
		textHolder += getTrait(Monster.getName3(),nameHolder[4],3);
		System.out.println(textHolder);
		return textHolder;
	}
	
	//gets Traits by checking index of each part of javiy's name and using that index to get the trait from my array
	public static String getTrait(String[] name, String trait,int traitArr){
		 for(int i = 0; i < name.length; i++){
			 if(name[i].equals(trait) && traitArr == 1){
				 return trait1[i];
			 }
			 if(name[i].equals(trait) && traitArr == 2){
				 return trait2[i];
			 }
			 if(name[i].equals(trait) && traitArr == 3){
				 return trait3[i];
			 }
		 }
		return "Nothing is known";
	}
	
	public static void setMonsters(ArrayList<Graphic> monsterList) {
		return;
	}
	
	public void changeMonsters(int i){
		if(invisWall == true){
			if(i == 1){
				if(monID % 6 == 5 && monID < Monster.returnNames().size()){
					monsterImg6.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID++;
				}
				if(monID % 6 == 4 && monID < Monster.returnNames().size()){
					monsterImg5.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID++;
				}
				if(monID % 6 == 3 && monID < Monster.returnNames().size()){
					monsterImg4.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID++;
				}
				if(monID % 6 == 2 && monID < Monster.returnNames().size()){
					monsterImg3.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID++;
				}
				if(monID % 6 == 1 && monID < Monster.returnNames().size()){
					monsterImg2.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID++;
				}
				if(monID % 6 == 0 && monID < Monster.returnNames().size()){
					monsterImg1.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID++;
				}
			}	
			if(i == 0){
				if(monID % 6 == 0 && monID > 0){
					monsterImg1.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID--;
				}
				if(monID % 6 == 1 && monID > 0){
					monsterImg2.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID--;
				}
				if(monID % 6 == 2 && monID > 0){
					monsterImg3.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID--;
				}
				if(monID % 6 == 3 && monID > 0){
					monsterImg4.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID--;
				}
				if(monID % 6 == 4 && monID > 0){
					monsterImg5.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					description = new TextArea((monID*100)+250,(100*i)+200,800,100,getDesc());
					viewObjects.add(description);
					monID--;
				}
				if(monID % 6 == 5 && monID > 0){
					monsterImg6.loadImages(main.MonsterGraphic.getMonster(getSpecies(monID)),1);
					
					monID--;
				}
			}
		}	
		
	}

	
	public ArrayList<monsterDex.MonsterGraphic> getMonsters() {
		return null;
	}
	
	public void SetDescription(String des) {
		
		
	}
	
	public void run() {
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

	public void use() {
		// TODO Auto-generated method stub
		
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
