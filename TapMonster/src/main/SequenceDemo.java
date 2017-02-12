package main;

import guiPractice.GUIApplication;
import player.ScoreDemo;
import player.ScoreScreen;

public class SequenceDemo extends GUIApplication{

	public SequenceDemo(int width2, int height2) {
		super(width2, height2);
		// TODO Auto-generated constructor stub
	}

	protected void initScreen() {
		SequenceScreen screen = new SequenceScreen(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		ScoreDemo demo = new ScoreDemo();
		Thread app = new Thread(demo);
		app.start();

	}

}
