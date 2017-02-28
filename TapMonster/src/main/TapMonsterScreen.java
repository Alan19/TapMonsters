package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import score.Score;

public class TapMonsterScreen extends ClickableScreen implements Runnable,Game{

	private TextLabel title;
	private TextLabel monsterName;
	private MonsterName monster;
	private double timeLeft;
	private TextLabel time;
	private double timeAlter;
	private TextLabel stage;
	private int stageLevel;//must implement a method to increase this after each time you press next level
	private Button nextLevel;
	private Button prestige;
	private Button store;
	private Button inventoryButton;
	private Button timerBackground;
	private Graphic background;
	private int hp;
	private HitPoints hpBar;
	private Score score;
	
	public static boolean wasSequenceCompleted = false;

	//DOETWAC00M001vl50g

	public TapMonsterScreen(int width,int height) {
		super(width, height);
		timeLeft = 30.0;
		Thread app = new Thread(this);
		app.start();
	}

	private void changeText(String string){
		try {
			Thread.sleep(1000);
			title.setText(string);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		changeText("Ready");
		changeText("Set...");
		changeText("Go!");
		changeText("");
		title.setText("TAP MONSTERS");
		timer(timeAlter);
	}

	private void timer(double effect){
		time.setText(""+timeLeft);
		while(timeLeft>0.0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timeLeft = timeLeft-.1*effect;
			if(effect==0.5){
				if(25<=timeLeft&&timeLeft<=30)time.setText(""+(int)(timeLeft*10.)/10.0);
				if(0<=timeLeft&&timeLeft<=5)time.setText(""+(int)(timeLeft*10.)/10.0);
			}else if(effect==2.0){
				if(timeLeft>=19.7 && timeLeft<20.0 || timeLeft>=9.7 && timeLeft<10.0){
					hpBar.hpDecrease(10);
					System.out.println("DECREASE HP");
					time.setText(""+(int)(timeLeft*10.)/10.0);
				}else if(timeLeft>=0.0 && timeLeft<=0.3){
					timeLeft = 0.0;
					time.setText(""+(int)(timeLeft*10.)/10.0);
				}else{
					time.setText(""+(int)(timeLeft*10.)/10.0);
				}
			}
			else time.setText(""+(int)(timeLeft*10)/10.0);
		}
	}
	
	private Monster getName() {
		return new Monster(this,getWidth()/2-50,100);
	}
	

	public void addButtons(){
		timerBackground = new Button(40,getHeight()-150,75,60,"TIMER",new Color(153,153,153), null);
		nextLevel = new Button(getWidth()-150,75,130,40,"NEXT LEVEL",new Color(153,153,153), new Action() {

			public void act() {
				//Resets the entire level after timer runs out
				if(timeLeft==0.0){

				}
				else return;
			}
		});
		prestige = new Button(getWidth()-150,25,150,40,"MONSTERDEX",new Color(153,153,153), new Action() {

			public void act() {
				TapMonsterGame.game.setScreen(TapMonsterGame.monsterdex);
			}
		});
		store = new Button(getWidth()-150,125,130,40,"STORE",new Color(153,153,153), new Action() {

			public void act() {
				TapMonsterGame.game.setScreen(TapMonsterGame.store);
			}
		});
		inventoryButton = new Button(getWidth()-150,175,130,40,"INVENTORY",new Color(153,153,153), new Action() {

			public void act() {
				TapMonsterGame.game.setScreen(TapMonsterGame.inventory);
			}
		});

	}

	public void addAMonster(){
		monster = getName();
		Monster.usablity();
		Monster.description();
	}

	public void decreaseLife() {
		timeAlter = 2.0;
		System.out.println(Monster.description());
	}

	public void addBossSequence() {
		//Max needs to add the boss sequence here
		timeAlter = 2.0;
		System.out.println(Monster.description());
	}

	public void speedTimer() {
		timeAlter = 7.5;
		System.out.println("Speed timer");
		System.out.println(Monster.description());

	}

	public void freezeTimer() {
		timeAlter = 0.5;
		System.out.println(Monster.description());

	}

	public void nothing() {
		timeAlter = 1.0;
		System.out.println(Monster.description());
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		score = new Score(50,50);
		hpBar = new HitPoints(50,100);
		background = new Graphic(0,0,0.75,"src/JaviyDemo/background.jpg");
		viewObjects.add(background);
		hp = 100;
		time = new TextLabel(40,getHeight()-175,75,60,"");
		stageLevel = 1;
		title = new TextLabel(getWidth()/2-60,20,300,40,"TAP MONSTERS");
	
		stage = new TextLabel(getWidth()/2-50,30,120,60,"STAGE " + stageLevel);
		addAMonster();
		addButtons();
		viewObjects.add(title);
		viewObjects.add(stage);

		viewObjects.add(timerBackground);
		viewObjects.add(time);
		viewObjects.add(nextLevel);
		viewObjects.add(prestige);
		viewObjects.add(store);
		viewObjects.add(inventoryButton);
		viewObjects.add(monster);
		viewObjects.add(hpBar);
		viewObjects.add(score);
	}
	
}
