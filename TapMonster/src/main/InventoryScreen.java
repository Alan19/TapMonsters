package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.TextArea;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import artifacts.Artifact;
import guiPractice.Screen;
import guiPractice.components.Clickable;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class InventoryScreen extends ClickableScreen implements Runnable, Clickable{
	
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

	//@Override
	//public void initObjects(ArrayList<Visible> arg0) {
		

	//}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		title = new TextLabel(40,85,700,25, "Inventory");
		viewObjects.add(title);
	}

	//each artifact has a name and description
	//shows how many artifacts are collected
	
	
	private void displayArtifacts(){
		for(Artifact artifact:artifacts){
			ClickableGraphic item = new ClickableGraphic();
		}
		
	}
	
	private void changeDescription(){
		artifactDescription = new TextLabel(120,85,500,25, );
	}
	
	private void changeName(){
		
	}
	
	private void addArtifact(){
		
	}

	@Override
	public void run() {
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
