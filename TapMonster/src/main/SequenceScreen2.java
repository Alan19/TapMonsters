package main;
/**
 * @author Joyce
 * @author Max
 * 
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice.Screen;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import interfaces.Attack;
import interfaces.KeysToPlayer;
//check why the sequence is disappearing quicker than playersequence
//do this by displaying playersequence and matchign up
public class SequenceScreen2 extends Screen implements KeyListener, KeysToPlayer, Attack {

	public static int sequencex = 50;
	public static int playerx = 100;
	public static int y = 50;
	public static int w = 50;
	public static int h = 50;
	

	public int playery = y+100;

	private static Graphic arrowUp = new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowUp.jpg");
	private static Graphic arrowDown = new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowDown.jpg");
	private static Graphic arrowLeft = new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowLeft.jpg");
	private static Graphic arrowRight = new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowRight.jpeg");

	private static Sequence s = new Sequence(10);
//	private static Sequence s;
	private static ArrayList<String> playerMatch = new ArrayList<String>();
//	private static ArrayList<String> playerMatch;
	private static ArrayList<Graphic> displayedSequence = new ArrayList<Graphic>();
//	private static ArrayList<Graphic> displayedSequence;

	private static Graphic playerChoice; 
	private static TextLabel text;
	private static int idx = 0;
	private static int ctr = 0;

	
	private static int lng = 0;
	private static int round = 0;
	
	private Graphic background;
	private Graphic monsterImg;

	public static Player p = new Player(200,200);

	public SequenceScreen2(int width, int height) {
		super(width, height);
		p.setX(getWidth()/2);
		p.setY(getHeight()/2+100);
//		s = new Sequence(10);
		setIdx(0);
		ctr = 0;
		lng = s.getSequence().size();
		
//		playerMatch = new ArrayList<String>();
//		displayedSequence = new ArrayList<Graphic>();
//		initObjects(viewObjects);
		 
	}

	public void addToDisplayedSequence(int numOfTimes){
		for (int i = 0; i < numOfTimes; i++){
			if (s.getSequence().get(getIdx()) == 0){
				displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowUp.jpg"));
				playerMatch.add("W");
			}
			if (s.getSequence().get(getIdx()) == 1){
				displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowRight.jpeg"));
				playerMatch.add("D");
			}
			if (s.getSequence().get(getIdx()) == 2){
				displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowDown.jpg"));
				playerMatch.add("S");
			}
			if (s.getSequence().get(getIdx()) == 3){
				displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowLeft.jpg"));
				playerMatch.add("A");
			}
			sequencex+=60;
				System.out.println(sequencex);
//			if (idx < s.getSequence().size() ){
			if (getIdx() < lng){
				setIdx(getIdx() + 1);
			}
		}
	}

	public void addToViewObjects(int l){
		for(int i = 0 ; i < l; i++){
			viewObjects.add(displayedSequence.get(0));
			displayedSequence.remove(0);
		}
	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		background = new Graphic(0,0,0.75,"src/JaviyDemo/background.jpg");
		getMonster();
		viewObjects.add(background);
		viewObjects.add(monsterImg);
		int length = 4;
		System.out.println(s.getSequence());
		addToDisplayedSequence(length);
		addToViewObjects(length);
		viewObjects.add(p);
	}

	private void getMonster() {
		if(round == 0){
			monsterImg = new Graphic(getWidth()/2-50,getHeight()/2-100,150,150,main.MonsterGraphic.getMonster("Beast")); 
			
			round++;
		}else{
//			monsterImg.loadImages(main.MonsterGraphic.getMonster("Beast"), 100, 100);
			round++;
		}
	}

	private String getSpecies(int rounds) {
			String x = Monster.returnNames().get(rounds);
			String[] y = x.split("");
			return y[2];
	}

	public void keyPressed(KeyEvent e) {
		if (playerChoice != null) remove(playerChoice);
		if (e.getKeyCode() == KeyEvent.VK_W){
//			viewObjects.add(background);
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowUp.jpg");
			addObject(playerChoice);
			addObject(p);
			setMove(ATTACK);
		}
		if (e.getKeyCode() == KeyEvent.VK_D){
//			viewObjects.add(background);
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowRight.jpeg");
			addObject(playerChoice);
			addObject(p);
			setMove(DODGER);

		}
		if (e.getKeyCode() == KeyEvent.VK_S){
//			viewObjects.add(background);
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowDown.jpg");
			addObject(playerChoice);
			addObject(p);
			setMove(GUARD);
		}
		if (e.getKeyCode() == KeyEvent.VK_A){
//			viewObjects.add(background);
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowLeft.jpg");
			addObject(playerChoice);
			addObject(p);
			setMove(DODGEL);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (!playerMatch.isEmpty()){
//			viewObjects.remove(viewObjects.indexOf(p));
			if (Character.toLowerCase(playerMatch.get(0).charAt(0)) == Character.toLowerCase(e.getKeyChar())){
				playerMatch.remove(0);
				
				if (viewObjects.get(0).getImage() == background.getImage()) {
					viewObjects.remove(1);
				}
				else {
					
					viewObjects.remove(0);
				}
				viewObjects.remove(playerChoice);
				
				
				for (int i = 0; i < viewObjects.size(); i++){

					viewObjects.get(i).setX(viewObjects.get(i).getX() - 60);
				}
				sequencex = sequencex - 60;
				//				System.out.println(playerMatch);
				//				System.out.println(s.getSequence());
//				if(idx < s.getSequence().size()){
				if(getIdx() < lng){
					addToDisplayedSequence(1);

					addToViewObjects(1);

				}
				ctr++;
//				if (ctr == s.getSequence().size()){
				if (ctr >= 14){
					TapMonsterGame.main.setRandomGold();
					TapMonsterGame.main.setRandomReward();
					System.out.println("You've won!");
					TapMonsterScreen.setWasSequenceCompleted = true;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					TapMonsterGame.game.setScreen(TapMonsterGame.main);
//					TapMonsterGame.newFightScreen();
				}
				//				System.out.println("ctr = " + ctr + "");
				//				System.out.println("idx = " + idx + "");
			}
			else {
				System.out.println("Wrong");
			}
			p.setX(getWidth()/2);
			background.setX(0);
			viewObjects.add(playerChoice);
			playerChoice.setX(playerx);
			viewObjects.add(p);
		}
		for (int i = 0; i < viewObjects.size(); i++) {
			if (viewObjects.get(i).getClass() == arrowLeft.getClass() && viewObjects.get(i).getX() < 50 && viewObjects.get(i).getY() > 10 && viewObjects.get(i).getWidth() < 400) {
				viewObjects.remove(i);
			}
		}
			
	}
	

	

	public void keyTyped(KeyEvent e) {

	}
	public KeyListener getKeyListener(){
		return this;
	}

	public void setMove(int move) {
		// TODO Auto-generated method stub
		p.setMove(move);
	}

	public static int getIdx() {
		return idx;
	}

	public static void setIdx(int idx) {
		SequenceScreen2.idx = idx;
	}
}
