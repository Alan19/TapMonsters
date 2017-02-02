/**
 * 
 */
package main;

import guiPractice.GUIApplication;
import rewards.Reward;

/**
 * @author Alan19
 *
 */
@SuppressWarnings("serial")
public class TapMonster extends GUIApplication {

	/**
	 * Static Fields
	 */

	private static TapMonster game;
	private static Thread go;
	public static Reward[] allRewards;

	public TapMonster() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		allRewards = Reward.getAllRewards();
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
