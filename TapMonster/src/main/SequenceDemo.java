package main;
/**
 * @author Joyce
 *
 */
import guiPractice.GUIApplication;
import player.ScoreDemo;
import player.ScoreScreen;

public class SequenceDemo extends GUIApplication{

	public SequenceDemo(int width2, int height2) {
		super(height2, height2);
	}

	protected void initScreen() {
		SequenceScreen2 screen = new SequenceScreen2(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		SequenceDemo demo = new SequenceDemo(800, 600);
		Thread app = new Thread(demo);
		app.start();

	}

}
