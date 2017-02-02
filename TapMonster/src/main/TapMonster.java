package main;

import java.util.ArrayList;

import guiPractice.GUIApplication;

public class TapMonster extends GUIApplication {

	/**
	 * Static Fields
	 */

	private static TapMonster game;
	private static Thread go;
	public static ArrayList<Artifact> artifacts;
	public static ArrayList<Artifact> store;
	public static ArrayList<Artifact> inventory;
	public static ArrayList<Monster> monsters;
	public static ArrayLi st<Monster> bosses;
	

	public TapMonster() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		game = new TapMonster();
		go = new Thread(game);
		go.run();
	}

}
