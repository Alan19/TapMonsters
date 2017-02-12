/**
 * 
 */
package main;

import guiPractice.GUIApplication;

/**
 * @author swk11
 *
 */
public class SimonDemo extends GUIApplication {
	public static IntroScreen intro;

	public SimonDemo() {
		super(500,500);
		intro = new IntroScreen(600,500);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimonDemo demo = new SimonDemo();
		Thread app = new Thread(demo);
		app.start();

	}

	@Override
	protected void initScreen() {
		IntroScreen intro = new IntroScreen(600,500);
		setScreen(intro);
		
	}

}
