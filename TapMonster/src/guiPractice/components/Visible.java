package guiPractice.components;

import java.awt.image.BufferedImage;

public interface Visible {

	public BufferedImage getImage();
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public boolean isAnimated();
	public void update();
	
}
