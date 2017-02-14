/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;
import guiPractice.ClickableScreen;
import guiPractice.GUIApplication;
import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
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
		super(300, 300);
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		ArrayList<artifacts.Artifact> artifacts = new ArrayList<artifacts.Artifact>();
		DeathScreenTest death = new DeathScreenTest(getWidth(), getHeight(), artifacts);
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
		private TextLabel artifactDescription;
		private ArrayList<artifacts.Artifact> artifactList;
		
		public DeathScreenTest(int width, int height, ArrayList<artifacts.Artifact> artifacts) {
			super(width, height);
			this.artifactList = artifacts;
		}

		@Override
		public void initAllObjects(List<Visible> viewObjects) {
			deathMessage = new TextLabel(20, 40, 300, 25, "You died! Level:1 Round:1");
			artifactDescription = new TextLabel(20, 150, 500, 100, "Click on an artifact!");
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
