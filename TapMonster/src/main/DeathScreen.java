/**
 * 
 */
package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import MonsterDex.MonsterDexScreen;
import MonsterDex.MonsterGraphic;
import artifacts.Artifact;
import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import interfaces.MonDexInterface;

/**
 * @author Alan19
 *
 */
public class DeathScreen extends ClickableScreen{

	private TextLabel deathMessage;
	private TextLabel artifactName;
	private TextLabel artifactDescription;
	private TextLabel epicKills;
	private ArrayList<artifacts.Artifact> artifactList;
	
	public DeathScreen(int level, int round, int width, int height, ArrayList<artifacts.Artifact> artifacts, ArrayList<MonDexInterface> monsters) {
		super(width, height);
		
		//Game Over information and add background
		deathMessage = new TextLabel(20, 40, 400, 25, "Copperplate Gothic Bold", 20, new Color(140, 146, 143), "You died! Level:" + level + " Round:" + round);
		deathMessage.setText("You died! Level:" + level + " Round:" + round);
		viewObjects.add(deathMessage);
		
		artifactName = new TextLabel(20, 150, 500, 100, "Copperplate Gothic Bold", 20, new Color(112, 119, 102), "Click on an artifact!");
		artifactDescription = new TextLabel(20, 200, 500, 100, "Copperplate Gothic Bold", 20, new Color(112, 119, 102), "");
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "src/resources/background.jpg");
		viewObjects.add(background);
		
		/**Hard-coded artifact example
		artifactList = new ArrayList<Artifact>();
		artifactList.add(new Artifact("Increases damage by 25% and heals you", "Crafter's Elixir", 100, null, "src/resources/crafters_elixir.png"));
		artifactList.add(new Artifact("Increases damage by 100%", "Death Seeker", 100, null, "src/resources/death_seeker.png"));
		artifactList.add(new Artifact("Prevents certain death once", "Warrior's Revival", 100, null, "src/resources/warriors_revival.png"));
		artifactList.add(new Artifact("Increases the amount of relics earned", "Amulet of the Valrunes", 100, null, "src/resources/amulet_of_the_valrunes.png"));
		**/
		
		//Loop through artifacts sent in to set width and description on click
		int x = 20;
		int y = 80;
		int imageWidth = 75;
		if (artifactList != null) {
			for (Artifact artifact : artifactList) {
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
		}
		
		//Move artifact description under artifact images
		artifactName.setY(y+100);
		artifactDescription.setY(y+150);
		
		//Add components for display
		viewObjects.add(artifactName);
		viewObjects.add(artifactDescription);
		
		addBossMonsterKillList();
	}
	

	private void addBossMonsterKillList() {
		int x = getWidth()/2;
		int y = 75;
		epicKills = new TextLabel(getWidth()/2, y, 400, 25, "Copperplate Gothic Bold", 15, new Color(112, 119, 102), "Here is a list of your heroic feats");
		if (MonsterDexScreen.getMonsters() != null) {
			for (MonsterGraphic monster : MonsterDexScreen.getMonsters()) {
				TextLabel name = new TextLabel(x+110, y, 400, 25, monster.getName());
				x = getWidth()/2;
				y += 120;
			}
		}
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
	}
	
	
}
