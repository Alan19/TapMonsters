/**
 * 
 */
package rewards;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiPractice.components.Component;
import guiPractice.components.Graphic;

/**
 * @author Student8
 *
 */
public class RewardIcon extends Graphic {
	private Reward reward;

	public RewardIcon(int x, int y, double scale, Reward reward) {
		super(x, y, scale, reward.getImage());
		// TODO Auto-generated constructor stub
		this.reward = reward;
	}
	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	
	private int x;
	private int y;
	private BufferedImage image;
	private boolean loadedImages;
	
	public void setReward(Reward reward){
		this.reward = reward;
	}
	
	

}
