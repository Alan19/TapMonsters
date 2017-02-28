package rewards;

public interface RewardTarget {
	void earnReward(Reward r);
	//gives a reward to the target
	void increaseHearts(int i);
	//method that adds i extra HEART CONTAINERS
	void increaseTimer(int i);
	//method to add i seconds to the timer
	void fillHeart(int i);
	//method should make unfilled hearts full, adding HP, not heart containers.
	void getGold(int i);
	void increaseScore(int i);
	int giveHpMax();
}
