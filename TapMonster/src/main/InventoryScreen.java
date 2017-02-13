package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.TextArea;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;
import guiPractice.Screen;
import guiPractice.components.Clickable;
import guiPractice.components.ClickableGraphic;
import guiPractice.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class InventoryScreen extends ClickableScreen implements Runnable{
	
	private TextLabel title;
	private TextLabel artifactName;
	private TextLabel artifactDescription;
	
	private ArrayList<artifacts.Artifact> artifacts;
	private Graphics2D g;

	public InventoryScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		title = new TextLabel((int)(getWidth()/2.5),40,getWidth()/2,50, "Inventory");
		viewObjects.add(title);	

	}

	//@Override
	//public void initAllObjects(ArrayList<Visible> viewObjects) {
	//	title = new TextLabel(40,85,700,25, "Inventory");
	//	viewObjects.add(title);
	//}

	//each artifact has a name and description
	//shows how many artifacts are collected
	
	
	private void displayArtifacts(){
		/*for(Artifact artifact:artifacts){
			ClickableGraphic item = new ClickableGraphic();
		}*/
		
	}
	
	private void changeDescription(){
		//artifactDescription = new TextLabel(120,85,500,25, );
	}
	
	private void changeName(){
		
	}
	
	private void addArtifact(){
		
	}

	public void run() {
		//g.setColor(Color.black);
		//g.drawRect(x, y, width, height);
	}

	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		

	}

}
