/**
 * 
 */
package rewards;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiPractice.components.Component;

/**
 * @author Student8
 *
 */
public class RewardIcon extends Component {

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
	
	public RewardIcon(int x, int y, int w, int h, Reward reward) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.components.Component#update(java.awt.Graphics2D)
	 */
	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub

	}

}
