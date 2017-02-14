package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.MovingComponent;
import guiPractice.components.Visible;

/**
 * @author max
 *
 */

public class KLDebugScreen extends Screen implements KeyListener {
	
	private MovingComponent mc;

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
//			System.out.println("Right key pressed");
			mc.setVx(10);
		}
		else if(k.getKeyCode() == KeyEvent.VK_LEFT){
//			System.out.println("Left key pressed");
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



}
