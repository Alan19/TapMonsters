package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

/**
 * @author max
 *
 */

public class KLDebugScreen extends Screen implements KeyListener {
	
	private TextLabel label;

	public KLDebugScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}
	
	public KeyListener getKeyListener(){
		return this;
	}

}
