package score;

public interface ScoreKeeper {

	void addReward(int percent);
	
	void addArtifact(int cost);
	
	void addMonster(int lengthOfSequence);
	
	void addSequenceMultiplier(int sequenceRight, int totalseqLength);

	void addExp();
}
