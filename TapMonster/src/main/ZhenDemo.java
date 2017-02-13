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
		artifacts.add(new Artifact("Increases damage by 100%", "Death's Dance", 100, null, "src/resources/death_dance.png"));
		System.out.println(artifacts.get(0).getImagePath());
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
			ClickableGraphic artifactImage = new ClickableGraphic(50, 100, "src/resources/death_dance.png");
			artifactImage.setAction(new Action() {
				
				public void act() {
					artifactDescription.setText("Increases damage by 100%");
				}
			});
			viewObjects.add(artifactImage);
//			for (artifacts.Artifact artifact : artifactList) {
//				artifactList.add(new artifacts.Artifact("Death's Dance", "Increases damage by 100%", 300, null, "src/resources/death_dance.png"));
//				artifactImage.setAction(new Action() {
//					
//					public void act() {
////						artifactDescription.setText(artifact.getDescription());
//					}
//				});
//				viewObjects.add(artifactImage);
//				
//			}
			viewObjects.add(artifactDescription);
			viewObjects.add(deathMessage);
		}
		
	}
}
