package score;

import guiPractice.GUIApplication;

/**
 * @author Joyce
 *
 */
public class ScoreDemo extends GUIApplication {


	public ScoreDemo(int width2, int height2) {
		super(width2, height2);
		// TODO Auto-generated constructor stub
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
		ScoreDemo demo = new ScoreDemo(0, 0);
		Thread app = new Thread(demo);
		app.start();

	}

}
