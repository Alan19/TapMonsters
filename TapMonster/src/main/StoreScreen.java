package main;

import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;

import guiPractice.ClickableScreen;
import guiPractice.Screen;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.TransparentRoundedRect;
import guiPractice.components.Visible;

public class StoreScreen extends ClickableScreen implements Runnable {
	
	private TextLabel greeting;
	private TextLabel itemsInfo;
	private TransparentRoundedRect artifactsBG;
	private TransparentRoundedRect greetingBG;
	private TransparentRoundedRect itemInfoBG;
	private Button buyButton;
	private Graphic background;
	private Artifact currentArtifact;
	private ArrayList<Artifact> artifacts;
	

	public StoreScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		greeting = new TextLabel((int)(getWidth()/5.5), 60, getWidth()-30, 40, "Welcome to the shop Adventurer!");
		greeting.setSize(50);
		
		greetingBG = new TransparentRoundedRect(15, 50, getWidth()-30, 60, 60, 60);
		artifactsBG = new TransparentRoundedRect(15, 130, getWidth()-350, (int)(getHeight()/1.3), 80, 80);
		itemInfoBG = new TransparentRoundedRect((int)(getWidth()-330), 130, 310, (int)(getHeight()/1.3), 80, 80);
		
		background = new Graphic(0, 0, getWidth(), getHeight(), "src/storeImages/bgimage.jpg");
		
		viewObjects.add(background);
		viewObjects.add(greetingBG);
		viewObjects.add(artifactsBG);
		viewObjects.add(itemInfoBG);
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
	}

	private void createArtifacts() {
		artifacts = new ArrayList();
		
	}

}
