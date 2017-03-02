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
import rewards.Reward;
import rewards.RewardTarget;

public class TapMonsterScreen extends ClickableScreen implements Runnable,Game,RewardTarget{

	private TextLabel title;
	private TextLabel monsterName;
	private MonsterName monster;
	private Graphic monsterImg;
	private double timeLeft;
	

	private TextLabel time;
	private TextLabel reward;
	private double timeAlter;
	private TextLabel stage;
	private int stageLevel;//must implement a method to increase this after each time you press next level
	private int timeBonus;
	private Button nextLevel;
	private Button prestige;
	private Button store;
	private int gold;
	private Button inventoryButton;
	private Button timerBackground;
	private Button fightButton;
	
	private Graphic background;
	private int hp;
	private int round = 0;
	private HitPoints hpBar;
	public static Score score;
	//public static TextLabel scoreOnScreen;
	private Reward[] rewardList;
	private static Reward rewardObject;
	public static boolean setWasSequenceCompleted;
	
	private boolean wasSequenceCompleted;

	//DOETWAC00M001vl50g


	public void setWasSequenceCompleted(boolean wasSequenceCompleted) {
		this.wasSequenceCompleted = wasSequenceCompleted;
	}

	public TapMonsterScreen(int width,int height) {
		super(width, height);
		timeLeft = 30.0;
		Thread app = new Thread(this);
		app.start();
	}
	
	public double getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(double timeLeft) {
		this.timeLeft = timeLeft;
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
			if(setWasSequenceCompleted){
				timeLeft = 0.0;
				time.setText("0.0");
			}
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
				wasSequenceCompleted = false;
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
		fightButton = new Button(getWidth()-150,225,130,40,"FIGHT",new Color(153,153,153), new Action() {

			public void act() {
				TapMonsterGame.game.setScreen(TapMonsterGame.fightScreen);
			}
		});

	}

	public void addAMonster(){
		monster = getName();
		Monster.usablity();
		Monster.description();
		if(round == 0){
			monsterImg = new Graphic(100,100,100,100,main.MonsterGraphic.getMonster(getSpecies(round)));
			MonsterDexScreen.monsters.add(monsterImg);
			round++;
		}else{
			monsterImg.loadImages(main.MonsterGraphic.getMonster("Beast"), 100, 100);
			MonsterDexScreen.monsters.add(monsterImg);
			round++;
		}
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
		//scoreOnScreen = new TextLabel(score.getX(), score.getY(), score.getWidth(), score.getHeight(), Integer.toString(score.score));
		hpBar = new HitPoints(50,100);
		background = new Graphic(0,0,0.75,"src/JaviyDemo/background.jpg");
		viewObjects.add(background);
		hp = 100;
		gold = 0;
		rewardList = Reward.getAllRewards();
		timeBonus = 0;
		time = new TextLabel(40,getHeight()-175,75,60,"");
		reward = new TextLabel(getWidth()/2-100,getHeight()/2-100,getWidth()/2-100,getHeight()/2-300,"");
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
		viewObjects.add(fightButton);
		viewObjects.add(monster);
		viewObjects.add(monsterImg);
		viewObjects.add(reward);
		viewObjects.add(hpBar);
		viewObjects.add(score);
	}

	public void earnReward(Reward r) {
		// TODO Auto-generated method stub
		
	}

	public void increaseHearts(int i) {
		hpBar.changeMax(i);
		
	}

	public void increaseTimer(int i) {
		timeBonus += i;
		
	}

	public void fillHeart(int i) {
		hp += i;
		if (hp > hpBar.getMax()){
			hp = hpBar.getMax();
		}
	}

	public void getGold(int i) {
		gold += i;
		
	}

	public void increaseScore(int i) {
		score.addReward(i);
		
	}

	public int giveHpMax() {
		return hpBar.getMax();
	}
	
	public void setRandomReward(){
		int rewardTier = 0;
		int probNum = (int) (Math.random() * 10 +1);
		if (probNum <= 6){
			rewardTier = 0;
		}
		else if (probNum <= 9){
			rewardTier = 1;
		}
		else{
			rewardTier = 2;
		}
		if (rewardTier == 0){
			int randNum = (int) (Math.random() * 2);
			rewardObject = rewardList[randNum];
		}
		else if (rewardTier == 1){
			int randNum = (int) (Math.random() * 2+2);
			rewardObject = rewardList[randNum];
		}
		else{
			int randNum = (int) (Math.random() * 4+4);
			rewardObject = rewardList[randNum];
		}
		TapMonsterGame.main.rewardObject.takeEffect(TapMonsterGame.main);
		reward.setText(""+rewardObject.getDescription());
		
	}
	
	public void setRandomGold(){
		int goldNum = (int) (Math.random() * 10 + 1);
		if (goldNum <= 6){
			rewardObject = rewardList[8];
		}
		else if (goldNum <= 9){
			rewardObject = rewardList[9];
		}
		else{
			rewardObject = rewardList[10];
		}
		TapMonsterGame.main.rewardObject.takeEffect(TapMonsterGame.main);
	}
	
	private String getSpecies(int monID) {
		String x = Monster.returnNames().get(monID);
		String[] y = x.split("");
		return y[3];
	}
	
}