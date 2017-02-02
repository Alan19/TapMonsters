/**
 * 
 */
package main;

import guiPractice.GUIApplication;

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
