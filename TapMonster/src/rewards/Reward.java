package rewards;

public class Reward {

	public static final int NUMBER_OF_REWARDS = 10;
	
	public Reward(String description) {
		// TODO Auto-generated constructor stub
	}
	
	public static Reward[] getAllRewards(){
		Reward[] rewards = new Reward[NUMBER_OF_REWARDS];
		rewards[0] = new Reward("Potion");
		return rewards;
	}
}
