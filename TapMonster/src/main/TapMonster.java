package main;

import java.util.ArrayList;

import artifacts.Artifact;
import guiPractice.GUIApplication;
import rewards.Reward;

import guiPractice.GUIApplication;
public class TapMonster extends GUIApplication {

	/**
	 * Static Fields
	 */
	/**
	 * Static Fields
	 */

//	private static TapMonster game;
//	private static Thread go;
//	public static ArrayList<Artifact> artifacts;
//	public static ArrayList<Artifact> store;
	public static ArrayList<Artifact> inventory;
//	public static ArrayList<Monster> monsters;
//	public static ArrayList<Monster> bosses;
//	public static Reward[] allRewards;

	public TapMonster() {
		// TODO Auto-generated constructor stub
		this.inventory = inventory;
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		//allRewards = Reward.getAllRewards(); //gets rewards from rewards class (sam)
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		game = new TapMonster();
//		go = new Thread(game);
//		go.run();
	}

}