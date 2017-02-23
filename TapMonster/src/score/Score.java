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
import score.ScoreKeeper;

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
	public static int maxExp = 100;
	
	public Score(int x, int y) {
		super(x, y, 300, 300);
		score = 0;
	}

	public void addReward(int percent) {
		//System.out.println("Got a reward with " + percent);
		score += score*((percent/100)+1);
		playerExp+=percent;
		checkExp(playerExp);
		update();
	}
	
	public void addArtifact(int cost) {
		score += cost;
		playerExp+=cost;
		checkExp(playerExp);
		update();
	}
	
	public void addMonster(int sequenceLength) {
		score += sequenceLength*10;
		playerExp+= sequenceLength;
		checkExp(playerExp);
		update();
	}
	
	public void addSequenceMultiplier(int sequenceRight, int totalSeqLength) {
		if (totalSeqLength != seqLength) newLevel = true;
		if (newLevel){
			playerMaxSeq = 0;
			seqLength = totalSeqLength;
		}
		if (sequenceRight >= playerMaxSeq){
			score += sequenceRight * 10 * ((sequenceRight/seqLength)+1);
			playerMaxSeq = sequenceRight;
		}
		else score += (sequenceRight/seqLength)+1;
		
		playerExp+= sequenceRight;
		checkExp(playerExp);
		newLevel = false;
		update();
	}

	public void checkExp(int exp){
		if (playerExp >= maxExp){
			score += maxExp;
			playerExp = playerExp - maxExp;
			maxExp += 50;
		}
	}
	
	@Override
	public void update(Graphics2D g) {
		//score
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight()/2-10);
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth()-1, (getHeight()-1)/2-10);
		g.drawString("score = " + score + "", 5, 30);
		
		//exp
		int expBarHeight = 20;
		g.setColor(Color.white);
		g.fillRect(0, getHeight()/2+10, getWidth()-1, expBarHeight - 1);
		g.setColor(new Color(102, 179, 255));
		if (playerExp > 0) g.fillRect(0, getHeight()/2+10, getWidth() * playerExp/maxExp, expBarHeight);
		else g.fillRect(0, getHeight()/2+10, 0, expBarHeight);
		g.setColor(Color.black);
		g.drawRect(0, getHeight()/2+10, getWidth()-1, expBarHeight - 1);
		g.drawString("Exp = " + playerExp + "/" + maxExp + "", 5, getHeight()/2+25);
	}
}
