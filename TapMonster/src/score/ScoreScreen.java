package score;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import main.TapMonsterScreen;


/**
 * @author Joyce
 *
 */
public class ScoreScreen extends ClickableScreen {

	private Graphic background;
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
		//background = new Graphic(height, height, height, height, null);
		score = new Score(200, 40);
		artifact = new Button(20, 50, 100, 40, "Get an artifact", Color.green, new Action() {
			
			public void act() {
				int rareness = (int) (Math.random()*10+1);
				System.out.println("Got an artifact with " + rareness);
				score.addArtifact(rareness);
				//System.out.println(TapMonsterScreen.score.score);
			}
		});
		reward = new Button(20, 100, 100, 40, "Get a reward", Color.orange, new Action() {
			
			public void act() {
				int type = (int) (Math.random()*10+1);
				System.out.println("Got a reward with " + type);
				
				score.addReward(type);
			}
		});
		enemyKilled = new Button(20, 150, 100, 40, "Kill Monster", Color.yellow, new Action() {
			
			public void act() {
				int monsterLvl = (int) (Math.random()*10+1);
				System.out.println("Killed a monster with level " + monsterLvl);
				
				score.addMonster(monsterLvl);
			}
		});
		sequence = new Button(20, 200, 100, 40, "Sequence Multiplier!", Color.red, new Action() {
			
			public void act() {
				int seqRight = (int) (Math.random()*10+1);
				System.out.println("Got a sequence with " + seqRight);
				
				score.addSequenceMultiplier(seqRight, 100);
			}
		});
		viewObjects.add(score);
		viewObjects.add(artifact);
		viewObjects.add(reward);
		viewObjects.add(enemyKilled);
		viewObjects.add(sequence);
		
	}

}
