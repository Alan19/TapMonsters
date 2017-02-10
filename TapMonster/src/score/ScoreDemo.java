package score;

import guiPractice.GUIApplication;

/**
 * @author Joyce
 *
 */
public class ScoreDemo extends GUIApplication {

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

	public static void main(String[] args) {
		ScoreDemo demo = new ScoreDemo();
		Thread app = new Thread(demo);
		app.start();

	}

}
