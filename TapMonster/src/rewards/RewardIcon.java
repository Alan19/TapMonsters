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

	public RewardIcon(int x, int y, double scale, Reward reward) {
		super(x, y, scale, reward.getImage());
		// TODO Auto-generated constructor stub
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
	
	

}
