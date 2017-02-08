/**
 * 
 */
package player;

import java.util.ArrayList;

import artifacts.Artifact;
import main.TapMonster;
import monster.Monster;
import rewards.Reward;

/**
 * @author Joyce
 *
 */
public class Score implements ScoreKeeper{

	public static int score;
	public static int achieved;
	public static int threshold;
	
	public static Reward[] rewardAdd;
	public static ArrayList<Artifact> artifactAdd;
	public static ArrayList<Monster> monsterAdd;
	
	public Score(ArrayList<Artifact> a, Reward[] r, ArrayList<Monster> m) {
		this.artifactAdd = a;
		this.rewardAdd = r;
		this.monsterAdd = m;
	}

	@Override
	public void addReward(int percent) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addArtifact(int cost) {
		
	}
	
	@Override
	public void addMonster(int lengthOfSequence) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addSequenceMultiplier(int sequenceRight) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		if (artifactAdd.isEmpty()) System.out.print("Empty");
	}

	
}
