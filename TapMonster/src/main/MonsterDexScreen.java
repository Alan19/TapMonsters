package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import MonsterDex.MonsterGraphic;
import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import interfaces.MonDexInterface;
import main.TapMonsterGame;

public class MonsterDexScreen extends ClickableScreen implements Runnable{
	
	private static ArrayList<MonDexInterface> Monsters;
	private Button Next;
	private Button Back;
	private Graphic Background;
	private static Graphic MonsterImg;
	private static TextArea Description;
	private TextLabel Name;
	
	private static int PosX = 100;
	private static int PosY = 100;
	private int MonID = 1;
	private Button back;
	
	public MonsterDexScreen(int width,int height) {
		super(width, height);
//		Thread play = new Thread(this);
//		play.start();
	}

	private Graphic getMonster() {
		MonID++;
		return new MonsterGraphic(PosX, PosY, 100, 100, MonID);
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Next = new Button(getWidth() - 110, getHeight() - 70, 90, 50, "Next", Color.decode("#a52a2a"), new Action() {
			public void act() {
				//put action here
			}
		});
		Back = new Button(20, getHeight() - 70, 90, 50, "Back", Color.decode("#a52a2a"), new Action() {
			public void act() {
				MonsterImg.loadImages( "src/MonsterSprites/"+MonID+++".gif", MonsterImg.getWidth(), MonsterImg.getHeight());
			}
		});
		back = new Button(10,10,100,50, "Back", Color.red, new Action(){
			public void act(){
				TapMonsterGame.game.setScreen(TapMonsterGame.main);
			}
		});
		Background = new Graphic(0,0,getWidth(),getHeight(),"src/resources/background.jpg");
		MonsterImg = getMonster();
		viewObjects.add(Background);
		viewObjects.add(Next);
		viewObjects.add(Back);	
		viewObjects.add(MonsterImg);
		viewObjects.add(back);
	}
	

}