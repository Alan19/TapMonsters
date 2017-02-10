/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Clickable;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickableScreen;

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
	private ArrayList<artifacts.Artifact> artifactList;
	private Graphics2D g;
	private int x;
	private int y;
	private TextArea playerInfo;
	private ArrayList<Visible> viewObjects;
	private int level;
	private int score;
	private int finalY;
	private TextLabel description;
	
	public DeathScreen(int width, int height, int level, int score, ArrayList<artifacts.Artifact> artifactList){
		super(width, height);
		this.artifactList = artifactList;
		this.level = level;
		this.score = score;
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
		playerInfo = new TextArea(0, 0, getWidth()-1, getHeight()/3, "You Died! \nLevel: " + level + "Score: " + score);
		drawArtifacts();
	}

	private void drawArtifacts() {
		int x = 5;
		int y = 10+getHeight()/3;
		for (artifacts.Artifact artifact : artifactList) {
			ClickableGraphic image = new ClickableGraphic(x, y+getHeight()/3, artifact.getImagePath());
			image.setAction(new Action() {
				
				@Override
				public void act() {
					description.setText(artifact.getDescription());
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
		finalY = y + 30;
		description = new TextLabel(x, finalY, getWidth(), 30, "");
	}
	
	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		viewObjects.add(playerInfo);
	}

}
