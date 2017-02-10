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
 * @author Student 8
 *
 */
public class MahinDemo extends GUIApplication {

	//public static Reward reward;
	/**
	 * 
	 */
	public MahinDemo() {
		//construct new
		//reward = new Reward;
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(getWidth(),getHeight());
		setScreen(demo);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MahinDemo demo = new MahinDemo();
		Thread app = new Thread(demo);
		app.start();

	}
	
	//nested inner class
	private class DemoScreen extends ClickableScreen{

		//private TextLabel rewardDisplay;
		//private Button beatAMonster;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(ArrayList<Visible> view) {
			/*rewardDisplay = new TextLabel(20,40,700,25,"");
			beatAMonster = new Button(40,100,190,40,"Beat a monster", 
					Color.blue, new Action() {
						
						@Override
						public void act() {
							MahinDemo.reward.getReward(10);
							rewardDisplay.setText("You earned a reward!"
									+ " Total points ="
									+ "+MahinDemo.reward.getPoints());
							
						}
					});
			view.add(rewardDisplay);
			view.add(beatAMonster);*/
		}
		
	}

}
