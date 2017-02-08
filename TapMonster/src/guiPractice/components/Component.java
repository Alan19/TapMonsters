package guiPractice.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Component implements Visible {

	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage image;
	
	public Component(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		update(image.createGraphics());
	}

	public Graphics2D clear(){
		//resets the picture
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		return image.createGraphics();
	}
	/**
	 * draw the component
	 * @param g
	 */
	public abstract void update(Graphics2D g);

	public BufferedImage getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	public void update() {
		update(image.createGraphics());
	}

}
