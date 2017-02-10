/**
 * 
 */
package score;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;

import guiPractice.components.Visible;


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
	public void initAllObjects(List<Visible> viewObjects) {
		score = new Score(200, 40);
		artifact = new Button(20, 50, 100, 40, "Get an artifact", Color.green, new Action() {
			
			@Override
			public void act() {
				int rareness = (int) (Math.random()*10);
				System.out.println("Got an artifact with " + rareness);
				score.addArtifact(rareness);
			}
		});
		reward = new Button(20, 100, 100, 40, "Get a reward", Color.green, new Action() {
			
			@Override
			public void act() {
				int type = (int) (Math.random()*10);
				System.out.println("Got a reward with " + type);
				
				score.addReward(type);
			}
		});
		sequence = new Button(20, 100, 100, 40, "Sequence Multiplier!", Color.green, new Action() {
			
			@Override
			public void act() {
				int seqRight = (int) (Math.random()*10);
				
				score.addSequenceMultiplier(seqRight, 100);
			}
		});
		viewObjects.add(artifact);
		viewObjects.add(score);
		viewObjects.add(reward);
		viewObjects.add(sequence);
		
	}

}
