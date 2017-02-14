package main;

import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;

import guiPractice.ClickableScreen;
import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.TransparentRoundedRect;
import guiPractice.components.Visible;

public class StoreScreen extends ClickableScreen implements Runnable {
	
	private TextLabel greeting;
	private TextArea itemsInfo;
	private TransparentRoundedRect artifactsBG;
	private TransparentRoundedRect greetingBG;
	private TransparentRoundedRect itemInfoBG;
	private Button buyButton;
	private Graphic background;
	private Artifact currentArtifact;
	private ArrayList<Artifact> artifacts;
	private ArrayList<ClickableGraphic> artifactPictures;
	

	public StoreScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		greeting = new TextLabel((int)(getWidth()/5.5), 60, getWidth()-30, 40, "Welcome to the shop Adventurer!");
		greeting.setSize(50);
		itemsInfo = new TextArea(getWidth()-310, 140, 270, (int)(getHeight()/1.4), "Placeholder. This is a placeholder and nothing but a placeholder. Placeholders are good and serve as good stuff for testing.");
		
		greetingBG = new TransparentRoundedRect(15, 50, getWidth()-30, 60, 60, 60);
		artifactsBG = new TransparentRoundedRect(15, 130, getWidth()-350, (int)(getHeight()/1.3), 80, 80);
		itemInfoBG = new TransparentRoundedRect((int)(getWidth()-330), 130, 310, (int)(getHeight()/1.3), 80, 80);
		
		background = new Graphic(0, 0, getWidth(), getHeight(), "src/storeImages/bgimage.jpg");
		
		viewObjects.add(background);
		viewObjects.add(greetingBG);
		viewObjects.add(artifactsBG);
		viewObjects.add(itemInfoBG);
		viewObjects.add(itemsInfo);
		viewObjects.add(greeting);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		greeting = new TextLabel(20, 40, getWidth(), getHeight(), "Welcome to the shop Adventurer!!!!111!!!!!!111!!!!!");
		background = new Graphic(0, 0, getWidth(), getHeight(), "src/storeImages/bgimage.jpg");
		
		viewObjects.add(background);
		viewObjects.add(greeting);
	}

	public void run() {
		createArtifacts();
		createArtifactPics();
	}

	private void createArtifactPics() {
		artifactPictures = new ArrayList();
		
		for(int i = 0; i<artifacts.size(); i++){
			final int index = i;
			ClickableGraphic artifact = new ClickableGraphic(240, 240, artifacts.get(i).getImagePath());
			artifact.setAction(new Action(){
				public void act() {
//					artifacts.remove(artifacts.get(index).buyItem());
//					artifactPictures.remove(index);
//					viewObjects.remove(artifacts.get(index));
					artifacts.get(0).getAction().act();
				}
			});
			
			//onHover code
			
			viewObjects.add(artifact);
			artifactPictures.add(artifact);
		}	
	}

	private void createArtifacts() {
		artifacts = new ArrayList();
		Artifact arti1 = new Artifact("Placeholder", "Worldly Illuminator", 50, new Action(){
			public void act() {
				System.out.println("Ya ya yeet.");
			}
		}, "src/storeImages/arti1.png");
		//Artifact arti2 = new Artifact();
		
		artifacts.add(arti1);
	}

}
