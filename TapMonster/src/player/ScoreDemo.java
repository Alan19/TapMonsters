/**
 * 
 */
package player;

import guiPractice.GUIApplication;

/**
 * @author Joyce
 *
 */
public class ScoreDemo extends GUIApplication {

	
	
	/**
	 * 
	 */
	public ScoreDemo() {
		
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		ScoreScreen screen = new ScoreScreen(getWidth(), getHeight());
		setScreen(screen);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScoreDemo demo = new ScoreDemo();
		Thread app = new Thread(demo);
		app.start();

	}

}
