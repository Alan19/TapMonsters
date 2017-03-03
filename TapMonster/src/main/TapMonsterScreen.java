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
	private static double timeAlter;
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
	private static ArrayList<Reward> rewardPool = new ArrayList<Reward>();
	private static ArrayList<Reward> listOfRewards = new ArrayList<Reward>();
	private static Reward rewardObject;
	private static Reward[] rewardList;
	public static boolean setWasSequenceCompleted;
	
	private boolean wasSequenceCompleted;
	private boolean sequenceNotCompleted;
	private boolean running = true;

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
	
	public void increaseTimeLeft(double i){
		this.timeLeft += i;
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
		while(running == true){
			changeText("Ready");
			changeText("Set...");
			changeText("Go!");
			changeText("");
			title.setText("TAP MONSTERS");
			timer(timeAlter);
		}
		System.out.println("It has stopped");
		running = true;
	}
	
	void timer(double effect){
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
			if(timeLeft>=0 &&timeLeft<=0.2||hp==0){
				TapMonsterGame.death =  new DeathScreen(getWidth(), getHeight());
				TapMonsterGame.game.setScreen(TapMonsterGame.death);
			}
			timeLeft = timeLeft-.1*effect;
			time.setText(""+(int)(timeLeft*10)/10.0);
			if(effect==0.5){
				if(25<=timeLeft&&timeLeft<=30)time.setText(""+(int)(timeLeft*10.)/10.0);
				if(0<=timeLeft&&timeLeft<=5)time.setText(""+(int)(timeLeft*10.)/10.0);
			}else if(effect==2.0){
				if(timeLeft>=19.8 && timeLeft<20.0 || timeLeft>=9.8 && timeLeft<10.0){
					hp= hp-25;
					hpBar.hpDecrease(25);
					System.out.println("DECREASE HP");
					
				}
			}
		}
		if(timeLeft>=0.0 && timeLeft<=0.2 || timeLeft < 0.0){
			time.setText("0.0");
			running = false;
		}
		}
	
//	time.setText(""+timeLeft);
//	while(timeLeft>0.0){
//		if(setWasSequenceCompleted){
//			timeLeft = 0.0;
//			time.setText("0.0");
//		}
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		if(timeLeft>=0 &&timeLeft<=0.2||hp==0)TapMonsterGame.game.setScreen(TapMonsterGame.death);
//		timeLeft = timeLeft-.1*effect;
//		if(effect==0.5){
//			if(25<=timeLeft&&timeLeft<=30)time.setText(""+(int)(timeLeft*10.)/10.0);
//			if(0<=timeLeft&&timeLeft<=5)time.setText(""+(int)(timeLeft*10.)/10.0);
//		}else if(effect==2.0){
//			if(timeLeft>=19.8 && timeLeft<20.0 || timeLeft>=9.8 && timeLeft<10.0){
//				hpBar.hpDecrease(25);
//				System.out.println("DECREASE HP");
//				
//				if(timeLeft>=0.0 && timeLeft<=0.2)time.setText("0.0");}}
//		else if(effect==1.0){
//			time.setText(""+(int)(timeLeft*10)/10.0);
//		}else if(timeLeft>=0.0 && timeLeft<=0.2){
//			time.setText("0.0");
//		}else time.setText(""+(int)(timeLeft*10)/10.0);
//		}
	

	
	private Monster getName() {
		return new Monster(this,getWidth()/2-50,100);
	}
	
	public void goToMonsterDex(){
		TapMonsterGame.game.setScreen(TapMonsterGame.monsterdex);
	}
	

	public void addButtons(){
		timerBackground = new Button(40,getHeight()-150,75,60,"TIMER",new Color(153,153,153), null);
		nextLevel = new Button(getWidth()-150,75,130,40,"NEXT LEVEL",new Color(153,153,153), new Action() {

			public void act() {
				TapMonsterGame.newFightScreen();
				timeLeft = 30.0;
				running = false;
				run();
			}
		});
		prestige = new Button(getWidth()-150,25,150,40,"MONSTERDEX",new Color(153,153,153), new Action() {

			public void act() {
				goToMonsterDex();
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

				resetTimer();
				TapMonsterGame.game.setScreen(TapMonsterGame.fightScreen);
				
			}
		});

	}

	public void addAMonster(){
		monster = getName();
		Monster.usablity();
		Monster.description();
	}

	public void decreaseLife() {
		setTimeAlter(2.0);
		System.out.println(Monster.description());
	}

	public void addBossSequence() {
		//Max needs to add the boss sequence here
		setTimeAlter(2.0);
		System.out.println(Monster.description());
	}

	public void speedTimer() {
		setTimeAlter(7.5);
		System.out.println("Speed timer");
		System.out.println(Monster.description());

	}

	public void freezeTimer() {
		setTimeAlter(0.5);
		System.out.println(Monster.description());

	}
	
	public void stopTimer() {
		setTimeAlter(0.0);
	}
	
	public void resetTimer() {
		setTimeAlter(1.0);
	}

	public void nothing() {
		setTimeAlter(1.0);
		System.out.println(Monster.description());
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		score = new Score(50,50);
		//scoreOnScreen = new TextLabel(score.getX(), score.getY(), score.getWidth(), score.getHeight(), Integer.toString(score.score));
		hpBar = new HitPoints(50,100);
		background = new Graphic(0,0,0.75,"src/JaviyDemo/background.jpg");
		viewObjects.add(background);
		hp = 50;
		rewardList = Reward.getAllRewards();
		rewardPool.add(rewardList[0]);
		for (int i = 0; i < rewardList.length; i++){
			rewardPool.add(rewardList[i]);
			System.out.println(""+rewardPool.get(i).getDescription());
		}
		System.out.println(""+ rewardPool.get(8).getDescription());
		gold = 0;
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
		viewObjects.add(reward);
		viewObjects.add(hpBar);
		viewObjects.add(score);
		
		stopTimer();
		resetTimer();
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
		System.out.println("This added health");
		System.out.println("" + hp);
		hpBar.hpDecrease(0-i);
		if (hpBar.getHP() > hpBar.getMax()){
			hpBar.hpDecrease(hpBar.getHP() - hpBar.getMax());
		}
		update();
	}

	public void getGold(int i) {
		gold += i;
		
	}
	
	public int getGoldVar(){
		return this.gold;
	}
	
	public void setGold(int i){
		this.gold = i;
	}

	public void increaseScore(int i) {
		score.addReward(i);
		
	}

	public int giveHpMax() {
		return hpBar.getMax();
	}
	
	public void setRandomReward(){
		
		int randNum = (int) (Math.random() * rewardPool.size());
		rewardObject = rewardPool.get(randNum);
		if (!rewardObject.getUniqueness()){
			rewardPool.remove(randNum);
		}
		listOfRewards.add(rewardObject);
		listOfRewards.get(0).takeEffect(TapMonsterGame.main);
		reward.setText(""+rewardObject.getDescription());
		
	}
	
	public void setRandomGold(){
		int goldNum = (int) (Math.random() * 10 + 1);
		if (goldNum <= 6){
			rewardObject = rewardPool.get(8);
		}
		else if (goldNum <= 9){
			rewardObject = rewardPool.get(9);
		}
		else{
			rewardObject = rewardPool.get(10);
		}
		rewardObject.takeEffect(TapMonsterGame.main);
	}
	
	

	public static double getTimeAlter() {
		return timeAlter;
	}

	public void setTimeAlter(double timeAlter) {
		this.timeAlter = timeAlter;
	}

	
	
}
