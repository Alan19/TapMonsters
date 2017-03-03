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
	private Graphics2D g;
	
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
		
		artifactsPurchased.add(a);
		Benefit.benefit = inventoryScreen.showLatestGain();
		//change x and y of clickablegraphic
		//viewObjects.add(b);
		displayArtifacts();
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		artifactsPurchased = new ArrayList();
		artNames = new ArrayList();
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
		
		
		
		//displayArtifacts();
		//benefits = new TextLabel(700,500,getWidth()/2,50,showLatestGain());
		
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
		artifactNum.setText("You have "+collected+ " artifacts.");
	}
	
	/*public void addArtifact(){
		//adds artifact to artifact array once it is purchased
		//for now artifacts will be displayed independent of artifacts
		//purchased
		artifactsPurchased = new ArrayList();
		//below i added all artifacts for demo purposes
		Artifact first = new Artifact("desc","WORLDLY ILLUMINATOR",50,
				//new Action(){
					//public void act(){
						//artifactName.setText(artifactsPurchased.get(0).getDescription());
					//}
				//}
	null, "src/storeImages/arti1.png",0);
		
		Artifact second = new Artifact("PREVENTS CERTAIN DEATH ONCE","WARRIOR'S REVIVAL",50,
	null, "src/storeImages/arti2.png",0);
		Artifact third = new Artifact("desc","DIVINE CHALICE",50,
	null, "src/storeImages/arti3.png",0);
		Artifact fourth = new Artifact("INCREASES DAMAGE BY 25%, HEALS YOU","CRAFTER'S ELIXIR",50,
	null, "src/storeImages/arti4.png",0);
		Artifact fifth = new Artifact("desc","KNIGHT'S SHIELD",50,
	null, "src/storeImages/arti5.png",0);
		Artifact sixth = new Artifact("desc","UNDEAD AURA",50,
	null, "src/storeImages/arti6.png",0);
		Artifact seventh = new Artifact("desc","DARK CLOAK",50,
	null, "src/storeImages/arti7.png",0);
		Artifact eighth = new Artifact("desc","CROWN EGG",50,
	null, "src/storeImages/arti8.png",0);
		Artifact ninth = new Artifact("desc","HERO'S SWORD",50,
	null, "src/storeImages/arti9.png",0);
		Artifact tenth = new Artifact("INCREASES THE AMOUNT OF RELICS EARNED","AMULET OF THE VALRUNES",50,
				null, "src/resources/amulet_of_the_valrunes.png",0);
		Artifact eleventh = new Artifact("desc","DEATH DANCE",50,
				null, "src/resources/death_dance.png",0);
		Artifact twelfth = new Artifact("INCREASES DAMAGE BY 100%","DEATH SEEKER",50,
				null, "src/resources/death_seeker.png",0);
		
		artifactsPurchased.add(first);
		artifactsPurchased.add(second);
		artifactsPurchased.add(third);
		artifactsPurchased.add(fourth);
		artifactsPurchased.add(fifth);
		artifactsPurchased.add(sixth);
		artifactsPurchased.add(seventh);
		artifactsPurchased.add(eighth);
		artifactsPurchased.add(ninth);
	}*/
	
	public String showLatestGain(){
		//displays the benefit of the artifact
		if(artifactsPurchased.size() > 0){
			return retrieveLatestGain(artifactsPurchased.get(artifactsPurchased.size()-1));
		}
			return "Go to the store to buy artifacts.";
		//return artNames.get(0);
	}
	
	public String retrieveLatestGain(Artifact lastCollectedArtifact){
		//takes the last artifact in the list and determines what to print on screen
		
			if(lastCollectedArtifact.getName() == "Wordly Illuminator"){
				return "You just gained 10 HP!";
			}
			if(lastCollectedArtifact.getName() == "Warrior's Revival"){
				return "You just gained 20 HP!";
			}
			if(lastCollectedArtifact.getName() == "Divine Chalice"){
				return "You just gained 35 HP!";
			}
			if(lastCollectedArtifact.getName() == "Tincture of Life"){
				return "You just gained 1.5 secs!";
			}
			if(lastCollectedArtifact.getName() == "Knight's Shield"){
				return "You just gained 3.5 secs!";
			}
			if(lastCollectedArtifact.getName() == "Undead Aura"){
				return "You just gained 5 secs!";
			}
			if(lastCollectedArtifact.getName() == "Dark Cloak"){
				return "You just gained a random reward!";
			}
			if(lastCollectedArtifact.getName() == "Crown Egg"){
				return "You just gained time!";
			}
			if(lastCollectedArtifact.getName() == "Hero's Sword"){
				return "You just gained nothing!";
			}
			return " ";
	}
	
	/*public void addArtifactNames(){
		
	}*/
	

	public void run() {
		
	}

}
