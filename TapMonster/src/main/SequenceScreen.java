package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import guiPractice.Screen;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class SequenceScreen extends Screen implements KeyListener{

	private int x = 0;
	private int y = 0;
	private int w = 50;
	private int h = 50;
	
	private Graphic arrowUp = new Graphic(x, y, w, h, "sequenceArrows/arrowUp.jpg");
	private Graphic arrowDown = new Graphic(x, y, w, h, "sequenceArrows/arrowDown.jpg");
	private Graphic arrowLeft = new Graphic(x, y, w, h, "sequenceArrows/arrowLeft.jpg");
	private Graphic arrowRight = new Graphic(x, y, w, h, "sequenceArrows/arrowRight.jpeg");
	
	private Sequence s = new Sequence(10);
	
	public SequenceScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		for (int i = 0; i < s.getSequence().size(); i++){
			if (s.getSequence().get(i) == 1){
				viewObjects.add(arrowUp);
				x+=100;
			}
			if (s.getSequence().get(i) == 2){
				viewObjects.add(arrowRight);
				x+=100;
			}
			if (s.getSequence().get(i) == 3){
				viewObjects.add(arrowDown);
				x+=100;
			}
			if (s.getSequence().get(i) == 4){
				viewObjects.add(arrowLeft);
				x+=100;
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
