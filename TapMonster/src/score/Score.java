/**
 * 
 */
package score;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import artifacts.Artifact;
import guiPractice.components.Component;
import rewards.Reward;

/**
 * @author Joyce
 *
 */
public class Score extends Component implements ScoreKeeper{

	public static int score;
	public static int achieved;
	public static int threshold;
	
	public boolean newLevel = false;
	private int seqLength = 0;
	private int playerMaxSeq;
	
	public static int playerExp = 0;
	public static int maxExp = 0;
	
//	public static Reward[] rewardAdd;
//	public static ArrayList<Artifact> artifactAdd;
//	public static ArrayList<Monster> monsterAdd;
	
	public Score(int x, int y) {
		super(x, y, 100, 80);
		score = 0;
	}

	@Override
	public void addReward(int percent) {
		//System.out.println("Got a reward with " + percent);
		score += score*percent;
		update();
	}
	
	@Override
	public void addArtifact(int cost) {
		score += cost;
		update();
	}
	
	@Override
	public void addMonster(int sequenceLength) {
		
	}
	
	@Override
	public void addSequenceMultiplier(int sequenceRight, int totalSeqLength) {
		if (totalSeqLength != seqLength) newLevel = true;
		if (newLevel){
			playerMaxSeq = 0;
			seqLength = totalSeqLength;
		}
		if (sequenceRight >= playerMaxSeq){
			score += sequenceRight * 100 * (sequenceRight/seqLength);
			playerMaxSeq = score * sequenceRight;
		}
		else score += sequenceRight/seqLength;
		
		newLevel = false;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		//score
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		g.drawString("score = " + score + "", 5, 30);
		
		//exp
		int expBarHeight = 20;
		g.setColor(Color.blue);
		if (maxExp != 0) g.fillRect(0, getHeight() + 10, getWidth() * (playerExp/maxExp), expBarHeight);
		else g.fillRect(0, getHeight() + 10, 0, 20);
		g.setColor(Color.black);
		g.drawRect(0, getHeight() + 10, getWidth()-1, expBarHeight - 1);
		g.drawString("Exp = " + playerExp + "/" + maxExp + "", 5, 30);
		
	}
}
