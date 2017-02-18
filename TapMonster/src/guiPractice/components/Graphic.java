package guiPractice.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Graphic implements Visible {

	private BufferedImage image;
	private boolean loadedImages;
	private int x;
	private int y;
	private String imagePath;

	public Graphic(int x, int y, int w, int h, String imageLocation){	
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, w, h);
	}

	public Graphic(int x, int y, double scale, String imageLocation){	
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, scale);
	}

	//you can change this one
	public void loadImages(String imageLocation, double scale) {
		try{
			//get the full-size image
			ImageIcon icon = new ImageIcon(imageLocation);

			int newWidth = (int) (icon.getIconWidth() * scale);
			int newHeight = (int) (icon.getIconHeight() * scale);
			image = new BufferedImage(newWidth,newHeight,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(icon.getImage(), 0, 0, newWidth, newHeight, 0,0,icon.getIconWidth(), icon.getIconHeight(), null);

			loadedImages = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Graphic(int x, int y, String imageLocation){
		this.x = x;
		this.y = y;
		loadedImages = false;
		this.imagePath = imageLocation;
		loadImages(imageLocation, 0,0);
	}

	//please do not change to private
	public void loadImages(String imageLocation, int w, int h) {
		try{
			//get the full-size image
			ImageIcon icon = new ImageIcon(imageLocation);

			//use image size of original
			if(w==0 && h == 0){
				image = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, null);
			}else{
				image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0, w, h, 0,0,icon.getIconWidth(), icon.getIconHeight(), null);
			}
			loadedImages = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public BufferedImage getImage() {
		return image;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}
	
	public String getImagePath(){
		return imagePath;
	}

	public void update() {
		//does nothing, since image never changes
	}

	public boolean isAnimated() {
		return false;
	}


}