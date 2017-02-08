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
		rewards[0] = new Reward("Bonus Heart - +1 Hearts", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseHearts(1);
			}
		});
		rewards[1] = new Reward("Super Bonus Heart - +2 Hearts", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseHearts(2);
			}
		});
		rewards[2] = new Reward("Extra Life - 1UP", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.addExtraLife(1);
			}
		});
		rewards[3] = new Reward("Spare Time - Extra Time", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseTimer(5);
			}
		});
		rewards[4] = new Reward("Wizard's Hourglass - Slow Motion", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseTimer(20);
			}
		});
		rewards[5] = new Reward("Small Potion - +1 Health", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.fillHeart(1);
				//should work?
			}
		});
		rewards[6] = new Reward("Regular Potion - +2 Health", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.fillHeart(2);
			}
		});
		rewards[7] = new Reward("Ultra Potion - Full Health", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.fillHeart(6);
			}
		});
		return rewards;
	}
}
