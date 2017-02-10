package main;

import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.Screen;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class StoreScreen extends ClickableScreen {
	
	private TextLabel greeting;
	private TextLabel itemsInfo;
	private Graphic background;
	private Artifact currentArtifact;

	public StoreScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> arg0) {
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		greeting = new TextLabel(20, 40, getWidth(), getHeight(), "Welcome to the shop Adventurer!!!!111!!!!!!111!!!!!");
		background = new Graphic(0, 0, getWidth(), getHeight(), "storeImages/")
	}

}
