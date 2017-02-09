/**
 * 
 */
package score;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;

import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickableScreen;

/**
 * @author Joyce
 *
 */
public class ScoreScreen extends ClickableScreen {

	
	private Button artifact;
	private Button reward;
	private Button enemyKilled;
	private Button sequence;
	public static Score score;
	/**
	 * @param width
	 * @param height
	 */
	public ScoreScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.components.ClickableScreen#initAllObjects(java.util.ArrayList)
	 */
	@Override
	public void initAllObjects(ArrayList<Visible> view) {
		score = new Score(200, 40);
		artifact = new Button(20, 50, 100, 40, "Get an artifact", Color.green, new Action() {
			
			@Override
			public void act() {
				int rareness = (int) (Math.random()*10);
				System.out.println("Got a artifact with " + rareness);
				score.addArtifact(rareness);
			}
		});
		reward = new Button(20, 100, 100, 40, "Get a reward", Color.green, new Action() {
			
			@Override
			public void act() {
				int rareness = (int) (Math.random()*10);
				
				score.addReward(rareness);
			}
		});
		view.add(artifact);
		 view.add(score);
		 view.add(reward);
		
	}

}
