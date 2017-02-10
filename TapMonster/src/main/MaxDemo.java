package main;

import guiPractice.GUIApplication;

/**
 * @author max
 *
 */
public class MaxDemo extends GUIApplication {

	public MaxDemo(int w, int h) {
		super(w,h);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		KLDebugScreen demoS = new KLDebugScreen(getWidth(), getHeight());
		setScreen(demoS);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDemo demo = new MaxDemo(800,600);
		Thread app = new Thread(demo);
		app.start();
	}

}
