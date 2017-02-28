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
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.TransparentRoundedRect;
import guiPractice.components.Visible;
import interfaces.InventoryArtifacts;

public class InventoryScreen extends ClickableScreen implements Runnable, InventoryArtifacts{
	
	private TextLabel title;
	private TextLabel artifactName;
	private TextLabel artifactDescription;
	private TextLabel artifactNum;
	private int collected;
	private Button back;
	//private Button purchaseAllArtifactss;
	
	public ArrayList<Artifact> artifactsPurchased;
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

	/*@Override
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
		
	}*/

	//@Override
	//public void initAllObjects(ArrayList<Visible> viewObjects) {
	//	title = new TextLabel(40,85,700,25, "Inventory");
	//	viewObjects.add(title);
	//}

	//each artifact has a name and description
	//shows how many artifacts are collected
	//can make interface for adding "you gained +something" for
	//every artifact that is collected in the inventory
	//when player loses, pass in artifacts ArrayList
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		collected = 9;
		title = new TextLabel((int)(getWidth()/1.2),40,getWidth()/2,50, "Inventory");
		artifactName = new TextLabel(700,135,getWidth()/3,50,"artifact name");
		artifactDescription = new TextLabel(700,200,getWidth()/3,50,"artifact desc");
		artifactNum = new TextLabel(700, 265, getWidth()/3, 50, "You have "+ collected+ " artifacts");
		info = new TransparentRoundedRect(getWidth()/2,getWidth()/10,getWidth()/3,300,50,50);
		bkgd = new Graphic(0,0,getWidth(),getHeight(),"src/resources/background.jpg");
		back = new Button(getWidth()/120,getWidth()/120,100,50, "Back", Color.red, new Action(){
			public void act(){
				//back to main screen
			}
		});
		
		/*purchaseAllArtifacts = new Button(10,10,100,50, "Show all artifacts", Color.red, new Action(){
			public void act(){
				collected = 9;
				artifactNum.setText("You have "+ collected+ " artifacts");
				displayArtifacts();
			}
		});*/
		viewObjects.add(bkgd);
		viewObjects.add(title);	
		viewObjects.add(info);
		viewObjects.add(artifactName);
		viewObjects.add(artifactDescription);
		viewObjects.add(artifactNum);
		viewObjects.add(back);
		//viewObjects.add(purchaseAllArtifacts);
		addArtifact();
		displayArtifacts();

	}
	
	public void displayArtifacts(){
		//displays purchased artifacts
		
		/*for(Artifact artifact:artifacts){
			ClickableGraphic item = new ClickableGraphic();
		}*/
		
		//for now artifacts will be displayed independent of
		//items bought
		
		int[] xCoord = {50, 250, 450, 50, 250, 450, 50, 250, 450};
		int[] yCoord = {150, 150, 150, 350, 350, 350, 550, 550, 550};
		
		for(int i = 0; i < artifactsPurchased.size(); i++){
			final Artifact theArtifact = artifactsPurchased.get(i);
			ClickableGraphic artifact = new ClickableGraphic(xCoord[i],yCoord[i],
					artifactsPurchased.get(i).getImagePath());
			
			artifact.setAction(new Action(){
				public void act(){
					//System.out.println("test");
					artifactName.setText(theArtifact.getName());
					artifactDescription.setText(theArtifact.getDescription());
					//artifactsPurchased.get(0).getDescription();
				}
			});
			viewObjects.add(artifact);
		}
		
	}
	
	public void changeDescription(){
		//dont need this
		//changes desc of artifact in the info space
		
		//artifactDescription = new TextLabel(120,85,500,25, );
	}
	
	public void changeName(){
		//dont need this
		//changes name of artifact in the info space11
	}
	
	public void addArtifact(){
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
	}

	public void run() {
		//g.setColor(Color.black);
		//g.drawRect(x, y, width, height);
		
		
	}

}
