/**
 * 
 */
package main;

import guiPractice.GUIApplication;

/**
 * @author swk11
 *
 */
public final class SimonDemo extends GUIApplication {
	public static IntroScreen intro;

	public SimonDemo(int width, int height) {
		super(width,height);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimonDemo demo = new SimonDemo(1000,500);
		Thread app = new Thread(demo);
		app.start();

	}

	@Override
	protected void initScreen() {
		IntroScreen intro = new IntroScreen(getWidth(),getHeight());
		setScreen(intro);
		
	}

}
