package guiPractice.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Component implements Visible {

	// fields
	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage image;

	// constructor
	public Component(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		update(image.createGraphics());
	}

	public Graphics2D clear() {
		// resets the picture
		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		return image.createGraphics();
	}

	// draw the component
	public abstract void update(Graphics2D g);

	public BufferedImage getImage() {
		return image;
	}

	@Override
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getY() {
		return y;
	}
	public void setWidth(int w) {
		this.w = w;
	}

	public void setHeight(int h) {
		this.h=h;
	}
	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		update(image.createGraphics());

	}

}
