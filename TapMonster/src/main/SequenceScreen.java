package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice.Screen;
import guiPractice.components.Graphic;
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
	
	public SequenceScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
//	public static void main(String[] args){
//		System.out.print(s.getSequence().size());
//	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		for (int i = 0; i < s.getSequence().size(); i++){
			if (s.getSequence().get(i) == 0){
				viewObjects.add(new Graphic(x, y, w, h, "src/sequenceArrows/arrowUp.jpg"));
				x+=60;
			}
			if (s.getSequence().get(i) == 1){
				viewObjects.add(new Graphic(x, y, w, h, "src/sequenceArrows/arrowRight.jpeg"));
				x+=60;
			}
			if (s.getSequence().get(i) == 2){
				viewObjects.add(new Graphic(x, y, w, h, "src/sequenceArrows/arrowDown.jpg"));
				x+=60;
			}
			if (s.getSequence().get(i) == 3){
				viewObjects.add(new Graphic(x, y, w, h, "src/sequenceArrows/arrowLeft.jpg"));
				x+=60;
			}
		}
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
