package main;

import guiPractice.GUIApplication;
import player.ScoreDemo;
import player.ScoreScreen;

public class SequenceDemo extends GUIApplication{

	public SequenceDemo(int width2, int height2) {
		super();
		// TODO Auto-generated constructor stub
	}

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
