/**
 * 
 */
package main;

import guiPractice.GUIApplication;

/**
 * @author max
 *
 */
public class MaxDemo extends GUIApplication {

	/**
	 * 
	 */
	public MaxDemo() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		KLDebugScreen demo = new KLDebugScreen(getWidth(), getHeight());
		setScreen(demo);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDemo demo = new MaxDemo();
		Thread app = new Thread(demo);
		app.start();
	}

}
