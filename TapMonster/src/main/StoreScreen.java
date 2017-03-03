package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import artifacts.Artifact;

import guiPractice.ClickableScreen;
import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.HoverableClickable;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.TransparentRoundedRect;
import guiPractice.components.Visible;

public class StoreScreen extends ClickableScreen implements Runnable {
	
	private TextLabel greeting;
	private TextArea playerMoney;
	private TextArea itemsInfo;
	private TextLabel artifactName;
	private TextLabel artifactPrice;
	private TransparentRoundedRect artifactsBG;
	private TransparentRoundedRect greetingBG;
	private TransparentRoundedRect itemInfoBG;
	private Button backButton;
	private Graphic background;
	private TextLabel score;
	

	public StoreScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		TapMonsterGame.main.setGold(10000);
		greeting = new TextLabel((int)(getWidth()/5.5), 60, getWidth()-30, 40, "Papyrus", 50, Color.white, "Welcome to the shop Adventurer!");
		artifactName = new TextLabel(getWidth()-310, 140, 270, 40, "Helvetica", 26, Color.white, "");
		artifactPrice = new TextLabel(getWidth()-310, 170, 270, 40, "Helvetica", 20, Color.white, "");
		
		playerMoney = new TextArea(getWidth()-310, 470, 270, 40, "You have: " + TapMonsterGame.main.getGoldVar() + " Relics");
		itemsInfo = new TextArea(getWidth()-310, 210, 270, (int)(getHeight()/1.4), "");
		
		greetingBG = new TransparentRoundedRect(15, 50, getWidth()-30, 60, 60, 60);
		artifactsBG = new TransparentRoundedRect(15, 130, getWidth()-350, (int)(getHeight()/1.3), 80, 80);
		itemInfoBG = new TransparentRoundedRect((int)(getWidth()-330), 130, 310, (int)(getHeight()/1.3), 80, 80);
		
		backButton = new Button(getWidth()-310, 600, 250, 50, "Back", Color.GRAY, new Action(){
			public void act(){
				TapMonsterGame.game.setScreen(TapMonsterGame.main);
			}
		});
		
		background = new Graphic(0, 0, getWidth(), getHeight(), "src/storeImages/bgimage.jpg");
		score = new TextLabel(getWidth()-310, 570, 270, 20, Integer.toString(TapMonsterScreen.score.score));
		
		viewObjects.add(background);
		viewObjects.add(greetingBG);
		viewObjects.add(artifactsBG);
		viewObjects.add(itemInfoBG);
		viewObjects.add(itemsInfo);
		viewObjects.add(playerMoney);
		viewObjects.add(backButton);
		viewObjects.add(greeting);
		viewObjects.add(artifactPrice);
		viewObjects.add(artifactName);
		viewObjects.add(score);
		
		createArtifacts();
		createArtifactPics();
	}

	public void run() {
	}

	public void createArtifactPics() {
		int[] xCoords = {70, 370, 670, 70, 370, 670, 70, 370, 670};
		int[] yCoords = {160, 160, 160, 340, 340, 340, 530, 530, 530};
		
		for(int i = 0; i<TapMonsterGame.artifacts.size(); i++){
			final Artifact boughtArtifact = TapMonsterGame.artifacts.get(i);
			HoverableClickable artifact = new HoverableClickable(xCoords[i], yCoords[i], TapMonsterGame.artifacts.get(i).getImagePath());
			artifact.setAction(new Action(){
				public void act() {
					if(TapMonsterGame.main.getGoldVar() >= boughtArtifact.getPrice()){
						int index = 0;
						TapMonsterGame.main.getGold(boughtArtifact.getPrice()*(-1));
						playerMoney.setText("You have: " + TapMonsterGame.main.getGoldVar() + " Relics");
						TapMonsterGame.artifacts.remove(boughtArtifact.buyItem());
						
						TapMonsterScreen.score.addArtifact(boughtArtifact.getScore());
						score.setText(Integer.toString(TapMonsterScreen.score.score));
						for(int i=0; i<TapMonsterGame.artifactPictures.size(); i++){
							if(TapMonsterGame.artifactPictures.get(i).getImagePath().equals(boughtArtifact.getImagePath())){
								index = i;
							}
						}
						TapMonsterGame.inventory.purchaseItem(boughtArtifact, TapMonsterGame.artifactPictures.get(index));
						remove(TapMonsterGame.artifactPictures.get(index));
						TapMonsterGame.artifactPictures.remove(index);
					}
				}
			});
			
			artifact.setHoverAction(new Action(){
				public void act() {
					itemsInfo.setText(boughtArtifact.getDescription());
					artifactPrice.setText("Price: " + Integer.toString(boughtArtifact.getPrice()) + " Relics");
					artifactName.setText(boughtArtifact.getName());
				}
			});
			
			artifact.setExitAction(new Action(){
				public void act() {
					itemsInfo.setText("");
				}
			});
			
			TapMonsterGame.artifactPictures.add(artifact);
			viewObjects.add(artifact);
		}	
	}

	public void createArtifacts() {
		Artifact arti1 = new Artifact("Increases HP by 10.", "Worldly Illuminator", 70, new Action(){
			public void act() {
				TapMonsterGame.main.increaseHearts(10);
				TapMonsterGame.main.fillHeart(10);
			}
		}, "src/storeImages/arti1.png", 50);
		
		Artifact arti2 = new Artifact("Increases HP by 20.", "Warrior's Revival", 150, new Action(){
			public void act() {
				TapMonsterGame.main.increaseHearts(20);
				TapMonsterGame.main.fillHeart(20);
			}
		}, "src/storeImages/arti2.png", 100);
		
		Artifact arti3 = new Artifact("Increases HP by 35.", "Divine Chalice", 250, new Action(){
			public void act() {
				TapMonsterGame.main.increaseHearts(35);
				TapMonsterGame.main.fillHeart(35);
			}
		}, "src/storeImages/arti3.png", 150);
		
		Artifact arti4 = new Artifact("Increases time by 1.5s.", "Tincture of Life", 50, new Action(){
			public void act() {
				TapMonsterGame.main.increaseTimeLeft(1.5);
			}
		}, "src/storeImages/arti4.png", 200);
		
		Artifact arti5 = new Artifact("Increases time by 3.5s.", "Knight's Shield", 80, new Action(){
			public void act() {
				TapMonsterGame.main.increaseTimeLeft(3.5);
			}
		}, "src/storeImages/arti5.png", 250);
		
		Artifact arti6 = new Artifact("Increases time by 5.0s.", "Undead Aura", 140, new Action(){
			public void act() {
				TapMonsterGame.main.increaseTimeLeft(5.0);
			}
		}, "src/storeImages/arti6.png", 300);
		
		Artifact arti7 = new Artifact("Get a random reward.", "Dark Cloak", 50, new Action(){
			public void act() {
				TapMonsterGame.main.setRandomReward();
			}
		}, "src/storeImages/arti7.png", 350);
		
		Artifact arti8 = new Artifact("Slows time down slightly.", "Crown Egg", 50, new Action(){
			public void act() {
				TapMonsterGame.main.setTimeAlter(.8);
			}
		}, "src/storeImages/arti8.png", 400);
		
		Artifact arti9 = new Artifact("Does literally nothing.", "Hero's Sword", 5000, new Action(){
			public void act() {
				
			}
		}, "src/storeImages/arti9.png", 450);
		
		TapMonsterGame.artifacts.add(arti1);
		TapMonsterGame.artifacts.add(arti2);
		TapMonsterGame.artifacts.add(arti3);
		TapMonsterGame.artifacts.add(arti4);
		TapMonsterGame.artifacts.add(arti5);
		TapMonsterGame.artifacts.add(arti6);
		TapMonsterGame.artifacts.add(arti7);
		TapMonsterGame.artifacts.add(arti8);
		TapMonsterGame.artifacts.add(arti9);
	}

}
