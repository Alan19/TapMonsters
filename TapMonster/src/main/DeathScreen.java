/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

/**
 * @author Alan19
 *
 */
public class DeathScreen extends ClickableScreen implements Runnable{

	/**
	 * @param width
	 * @param height
	 */
		
	private Thread app;
	private ArrayList<artifacts.Artifact> artifactList;
	private Graphics2D g;
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

	
	public void run() {
		g.setColor(new Color(43, 53, 255));
		playerInfo = new TextArea(0, 0, getWidth()-1, getHeight()/3, "You Died! \nLevel: " + level + "Score: " + score);
		drawArtifacts();
	}

	private void drawArtifacts() {
		int x = 5;
		int y = 10+getHeight()/3;
		for (final artifacts.Artifact artifact : artifactList) {
			ClickableGraphic image = new ClickableGraphic(x, y+getHeight()/3, artifact.getImagePath());
			image.setAction(new Action() {
				
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
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(playerInfo);		
	}

}
