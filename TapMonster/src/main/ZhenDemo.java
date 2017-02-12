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
		super(300, 300);
	}

	/* (non-Javadoc)
	 * @see guiPractice.GUIApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		ArrayList<artifacts.Artifact> artifacts = new ArrayList<artifacts.Artifact>();
//		artifacts.add(new Artifact("Test", "Test Item", 300, null, "resources/Death_Seeker.png"));
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
		private Graphic artifact;
		
		public DeathScreenTest(int width, int height, ArrayList<Artifact> artifacts) {
			super(width, height);
		}

		@Override
		public void initAllObjects(final List<Visible> viewObjects) {
			deathMessage = new TextLabel(20, 40, 300, 25, "You died! Level:1 Round:1");
//			artifact = new Graphic(50, 100, "/src/resources/death_dance.png");
//			artifact.setAction(new Action() {
//				
//				public void act() {
//					viewObjects.add(artifactDescription);
//				}
//			});
//			viewObjects.add(artifact);
			viewObjects.add(deathMessage);
		}
		
	}
}
