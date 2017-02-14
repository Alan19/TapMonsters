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
import guiPractice.components.TextArea;
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
		super(854, 500);
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

		private int level;
		private int round;
		private TextLabel deathMessage;
		private TextLabel artifactDescription;
		private ArrayList<artifacts.Artifact> artifactList;
		
		public DeathScreenTest(int level, int round, int width, int height, ArrayList<artifacts.Artifact> artifacts) {
			super(width, height);
			this.artifactList = artifacts;
			this.level = level;
			this.round = round;
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			level = 10;
			round = 5;
			Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "src/resources/background.jpg");
			viewObjects.add(background);
			
			deathMessage = new TextLabel(20, 40, 400, 25, "Copperplate Gothic Bold", 20, new Color(98, 106, 102), "You died! Level:" + level + " Round:" + round);
			artifactDescription = new TextLabel(20, 150, 500, 100, "Copperplate Gothic Bold", 20, new Color(112, 119, 102), "Click on an artifact!");
			artifactList = new ArrayList<Artifact>();
			artifactList.add(new Artifact("Increases damage", "Crafter's Elixir", 100, null, "src/resources/Crafter's_Elixir.png"));
			artifactList.add(new Artifact("Increases damage by 100%", "Death Seeker", 100, null, "src/resources/death_dance.png"));
			int x = 20;
			int y = 80;
			int width = 100;
			int height = 100;
			for (Artifact artifact : artifactList) {
				final Artifact artifact2 = artifact;
				ClickableGraphic artifactImage = new ClickableGraphic(x, y,width, height, artifact.getImagePath());
				artifactImage.setAction(new Action() {
					public void act() {
						artifactDescription.setText(artifact2.getDescription());
					}
				});
				viewObjects.add(artifactImage);				
				x += 110;
				if(x > 299){
					x = 20;
					y += 100;
				}
			}
			artifactDescription.setY(y+100);
			viewObjects.add(artifactDescription);
			viewObjects.add(deathMessage);
		}
		
	}
}
