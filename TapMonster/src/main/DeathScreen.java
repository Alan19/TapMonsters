/**
 * 
 */
package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;
import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import interfaces.LoseInterface;
import player.Score;

/**
 * @author Alan19
 *
 */
public class DeathScreen extends ClickableScreen implements LoseInterface{

	private TextLabel deathMessage;
	private TextLabel artifactName;
	private TextLabel artifactDescription;
	public DeathScreen(int width, int height) {
		super(width, height);
		displayGameOverInformation();
	}
	
	public void displayGameOverInformation() {
		//Game Over information and add background
		deathMessage = new TextLabel(20, 40, 400, 25, "Copperplate Gothic Bold", 20, new Color(140, 146, 143), "You died!" + "Score: " + Score.score + " Round:" + SequenceScreen2.getRound());
		
		
		//Add background first so it's in the back
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "src/resources/background.jpg");
		viewObjects.add(background);
		
		//Loop through artifacts sent in to set width and description on click
		int x = 20;
		int y = 80;
		int imageWidth = 75;
		
		//Only print artifact info if you have artifacts
		if(InventoryScreen.artifactsPurchased != null && InventoryScreen.artifactsPurchased.size()>0){
			//Artifact Info TextLabels
			artifactName = new TextLabel(20, 150, 500, 100, "Copperplate Gothic Bold", 20, new Color(112, 119, 102), "Click on an artifact!");
			artifactDescription = new TextLabel(20, 200, 500, 100, "Copperplate Gothic Bold", 20, new Color(112, 119, 102), "");
			
			for (Artifact artifact : InventoryScreen.artifactsPurchased) {
				final Artifact artifact2 = artifact;
				ClickableGraphic artifactImage = new ClickableGraphic(x, y,imageWidth, imageWidth, artifact.getImagePath());
				artifactImage.setAction(new Action() {
					public void act() {
						artifactName.setText(artifact2.getName());
						artifactDescription.setText(artifact2.getDescription());
					}
				});
				addObject(artifactImage);
				viewObjects.add(artifactImage);				
				
				//Set next image to go to next line if an image would go past half the screen
				if(x + imageWidth > getWidth()/2){
					x = 20;
					y += imageWidth + 25;
				}
				else x += imageWidth + 10;
			}
			
			//Move artifact description under artifact images
			artifactName.setY(y+100);
			artifactDescription.setY(y+150);
			
			//Add components for display
			viewObjects.add(artifactName);
			viewObjects.add(artifactDescription);
		}
		
		viewObjects.add(deathMessage);
		addBossMonsterKillList();
	}

	public void addBossMonsterKillList() {
		int x = getWidth()/2 + 30;
		int y = 40;
		if(MonsterDexScreen.filePaths != null){
			TextLabel feats = new TextLabel(getWidth()/2, y, 400, 25, "Copperplate Gothic Bold", 20, new Color(112, 119, 102), "Here is a list of your heroic feats");
			y += 50;
			for (String monster : MonsterDexScreen.filePaths) {
				if(monster.contains("Titan")){
					Graphic titan = new Graphic(x, y, 100, 100, monster);
					viewObjects.add(feats);
					viewObjects.add(titan);
					x = getWidth()/2;
					y += 120;				
				}
			}
		}
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
	}


	
}
