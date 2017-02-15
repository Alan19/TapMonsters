package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.TextArea;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;
import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Clickable;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.TransparentRoundedRect;
import guiPractice.components.Visible;

public class InventoryScreen extends ClickableScreen implements Runnable{
	
	private TextLabel title;
	private TextLabel artifactName;
	private TextLabel artifactDescription;
	
	private ArrayList<Artifact> artifactsPurchased;
	private Graphics2D g;
	
	private TransparentRoundedRect info;
	
	private String[] descArray = {""};
	private String[] namesArray = {""};
	private int[] priceArray = {};
	private String[] images = {""};
	
	private Graphic bkgd;

	public InventoryScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		title = new TextLabel((int)(getWidth()/2.5),40,getWidth()/2,50, "Inventory");
		artifactName = new TextLabel(700,135,getWidth()/3,50,"artifact name");
		artifactDescription = new TextLabel(700,200,getWidth()/3,50,"artifact desc");
		info = new TransparentRoundedRect(700,120,getWidth()/3,300,50,50);
		bkgd = new Graphic(0,0,getWidth(),getHeight(),"src/resources/background.jpg");
		viewObjects.add(bkgd);
		viewObjects.add(title);	
		viewObjects.add(info);
		viewObjects.add(artifactName);
		viewObjects.add(artifactDescription);
		
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
		
		//for now artifacts will be displayed independent of
		//items bought
		
		int[] xCoord = {50, 250, 450, 50, 250, 450, 50, 250, 450};
		int[] yCoord = {150, 150, 150, 350, 350, 350, 550, 550, 550};
		
		for(int i = 0; i < artifactsPurchased.size(); i++){
			ClickableGraphic artifact = new ClickableGraphic(xCoord[i],yCoord[i],
					artifactsPurchased.get(i).getImagePath());
			
			artifact.setAction(new Action(){
				public void act(){
					//System.out.println("test");
					artifactName.setText("test");
					//artifactsPurchased.get(0).getDescription();
				}
			});
			viewObjects.add(artifact);
		}
		
	}
	
	private void changeDescription(){
		//dont need this
		//changes desc of artifact in the info space
		
		//artifactDescription = new TextLabel(120,85,500,25, );
	}
	
	private void changeName(){
		//dont need this
		//changes name of artifact in the info space11
	}
	
	private void addArtifact(){
		//adds artifact to artifact array once it is purchased
		//for now artifacts will be displayed independent of artifacts
		//purchased
		artifactsPurchased = new ArrayList();
		Artifact first = new Artifact("desc","worldly illuminator",50,
				//new Action(){
					//public void act(){
						//artifactName.setText(artifactsPurchased.get(0).getDescription());
					//}
				//}
	null, "src/storeImages/arti1.png");
		
		Artifact second = new Artifact("desc","two",50,
	null, "src/storeImages/arti2.png");
		Artifact third = new Artifact("desc","three",50,
	null, "src/storeImages/arti3.png");
		Artifact fourth = new Artifact("desc","four",50,
	null, "src/storeImages/arti4.png");
		Artifact fifth = new Artifact("desc","five",50,
	null, "src/storeImages/arti5.png");
		Artifact sixth = new Artifact("desc","six",50,
	null, "src/storeImages/arti6.png");
		Artifact seventh = new Artifact("desc","seven",50,
	null, "src/storeImages/arti7.png");
		Artifact eighth = new Artifact("desc","eight",50,
	null, "src/storeImages/arti8.png");
		Artifact ninth = new Artifact("desc","nine",50,
	null, "src/storeImages/arti9.png");
		
		artifactsPurchased.add(first);
		artifactsPurchased.add(second);
		artifactsPurchased.add(third);
		artifactsPurchased.add(fourth);
		artifactsPurchased.add(fifth);
		artifactsPurchased.add(sixth);
		artifactsPurchased.add(seventh);
		artifactsPurchased.add(eighth);
		artifactsPurchased.add(ninth);
	}

	public void run() {
		//g.setColor(Color.black);
		//g.drawRect(x, y, width, height);
		
		addArtifact();
		displayArtifacts();
	}

	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		

	}

}
