/**
 * 
 */
package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;
import guiPractice.ClickableScreen;
import guiPractice.GUIApplication;
import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

/**
 * @author Student8
 *
 */
@SuppressWarnings("serial")
public class ZhenDemo extends GUIApplication {

	public static DeathScreen death;
	
	/**
	 * 
	 */
	public ZhenDemo() {
		super(1000, 700);
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		ArrayList<artifacts.Artifact> artifacts = new ArrayList<artifacts.Artifact>();
		DeathScreenTest death = new DeathScreenTest(5, 1, getWidth(), getHeight(), artifacts);
		setScreen(death);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZhenDemo demo = new ZhenDemo();
		Thread app = new Thread(demo);
		app.start();
	}
	
//	nested inner class
	private class DeathScreenTest extends ClickableScreen{

		private TextLabel deathMessage;
		private TextLabel artifactName;
		private TextLabel artifactDescription;
		private ArrayList<artifacts.Artifact> artifactList;
		
		public DeathScreenTest(int level, int round, int width, int height, ArrayList<artifacts.Artifact> artifacts) {
			super(width, height);
			
			//Game Over information
			deathMessage = new TextLabel(20, 40, 400, 25, "Copperplate Gothic Bold", 20, new Color(140, 146, 143), "You died! Level:" + level + " Round:" + round);
			artifactName = new TextLabel(20, 150, 500, 100, "Copperplate Gothic Bold", 20, new Color(112, 119, 102), "Click on an artifact!");
			artifactDescription = new TextLabel(20, 200, 500, 100, "Copperplate Gothic Bold", 20, new Color(112, 119, 102), "");
			deathMessage.setText("You died! Level:" + level + " Round:" + round);
			Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "src/resources/background.jpg");
			viewObjects.add(background);
			
			
			//Artifacts
			artifactList = new ArrayList<Artifact>();
			artifactList.add(new Artifact("Increases damage by 25% and heals you", "Crafter's Elixir", 100, null, "src/resources/crafters_elixir.png", 0));
			artifactList.add(new Artifact("Increases damage by 100%", "Death Seeker", 100, null, "src/resources/death_seeker.png", 0));
			artifactList.add(new Artifact("Prevents certain death once", "Warrior's Revival", 100, null, "src/resources/warriors_revival.png", 0));
			artifactList.add(new Artifact("Increases the amount of relics earned", "Amulet of the Valrunes", 100, null, "src/resources/amulet_of_the_valrunes.png", 0));
			
			int x = 20;
			int y = 80;
			int imageWidth = 75;
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
				x += imageWidth + 10;
				if(x > getWidth()-10){
					x = 20;
					y += imageWidth + 25;
				}
			}
			//Move artifact description under artifact images
			artifactName.setY(y+100);
			artifactDescription.setY(y+150);
			
			//Add components for display
			viewObjects.add(deathMessage);
			viewObjects.add(artifactName);
			viewObjects.add(artifactDescription);
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			
		}
		
	}
}
