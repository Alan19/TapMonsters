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
	
//	public static Reward[] rewardAdd;
//	public static ArrayList<Artifact> artifactAdd;
//	public static ArrayList<Monster> monsterAdd;
	
	public Score(int x, int y) {
		super(x, y, 100, 80);
;//		this.artifactAdd = a;
//		this.rewardAdd = r;
//		this.monsterAdd = m;
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
	public void addMonster(int lengthOfSequence) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addSequenceMultiplier(int sequenceRight, int totalSeqLength) {
		if (totalSeqLength != seqLength) newLevel = true;
		if (newLevel){
			playerMaxSeq = 0;
			seqLength = totalSeqLength;
		}
		else{
			if (sequenceRight >= playerMaxSeq) score += (score + score*(sequenceRight/seqLength));
			else
		}
		playerMaxSeq = sequenceRight;
		newLevel = false;
		
	}

	@Override
	public void addExp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		g.drawString("score = " + score + "", 5, 30);
		
	}
}
