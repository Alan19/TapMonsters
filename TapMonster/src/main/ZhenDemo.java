/**
 * 
 */
package main;

import java.util.ArrayList;

import guiPractice.GUIApplication;

/**
 * @author Student8
 *
 */
@SuppressWarnings("serial")
public class ZhenDemo extends GUIApplication {

	public static DeathScreen death;
	
	/**
	 * 
	 */
	public ZhenDemo() {
		super(0, 0);
		death = new DeathScreen(getX(), getY(), 5, 5, new ArrayList<artifacts.Artifact>());
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		ArrayList<artifacts.Artifact> artifacts = new ArrayList<artifacts.Artifact>();
		DeathScreen deathScreen = new DeathScreen(0, 0, getWidth(), getHeight(), null);
		setScreen(deathScreen);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZhenDemo demo = new ZhenDemo();
		Thread app = new Thread(demo);
		app.start();
	}
	
	public void getReward() {
		
	}
	
	//nested inner class
//	private class DemoScreen extends ClickableScreen{
//
//		private TextLabel rewardDisplay;
//		private guiPractice.components.Button beatAMonster;
//		
//		public DemoScreen(int width, int height) {
//			super(width, height);
//		}
//
//		@Override
//		public void initAllObjects(ArrayList<Visible> view) {
//			rewardDisplay = new TextLabel(20, 40, 100, 25, "");
//			beatAMonster = new Button(40, 100, 150, 40, "Beat a monster", Color.blue, new Action() {
//				
//				@Override
//				public void act() {
//					ZhenDemo.death.run();
//				}
//			});
//			view.add(rewardDisplay);
//			view.add(beatAMonster);
//		}
//		
//	}
}
