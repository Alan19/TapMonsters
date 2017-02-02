package rewards;

public interface RewardTarget {
	void earnReward(Reward r);

	void increaseHearts(int i);

	void addExtraLife(int i);

	void increaseTimer(int i);
}
