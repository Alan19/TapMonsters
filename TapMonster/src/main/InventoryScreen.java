package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;
import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.HoverableClickable;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.TransparentRoundedRect;
import guiPractice.components.Visible;
import interfaces.InventoryArtifacts;

public class InventoryScreen extends ClickableScreen implements Runnable{
	
	private TextLabel title;
	private TextLabel artifactName;
	private TextLabel artifactDescription;
	private TextLabel artifactNum;
	private int collected;
	private Button back;
	private TextLabel benefits;
	private ArrayList<String> artNames;
	private ArrayList<String> artBenefits;
	
	
	public static ArrayList<Artifact> artifactsPurchased;
	
	private TransparentRoundedRect info;
	
	
	private Graphic bkgd;
	static InventoryScreen inventoryScreen;

	public InventoryScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
		inventoryScreen = this;
	}

	
	public void purchaseItem(Artifact a, HoverableClickable b){
		//adds artifact purchased from store into artifactsPurchased ArrayList
		artifactsPurchased.add(a);
		Benefit.benefit = inventoryScreen.showLatestGain();
		displayArtifacts();
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		artifactsPurchased = new ArrayList();
		artNames = new ArrayList();
		artBenefits = new ArrayList();
		collected = artifactsPurchased.size();
		title = new TextLabel((int)(getWidth()/2.2),40,getWidth()/2,50, "Inventory");
		title.setSize(25);
		title.setFont("Impact");
		artifactName = new TextLabel(700,135,getWidth()/3,50,"Artifact Name");
		artifactDescription = new TextLabel(700,200,getWidth()/3,50,"Artifact Description");
		artifactNum = new TextLabel(700, 265, getWidth()/3, 50, "You have "+ collected+ " artifacts");
		info = new TransparentRoundedRect(getWidth()/2,getWidth()/10,getWidth()/3,300,50,50);
		bkgd = new Graphic(0,0,getWidth(),getHeight(),"src/resources/background.jpg");
		back = new Button(getWidth()/120,getWidth()/120,100,50, "Back", Color.red, new Action(){
			public void act(){
				TapMonsterGame.game.setScreen(TapMonsterGame.main);
			}
		});
		
		viewObjects.add(bkgd);
		viewObjects.add(title);	
		viewObjects.add(info);
		viewObjects.add(artifactName);
		viewObjects.add(artifactDescription);
		viewObjects.add(artifactNum);
		viewObjects.add(back);
		
		addArtifactNames();
		addArtifactBenefits();
		
		Benefit.benefit = showLatestGain();
		benefits = new TextLabel(700,500,getWidth()/2,50, Benefit.benefit);
		viewObjects.add(benefits);
	}
	
	public void displayArtifacts(){
		//displays purchased artifacts
		
		
		int[] xCoord = {50, 250, 450, 50, 250, 450, 50, 250, 450};
		int[] yCoord = {150, 150, 150, 350, 350, 350, 550, 550, 550};
		
		for(int i = 0; i < artifactsPurchased.size(); i++){
			final Artifact theArtifact = artifactsPurchased.get(i);
			ClickableGraphic artifact = new ClickableGraphic(xCoord[i],yCoord[i],
					artifactsPurchased.get(i).getImagePath());
			
			artifact.setAction(new Action(){
				public void act(){
					artifactName.setText(theArtifact.getName());
					artifactDescription.setText(theArtifact.getDescription());
				}
			});
			addObject(artifact);
			viewObjects.add(artifact);
		}
		if(artifactsPurchased.size() == 1){
			artifactNum.setText("You have "+artifactsPurchased.size()+ " artifact.");
		}
		if(artifactsPurchased.size() > 1){
			artifactNum.setText("You have "+artifactsPurchased.size()+ " artifacts.");
		}
		benefits.setText(Benefit.benefit);
	}
	
	public String showLatestGain(){
		//displays the benefit of the artifact
		if(artifactsPurchased.size() > 0){
			return retrieveLatestGain(artifactsPurchased.get(artifactsPurchased.size()-1));
		}
			return "Go to the store to buy artifacts.";
	}
	
	public String retrieveLatestGain(Artifact lastCollectedArtifact){
		//takes the last artifact in the list and determines what to print on screen
			for(int i = 0; i < artNames.size(); i++){
				if(lastCollectedArtifact.getName() == artNames.get(i)){
					return "You just gained "+artBenefits.get(i)+ "!";
				}
			}
			return "";
	}
	
	public void addArtifactNames(){
		//adds names of artifacts to artNames ArrayList
		artNames.add("Worldly Illuminator");
		artNames.add("Warrior's Revival");
		artNames.add("Divine Chalice");
		artNames.add("Tincture of Life");
		artNames.add("Knight's Shield");
		artNames.add("Undead Aura");
		artNames.add("Dark Cloak");
		artNames.add("Crown Egg");
		artNames.add("Hero's Sword");
	}
	
	public void addArtifactBenefits(){
		//adds benefit description of artifacts to artBenefits ArrayList
		artBenefits.add("10 HP");
		artBenefits.add("20 HP");
		artBenefits.add("35 HP");
		artBenefits.add("1.5 seconds");
		artBenefits.add("3.5 seconds");
		artBenefits.add("5 seconds");
		artBenefits.add("a random reward");
		artBenefits.add("a slight time slowdown");
		artBenefits.add("nothing");
	}
	

	public void run() {
		
	}

}
