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

public class SequenceScreen extends Screen implements KeyListener{

	public static int x = 50;
	public static int y = 50;
	public static int w = 50;
	public static int h = 50;
	
	private static Graphic arrowUp = new Graphic(x, y, w, h, "src/sequenceArrows/arrowUp.jpg");
	private static Graphic arrowDown = new Graphic(x, y, w, h, "src/sequenceArrows/arrowDown.jpg");
	private static Graphic arrowLeft = new Graphic(x, y, w, h, "src/sequenceArrows/arrowLeft.jpg");
	private static Graphic arrowRight = new Graphic(x, y, w, h, "src/sequenceArrows/arrowRight.jpeg");
	
	private static Sequence s = new Sequence(10);
	private static ArrayList<String> playerMatch = new ArrayList<String>();
	
	private static Graphic playerChoice; 
	private static TextLabel text;
	
	public SequenceScreen(int width, int height) {
		super(width, height);
	}
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		int length;
		if (s.getSequence().size() > 4) length = 4;
		else length = s.getSequence().size();
		for (int i = 0; i < length; i++){
			if (s.getSequence().get(i) == 0){
				viewObjects.add(new Graphic(x, y, w, h, "src/sequenceArrows/arrowUp.jpg"));
				playerMatch.add("W");
			}
			if (s.getSequence().get(i) == 1){
				viewObjects.add(new Graphic(x, y, w, h, "src/sequenceArrows/arrowRight.jpeg"));
				playerMatch.add("D");
			}
			if (s.getSequence().get(i) == 2){
				viewObjects.add(new Graphic(x, y, w, h, "src/sequenceArrows/arrowDown.jpg"));
				playerMatch.add("S");
			}
			if (s.getSequence().get(i) == 3){
				viewObjects.add(new Graphic(x, y, w, h, "src/sequenceArrows/arrowLeft.jpg"));
				playerMatch.add("A");
			}
			x+=60;
			System.out.print(playerMatch.get(i));
		}
		x = 50;
		y += 100;
	}

	public void keyPressed(KeyEvent e) {
		if (playerChoice != null) remove(playerChoice);
		if (e.getKeyCode() == KeyEvent.VK_W){
			playerChoice = new Graphic(x, y, w, h, "src/sequenceArrows/arrowUp.jpg");
			addObject(playerChoice);
		}
		if (e.getKeyCode() == KeyEvent.VK_D){
			playerChoice = new Graphic(x, y, w, h, "src/sequenceArrows/arrowRight.jpeg");
			addObject(playerChoice);
		}
		if (e.getKeyCode() == KeyEvent.VK_S){
			playerChoice = new Graphic(x, y, w, h, "src/sequenceArrows/arrowDown.jpg");
			addObject(playerChoice);
		}
		if (e.getKeyCode() == KeyEvent.VK_A){
			playerChoice = new Graphic(x, y, w, h, "src/sequenceArrows/arrowLeft.jpg");
			addObject(playerChoice);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (Character.toLowerCase(playerMatch.get(0).charAt(0)) == Character.toLowerCase(e.getKeyChar())){
			s.getSequence().remove(0);
			playerMatch.remove(0);
			viewObjects.remove(0);
		}else{
			
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
	public KeyListener getKeyListener(){
		return this;
	}
}
