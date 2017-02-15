package main;

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
//check why the sequence is disappearing quicker than playersequence
//do this by displaying playersequence and matchign up
public class SequenceScreen extends Screen implements KeyListener{

	public static int sequencex = 50;
	public static int playerx = 50;
	public static int y = 50;
	public static int w = 50;
	public static int h = 50;
	
	public int playery = y+100;
	
	private static Graphic arrowUp = new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowUp.jpg");
	private static Graphic arrowDown = new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowDown.jpg");
	private static Graphic arrowLeft = new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowLeft.jpg");
	private static Graphic arrowRight = new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowRight.jpeg");
	
	private static Sequence s = new Sequence(10);
	private static ArrayList<String> playerMatch = new ArrayList<String>();
	private static ArrayList<Graphic> displayedSequence = new ArrayList<Graphic>();
	
	private static Graphic playerChoice; 
	private static TextLabel text;
	private static int idx = 0;
	private static int ctr = 0;
	
	public SequenceScreen(int width, int height) {
		super(width, height);
	}
	
	public void addToDisplayedSequence(int numOfTimes){
			for (int i = 0; i < numOfTimes; i++){
				if (s.getSequence().get(idx) == 0){
					displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowUp.jpg"));
					playerMatch.add("W");
				}
				if (s.getSequence().get(idx) == 1){
					displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowRight.jpeg"));
					playerMatch.add("D");
				}
				if (s.getSequence().get(idx) == 2){
					displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowDown.jpg"));
					playerMatch.add("S");
				}
				if (s.getSequence().get(idx) == 3){
					displayedSequence.add(new Graphic(sequencex, y, w, h, "src/sequenceArrows/arrowLeft.jpg"));
					playerMatch.add("A");
				}
				sequencex+=60;
			//	System.out.println(sequencex);
				if (idx < s.getSequence().size() ) idx++;
		}
	}
	
	public void addToViewObjects(int l){
		for(int i = 0 ; i < l; i++){
			viewObjects.add(displayedSequence.get(0));
			displayedSequence.remove(0);
		}
	}
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		int length = 4;
		System.out.println(s.getSequence());
		addToDisplayedSequence(length);
		addToViewObjects(length);
	}

	public void keyPressed(KeyEvent e) {
		if (playerChoice != null) remove(playerChoice);
		if (e.getKeyCode() == KeyEvent.VK_W){
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowUp.jpg");
			addObject(playerChoice);
		}
		if (e.getKeyCode() == KeyEvent.VK_D){
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowRight.jpeg");
			addObject(playerChoice);
		}
		if (e.getKeyCode() == KeyEvent.VK_S){
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowDown.jpg");
			addObject(playerChoice);
		}
		if (e.getKeyCode() == KeyEvent.VK_A){
			playerChoice = new Graphic(playerx, playery, w, h, "src/sequenceArrows/arrowLeft.jpg");
			addObject(playerChoice);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (!playerMatch.isEmpty()){
			if (Character.toLowerCase(playerMatch.get(0).charAt(0)) == Character.toLowerCase(e.getKeyChar())){
				playerMatch.remove(0);
				viewObjects.remove(0);
				for (int i = 0; i < viewObjects.size() -1; i++){
						viewObjects.get(i).setX(viewObjects.get(i).getX() - 60);
					}
				sequencex = sequencex - 60;
//				System.out.println(playerMatch);
//				System.out.println(s.getSequence());
				if(idx < s.getSequence().size()){
					addToDisplayedSequence(1);
					
					addToViewObjects(1);
				}
				ctr++;
				if (ctr == s.getSequence().size()){
					System.out.println("You've won!");
				}
//				System.out.println("ctr = " + ctr + "");
//					System.out.println("idx = " + idx + "");
			}else{
				System.out.println("Wrong");
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
	public KeyListener getKeyListener(){
		return this;
	}
}
