/**
 * 
 */
package main;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.GUIApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

/**
 * @author Student8
 *
 */
public class ZhenDemo extends GUIApplication {

	public static DeathScreen death;
	
	/**
	 * 
	 */
	public ZhenDemo() {
		death = new DeathScreen(getX(), getY(), 5, 5, new ArrayList<Artifact>());
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(getWidth(), getHeight());
		setScreen(demo);
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
	private class DemoScreen extends ClickableScreen{

		private TextLabel rewardDisplay;
		private guiPractice.components.Button beatAMonster;
		
		public DemoScreen(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(ArrayList<Visible> view) {
			rewardDisplay = new TextLabel(20, 40, 100, 25, "");
			beatAMonster = new Button(40, 100, 150, 40, "Beat a monster", Color.blue, new Action() {
				
				@Override
				public void act() {
					ZhenDemo.death.run();
				}
			});
			view.add(rewardDisplay);
			view.add(beatAMonster);
		}
		
	}
}
