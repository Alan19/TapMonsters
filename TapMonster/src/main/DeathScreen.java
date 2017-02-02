/**
 * 
 */
package main;

import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Clickable;
import guiPractice.components.Visible;

/**
 * @author Alan19
 *
 */
public class DeathScreen extends Screen implements Visible, Clickable, Runnable{

	/**
	 * @param width
	 * @param height
	 */
		
	private Thread app;
	
	public DeathScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	/* (non-Javadoc)
	 * @see guiPractice.components.Visible#getX()
	 */
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see guiPractice.components.Visible#getY()
	 */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see guiPractice.components.Visible#isAnimated()
	 */
	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see guiPractice.Screen#initObjects(java.util.ArrayList)
	 */
	@Override
	public void initObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
