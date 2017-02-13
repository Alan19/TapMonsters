/**
 * 
 */
package main;


import guiPractice.GUIApplication;


/**
 * @author Student 8
 *
 */
public class MahinDemo extends GUIApplication {

	//public static Reward reward;
	/**
	 * 
	 */
	public MahinDemo(int width, int height) {
		super(width, height);
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		//DemoScreen demo = new DemoScreen(getWidth(),getHeight());
		//setScreen(demo);
		
		InventoryScreen demo = new InventoryScreen(getWidth(), getHeight());
		setScreen(demo);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MahinDemo demo = new MahinDemo(300,300);
		Thread app = new Thread(demo);
		app.start();

	}

}
