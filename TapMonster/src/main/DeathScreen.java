/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Clickable;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextArea;
import guiPractice.components.Visible;

/**
 * @author Alan19
 *
 */
public class DeathScreen extends ClickableScreen implements Visible, Clickable, Runnable{

	/**
	 * @param width
	 * @param height
	 */
		
	private Thread app;
	private ArrayList<Artifact> artifactList;
	private Graphics2D g;
	private int x;
	private int y;
	private int ax;
	private int ay = getHeight() + 100;
	private int aw = getWidth();
	private int ah = ay + 100;
	private TextArea playerInfo;
	private ArrayList<Visible> viewObjects;
	
	public DeathScreen(int width, int height, int level, int score, ArrayList<Artifact> artifactList){
		super(width, height);
		this.artifactList = artifactList;
		app = new Thread(this);
		app.start();
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void act() {
		
	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		g.setColor(new Color(43, 53, 255));
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		/**
		 * Reference numbers later
		 */
		String level = null;
		String round = null;
		playerInfo = new TextArea(0, 0, getWidth()-1, getHeight()-1, "You Died! \nLevel: " + level + "Round: " + round);
		drawArtifacts();
	}

	private void drawArtifacts() {
		int x = 5;
		int y = 10;
		for (Artifact artifact : artifactList) {
			ClickableGraphic image = new ClickableGraphic(x, y, null);
			image.setImage(artifact.getIcon());
			image.setAction(new Action() {
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					
				}
			});
			addObject(image);
			if(x >= getWidth()) {
				x = 5;
				y += 20;
			}
			else x += 20;
			viewObjects.add(image);
		}
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		viewObjects.add(playerInfo);
	}

}
