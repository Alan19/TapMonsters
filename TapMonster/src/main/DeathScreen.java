/**
 * 
 */
package main;

import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Clickable;
import guiPractice.components.Visible;

/**
 * @author Student8
 *
 */
public class DeathScreen extends Screen implements Visible , Clickable{

	/**
	 * @param width
	 * @param height
	 */
	public DeathScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
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

}
