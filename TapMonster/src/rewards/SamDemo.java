/**
 * 
 */
package rewards;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.GUIApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickableScreen;

/**
 * @author Student8
 *
 */
public class SamDemo extends GUIApplication {
	
	public static Reward[] rewardList;
	public static Reward reward;

	/**
	 * 
	 */
	public SamDemo() {
		rewardList = Reward.getAllRewards();
		int randNum = (int) (Math.random() * 8);
		reward = rewardList[randNum];
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		DemoScreen demo = new DemoScreen(getWidth(), getHeight());
		setScreen(demo);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SamDemo demo = new SamDemo();
		Thread app = new Thread(demo);
		app.start();
	}
	
	//nested inner class
	private class DemoScreen extends ClickableScreen{

		private TextLabel rewardDisplay;
		private Button beatAMonster;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(ArrayList<Visible> view) {
			rewardDisplay = new TextLabel(20, 40, 100, 25, "");
			beatAMonster = new Button(40, 100, 90, 40, "Beat A Monster", Color.blue, new Action() {
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					SamDemo.reward.takeEffect();
				}
			});
			view.add(rewardDisplay);
			view.add(beatAMonster);
		}
		
	}

}
