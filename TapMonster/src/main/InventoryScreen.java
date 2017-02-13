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
import guiPractice.components.TransparentRoundedRect;
import guiPractice.components.Visible;

public class InventoryScreen extends ClickableScreen implements Runnable{
	
	private TextLabel title;
	private TextLabel artifactName;
	private TextLabel artifactDescription;
	
	private ArrayList<artifacts.Artifact> artifacts;
	private Graphics2D g;
	
	private TransparentRoundedRect info;

	public InventoryScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		title = new TextLabel((int)(getWidth()/2.5),40,getWidth()/2,50, "Inventory");
		//artifactName = new TextLabel(700,135,getWidth()/3,50,"");
		//artifactDescription = new TextLabel();
		info = new TransparentRoundedRect(700,120,getWidth()/3,300,50,50);
		viewObjects.add(title);	
		viewObjects.add(info);

	}

	//@Override
	//public void initAllObjects(ArrayList<Visible> viewObjects) {
	//	title = new TextLabel(40,85,700,25, "Inventory");
	//	viewObjects.add(title);
	//}

	//each artifact has a name and description
	//shows how many artifacts are collected
	
	
	private void displayArtifacts(){
		//displays purchased artifacts
		
		/*for(Artifact artifact:artifacts){
			ClickableGraphic item = new ClickableGraphic();
		}*/
		
	}
	
	private void changeDescription(){
		//changes desc of artifact in the info space
		
		//artifactDescription = new TextLabel(120,85,500,25, );
	}
	
	private void changeName(){
		//changes name of artifact in the info space
	}
	
	private void addArtifact(){
		//adds artifact to artifact array once it is purchased
	}

	public void run() {
		//g.setColor(Color.black);
		//g.drawRect(x, y, width, height);
	}

	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		

	}

}
