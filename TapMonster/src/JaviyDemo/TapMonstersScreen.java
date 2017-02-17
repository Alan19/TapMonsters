package JaviyDemo;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickGraphicsScreen;

public class TapMonstersScreen extends ClickGraphicsScreen implements Runnable,Game{

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
	private Button inventory;
	private Button timerBackground;
	private Graphic background;
	private TextLabel hitPoints;
	private int hp;

	//DOETWAC00M001vl50g

	public TapMonstersScreen(int width,int height) {
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

	@Override
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
		while(timeLeft>0){
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
				if(timeLeft%10==0){
					hp = hp-10;
					//updateHp(viewObjects);
					time.setText(""+(int)(timeLeft*10.)/10.0);
				}else{
					time.setText(""+(int)(timeLeft*10.)/10.0);
				}
			}
			else time.setText(""+(int)(timeLeft*10)/10.0);
		}
	}

//	public void updateHp(List<Visible> viewObjects){
//		hitPoints = new TextLabel(25,25,120,60,"HP " + hp);
//		viewObjects.add(hitPoints);
//	}
	
	private Monster getName() {
		return new Monster(this);
	}
	

	public void addButtons(){
		timerBackground = new Button(40,1000-150,75,60,"TIMER",new Color(153,153,153), null);
		nextLevel = new Button(1000-150,75,130,40,"NEXT LEVEL",new Color(153,153,153), new Action() {

			public void act() {
				//Resets the entire level after timer runs out
				if(timeLeft==0.0){

				}
				else return;
			}
		});
		prestige = new Button(1000-150,25,130,40,"PRESTIGE",new Color(153,153,153), new Action() {

			public void act() {
				//resets for the next level
			}
		});
		store = new Button(1000-150,125,130,40,"STORE",new Color(153,153,153), new Action() {

			public void act() {
				//goes to the store screen
			}
		});
		inventory = new Button(1000-150,175,130,40,"INVENTORY",new Color(153,153,153), new Action() {

			public void act() {
				//goes to the inventory screen
			}
		});

	}

	public void addAMonster(){
		monster = getName();
		Monster.usablity();
		Monster.description();
	}

	@Override
	public void decreaseLife() {
		timeAlter = 2.0;
		System.out.println(Monster.description());
	}

	@Override
	public void addBossSequence() {
		//Max needs to add the boss sequence here
		timeAlter = 1.0;
		System.out.println(Monster.description());
	}

	@Override
	public void speedTimer() {
		timeAlter = 7.5;
		System.out.println("Speed timer");
		System.out.println(Monster.description());

	}

	@Override
	public void freezeTimer() {
		timeAlter = 0.5;
		System.out.println(Monster.description());

	}

	@Override
	public void nothing() {
		timeAlter = 1.0;
		System.out.println(Monster.description());
	}

	public void initAllObjects(ArrayList<Visible> viewObjects) {
		background = new Graphic(0,0,.5,"resources/images/background.jpg");
		viewObjects.add(background);
		hp = 100;
		stageLevel = 1;
		title = new TextLabel(1000/2-60,20,300,40,"TAP MONSTERS");
		time = new TextLabel(40,1000-150,75,60,"");
		hitPoints = new TextLabel(25,25,120,60,"HP " + hp);
		stage = new TextLabel(1000/2-50,30,120,60,"STAGE " + stageLevel);
		addAMonster();
		addButtons();
		viewObjects.add(title);
		viewObjects.add(stage);
		viewObjects.add(hitPoints);
		viewObjects.add(timerBackground);
		viewObjects.add(time);
		viewObjects.add(nextLevel);
		viewObjects.add(prestige);
		viewObjects.add(store);
		viewObjects.add(inventory);
		viewObjects.add(monster);
	}
	
}


