package rewards;

public interface RewardTarget {

	void increaseHearts(int i);
	//method that adds i extra HEART CONTAINERS
	void addExtraLife(int i);
	//method to add an extra life? if too complex, can remove
	void increaseTimer(int i);
	//method to add i seconds to the timer
	void fillHeart(int i);
	//method should make unfilled hearts full, adding HP, not heart containers.
	void getGold(int i);
	//money money money money, money!
}
