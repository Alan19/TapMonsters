package rewards;

public class Reward {

	public static final int NUMBER_OF_REWARDS = 5;
	private String description;
	private RewardEffect effect;
	
	public Reward(String description, RewardEffect effect) {
		this.description = description;
		this.effect = effect;
	}
	
	public void takeEffect(RewardTarget target){
		effect.affect(target);
	}
	
	public static Reward[] getAllRewards(){
		Reward[] rewards = new Reward[NUMBER_OF_REWARDS];
		rewards[0] = new Reward("Bonus Heart", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseHearts(1);
			}
		});
		rewards[1] = new Reward("Super Bonus Heart", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseHearts(2);
			}
		});
		rewards[2] = new Reward("Extra Life", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.addExtraLife(1);
			}
		});
		rewards[3] = new Reward("Spare Time", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseTimer(5);
			}
		});
		rewards[4] = new Reward("Wizard's Hourglass", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseTimer(20);
			}
		});
		return rewards;
	}
}
