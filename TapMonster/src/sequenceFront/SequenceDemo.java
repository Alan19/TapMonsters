package sequenceFront;

import guiPractice.GUIApplication;
import score.ScoreDemo;

public class SequenceDemo extends GUIApplication{



	public SequenceDemo(int width2, int height2) {
		super(width2, height2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		SequenceScreen screen = new SequenceScreen(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		SequenceDemo demo = new SequenceDemo(800, 600);
		Thread app = new Thread(demo);
		app.start();

	}
}
