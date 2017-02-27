package rewards;

public class Reward {

	public static final int NUMBER_OF_REWARDS = 11;
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
		rewards[0] = new Reward("Small Potion - +1 Health",  "resources/images/spotion.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.fillHeart(1);
				target.increaseScore(50);
				//should work?
			}
		});
		rewards[1] = new Reward("Spare Time - Extra Time",  "resources/images/timeup.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.increaseTimer(5);
				target.increaseScore(50);
			}
		});
		rewards[2] = new Reward("Bonus Heart - +10 HP", "resources/images/heart.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.increaseHearts(10);
				target.increaseScore(200);
			}
		});
		rewards[3] = new Reward("Regular Potion - +25 Health",  "resources/images/potion.png",new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.fillHeart(25);
				target.increaseScore(200);
			}
		});
		rewards[4] = new Reward("Super Bonus Heart - +40 HP", "resources/images/sheart.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.fillHeart(40);
				target.increaseScore(1000);
			}
		});
		rewards[5] = new Reward("Super Score - #1!",  "resources/images/life.png",new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.increaseScore(5000);
			}
		});
		
		rewards[6] = new Reward("Wizard's Hourglass - Slow Motion", "resources/images/hourglass.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.increaseTimer(20);
				target.increaseScore(1000);
			}
		});
		
		rewards[7] = new Reward("Ultra Potion - Full Health", "resources/images/fullpotion.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.fillHeart(50);
				target.increaseScore(1000);
			}
		});
		rewards[8] = new Reward("Small Pouch - 25 Gold", "resources/images/smallpouch.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.getGold(25);
				target.increaseScore(50);
			}
		});
		rewards[9] = new Reward("Large Pouch - 50 Gold", "resources/images/largepouch.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.getGold(50);
				target.increaseScore(200);
			}
		});
		rewards[10] = new Reward("Treasure Chest - 100 Gold!", "resources/images/chest.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.getGold(100);
				target.increaseScore(1000);
			}
		});
		return rewards;
		
	}

	public String getDescription() {
		return description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
