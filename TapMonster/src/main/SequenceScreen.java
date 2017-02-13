package main;

import java.awt.Color;
import java.awt.Graphics2D;
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
	private static ArrayList<String> playerMatch = new ArrayList<String>();
	
	public SequenceScreen(int width, int height) {
		super(width, height);
	}
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		for (int i = 0; i < s.getSequence().size(); i++){
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
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W){
			addObject(new Graphic(x, y, w, h, "src/sequenceArrows/arrowUp.jpg"));
			System.out.println("D");
		}
	}
	public KeyListener getKeyListener(){
		return this;
	}
}
/**public class KLDebugScreen extends Screen implements KeyListener {

private MovingComponent mc;
private TextLabel label;

public KLDebugScreen(int width, int height) {
	super(width, height);

}

@Override
public void initObjects(ArrayList<Visible> viewObjects) {
	mc = new MovingComponent(30,30,100,100) {
		
		@Override
		public void drawImage(Graphics2D g) {
			g.setColor(Color.red);
			g.drawRect(1, 1, 98, 98);
		}
		
		@Override
		public void checkBehaviors() {
			// TODO Auto-generated method stub
			
		}
	};
	viewObjects.add(mc);
	mc.play();

}

@Override
public void keyPressed(KeyEvent k) {
	// TODO Auto-generated method stub
	if(k.getKeyCode() == KeyEvent.VK_RIGHT){
		System.out.println("Right key pressed");
		mc.setVx(10);
	}
	else if(k.getKeyCode() == KeyEvent.VK_LEFT){
		System.out.println("Left key pressed");
		mc.setVx(-10);
	}
}

@Override
public void keyReleased(KeyEvent k) {
	if(k.getKeyCode() == KeyEvent.VK_RIGHT){
		mc.setVx(0);
	}
	else if(k.getKeyCode() == KeyEvent.VK_LEFT){
		mc.setVx(0);
	}
}

@Override
public void keyTyped(KeyEvent arg0) {
}

public KeyListener getKeyListener(){
	return this;
}



}*/