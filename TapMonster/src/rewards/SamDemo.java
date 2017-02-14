/**
 * 
 */
package rewards;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.GUIApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

/**
 * @author Student8
 *
 */
public class SamDemo extends guiPractice.GUIApplication {
	
	public static Reward[] rewardList;
	public static Reward reward;

	/**
	 * 
	 */
	public SamDemo(int w, int h) {
		super(w, h);
		rewardList = Reward.getAllRewards();
		int rewardTier = 0;
		int probNum = (int) (Math.random() * 10 +1);
		if (probNum <= 6){
			rewardTier = 0;
		}
		else if (probNum <= 9){
			rewardTier = 1;
		}
		else{
			rewardTier = 2;
		}
		if (rewardTier == 0){
			int randNum = (int) (Math.random() * 2);
			reward = rewardList[randNum];
		}
		else if (rewardTier == 1){
			int randNum = (int) (Math.random() * 2+2);
			reward = rewardList[randNum];
		}
		else{
			int randNum = (int) (Math.random() * 4+4);
			reward = rewardList[randNum];
		}
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
		SamDemo demo = new SamDemo(800, 600);
		Thread app = new Thread(demo);
		app.start();
	}
	

	
	//nested inner class
	private class PlayerValues implements RewardTarget{
		private int heartCont = 3;
		private int timeValue = 0;
		private int heartValue = 1;
		private int lifeCounter = 0;
		private int goldCounter = 0;
		private int fullHealth = 0;


		@Override
		public void increaseHearts(int i) {
			heartCont += i;
			if (heartCont > 6){
				heartCont = 6;
			}
			
		}

		@Override
		public void addExtraLife(int i) {
			lifeCounter += i;
			
		}

		@Override
		public void increaseTimer(int i) {
			timeValue += i;
			
		}

		@Override
		public void fillHeart(int i) {
			heartValue += i;
			if (heartValue > heartCont){
				heartValue = heartCont;
			}
		}

		public int getHeartCont() {
			// TODO Auto-generated method stub
			return heartCont;
		}
		
		public int getLifeCounter() {
			// TODO Auto-generated method stub
			return lifeCounter;
		}
		
		public int getHeartValue() {
			// TODO Auto-generated method stub
			return heartValue;
		}
		
		public int getTimeValue() {
			// TODO Auto-generated method stub
			return timeValue;
		}

		@Override
		public void getGold(int i) {
			goldCounter += i;
			
		}
		
		public int getGoldCount() {
			// TODO Auto-generated method stub
			return goldCounter;
		}

		

	}
	private class DemoScreen extends guiPractice.ClickableScreen{

		private TextLabel rewardDisplay;
		private TextLabel rewardDescription;
		private TextLabel goldDescription;
		private Button beatAMonster;
		private Button clearRewards;
		private PlayerValues player;
		
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(List<Visible> view) {
			// TODO Auto-generated method stub
			rewardDisplay = new TextLabel(20, 40, 500, 25, "");
			rewardDescription = new TextLabel(20, 200, 300, 25, "");
			goldDescription = new TextLabel(350, 200, 1000, 25, "");
			player = new PlayerValues();
			beatAMonster = new Button(40, 100, 90, 40, "Beat A Monster", Color.blue, new Action() {
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					SamDemo.reward.takeEffect(player);
					rewardDescription.setText(reward.getDescription());
					int goldNum = (int) (Math.random() * 10 + 1);
					if (goldNum <= 6){
						reward = rewardList[8];
					}
					else if (goldNum <= 9){
						reward = rewardList[9];
					}
					else{
						reward = rewardList[10];
					}
					SamDemo.reward.takeEffect(player);
					goldDescription.setText(reward.getDescription());
					rewardDisplay.setText("Cont: "+ player.getHeartCont()+", Time: "+player.getTimeValue()+", Lives: "+ player.getLifeCounter()+", Hearts: "+player.getHeartValue()+", Gold: "+player.getGoldCount());
					update();
					int randNum = (int) (Math.random() * 8);
					reward = rewardList[randNum];
				}
			});
			clearRewards = new Button(150, 100, 90, 40, "Clear Rewards", Color.green, new Action() {
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					player.heartCont = 3;
					player.timeValue = 0;
					player.heartValue = 1;
					player.lifeCounter = 0;
					player.goldCounter = 0;
					rewardDisplay.setText("Cont: "+ player.getHeartCont()+", Time: "+player.getTimeValue()+", Lives: "+ player.getLifeCounter()+", Hearts: "+player.getHeartValue()+", Gold: "+player.getGoldCount());
					update();
				}
			});
			view.add(rewardDisplay);
			view.add(rewardDescription);
			view.add(goldDescription);
			view.add(beatAMonster);
			view.add(clearRewards);
		}
		
	}

}
