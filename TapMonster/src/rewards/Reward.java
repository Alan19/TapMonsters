package rewards;

public class Reward {

	public static final int NUMBER_OF_REWARDS = 11;
	private String description;
	private RewardEffect effect;
	private String image;
	private Boolean uniqueness;
	
	public Reward(Boolean uniqueness, String description, String image, RewardEffect effect) {
		this.description = description;
		this.effect = effect;
		this.uniqueness = uniqueness;
		this.setImage(image);
	}
	
	public void takeEffect(RewardTarget target){
		effect.affect(target);
	}
	
	public static Reward[] getAllRewards(){
		Reward[] rewards = new Reward[NUMBER_OF_REWARDS];
		rewards[0] = new Reward(false, "Small Potion - +10 Health",  "resources/images/spotion.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.fillHeart(10);
				target.increaseScore(50);
				//should work?
			}
		});
		rewards[1] = new Reward(false, "Spare Time - Extra Time",  "resources/images/timeup.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.increaseTimer(5);
				target.increaseScore(50);
			}
		});
		rewards[2] = new Reward(false, "Bonus Heart - +10 HP", "resources/images/heart.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.increaseHearts(10);
				target.increaseScore(200);
			}
		});
		rewards[3] = new Reward(false, "Regular Potion - +25 Health",  "resources/images/potion.png",new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.fillHeart(25);
				target.increaseScore(200);
			}
		});
		rewards[4] = new Reward(false, "Super Bonus Heart - +40 health", "resources/images/sheart.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.fillHeart(40);
				target.increaseScore(1000);
			}
		});
		rewards[5] = new Reward(true, "Super Score - #1!",  "resources/images/life.png",new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.increaseScore(5000);
			}
		});
		
		rewards[6] = new Reward(true, "Wizard's Hourglass - Slow Motion", "resources/images/hourglass.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.increaseTimer(20);
				target.increaseScore(1000);
			}
		});
		
		rewards[7] = new Reward(false, "Ultra Potion - Full Health", "resources/images/fullpotion.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.fillHeart(target.giveHpMax());
				target.increaseScore(1000);
			}
		});
		rewards[8] = new Reward(false, "Small Pouch - 25 Gold", "resources/images/smallpouch.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.getGold(25);
				target.increaseScore(50);
			}
		});
		rewards[9] = new Reward(false, "Large Pouch - 50 Gold", "resources/images/largepouch.png", new RewardEffect() {
			
			public void affect(RewardTarget target) {
				target.getGold(50);
				target.increaseScore(200);
			}
		});
		rewards[10] = new Reward(false, "Treasure Chest - 100 Gold!", "resources/images/chest.png", new RewardEffect() {
			
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
	
	public Boolean getUniqueness(){
		return uniqueness;
	}

	public void setImage(String image) {
		this.image = image;
	}
}

