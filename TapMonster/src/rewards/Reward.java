package rewards;

public class Reward {

	public static final int NUMBER_OF_REWARDS = 5;
	private String description;
	private RewardEffect effect;
	private String image;
	
	public Reward(String description, String image, RewardEffect effect) {
		this.description = description;
		this.effect = effect;
		this.setImage(image);
	}
	
	public void takeEffect(RewardTarget target){
		effect.affect(target);
	}
	
	public static Reward[] getAllRewards(){
		Reward[] rewards = new Reward[NUMBER_OF_REWARDS];
		rewards[0] = new Reward("Bonus Heart - +1 Hearts", "resources/images/heart.png", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseHearts(1);
			}
		});
		rewards[1] = new Reward("Super Bonus Heart - +2 Hearts", "resources/images/sheart.png", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseHearts(2);
			}
		});
		rewards[2] = new Reward("Extra Life - 1UP",  "resources/images/life.png",new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.addExtraLife(1);
			}
		});
		rewards[3] = new Reward("Spare Time - Extra Time",  "resources/images/timeup.png", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseTimer(5);
			}
		});
		rewards[4] = new Reward("Wizard's Hourglass - Slow Motion", "resources/images/hourglass.png", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.increaseTimer(20);
			}
		});
		rewards[5] = new Reward("Small Potion - +1 Health",  "resources/images/spotion.png", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.fillHeart(1);
				//should work?
			}
		});
		rewards[6] = new Reward("Regular Potion - +2 Health",  "resources/images/potion.png",new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.fillHeart(2);
			}
		});
		rewards[7] = new Reward("Ultra Potion - Full Health", "resources/images/fullpotion.png", new RewardEffect() {
			
			@Override
			public void affect(RewardTarget target) {
				target.fillHeart(6);
			}
		});
		return rewards;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
