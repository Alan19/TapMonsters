package sequenceFront;

import guiPractice.GUIApplication;
import score.ScoreDemo;

public class SequenceDemo extends GUIApplication{

	public SequenceDemo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		SequenceScreen screen = new SequenceScreen(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		SequenceDemo demo = new SequenceDemo();
		Thread app = new Thread(demo);
		app.start();

	}
}
