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
	private TextArea playerLifeBox;
	private TransparentRoundedRect artifactsBG;
	private TransparentRoundedRect greetingBG;
	private TransparentRoundedRect itemInfoBG;
	private Button backButton;
	private Graphic background;
	private int playerBalance;
	private int playerLife;
	private TextLabel score;
	

	public StoreScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		playerBalance = 10000;
		playerLife = 3;
		greeting = new TextLabel((int)(getWidth()/5.5), 60, getWidth()-30, 40, "Welcome to the shop Adventurer!");
		greeting.setSize(50);
		playerLifeBox = new TextArea(getWidth()-310, 510, 270, 40, "You have: " + playerLife + " Lives");
		playerMoney = new TextArea(getWidth()-310, 470, 270, 40, "You have: " + playerBalance + " Relics");
		itemsInfo = new TextArea(getWidth()-310, 140, 270, (int)(getHeight()/1.4), "Placeholder. This is a placeholder and nothing but a placeholder. Placeholders are good and serve as good stuff for testing.");
		
		greetingBG = new TransparentRoundedRect(15, 50, getWidth()-30, 60, 60, 60);
		artifactsBG = new TransparentRoundedRect(15, 130, getWidth()-350, (int)(getHeight()/1.3), 80, 80);
		itemInfoBG = new TransparentRoundedRect((int)(getWidth()-330), 130, 310, (int)(getHeight()/1.3), 80, 80);
		
		backButton = new Button(getWidth()-310, 620, 250, 50, "Back", Color.GRAY, new Action(){
			public void act(){
				TapMonsterGame.game.setScreen(TapMonsterGame.main);
			}
		});
		
		background = new Graphic(0, 0, getWidth(), getHeight(), "src/storeImages/bgimage.jpg");
		score = new TextLabel(getWidth()-310, 600, 270, 20, Integer.toString(TapMonsterScreen.score.score));
		
		viewObjects.add(background);
		viewObjects.add(greetingBG);
		viewObjects.add(artifactsBG);
		viewObjects.add(itemInfoBG);
		viewObjects.add(itemsInfo);
		viewObjects.add(playerMoney);
		viewObjects.add(playerLifeBox);
		viewObjects.add(backButton);
		viewObjects.add(greeting);
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
					if(playerBalance >= boughtArtifact.getPrice()){
						int index = 0;
						playerBalance -= boughtArtifact.getPrice();
						playerMoney.setText("You have: " + playerBalance + " Relics");
						TapMonsterGame.artifacts.remove(boughtArtifact.buyItem());
						TapMonsterScreen.score.addArtifact(boughtArtifact.getScore());
						score.setText(Integer.toString(TapMonsterScreen.score.score));
						for(int i=0; i<TapMonsterGame.artifactPictures.size(); i++){
							if(TapMonsterGame.artifactPictures.get(i).getImagePath().equals(boughtArtifact.getImagePath())){
								index = i;
							}
						}
						viewObjects.remove(TapMonsterGame.artifactPictures.remove(index));
//						viewObjects.remove(TapMonsterGame.artifactPictures.get(index));
//						TapMonsterGame.artifactPictures.remove(index);
					}
				}
			});
			
			artifact.setHoverAction(new Action(){
				public void act() {
					itemsInfo.setText(boughtArtifact.getDescription());
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
		Artifact arti1 = new Artifact("Placeholder", "Worldly Illuminator", 50, new Action(){
			public void act() {
				playerLife++;
				playerLifeBox.setText("You have: " + playerLife + " Lives");
				System.out.println("Somebody");
			}
		}, "src/storeImages/arti1.png", 50);
		
		Artifact arti2 = new Artifact("Placeholder", "Name#2", 50, new Action(){
			public void act() {
				TapMonsterGame.main.setTimeLeft(35.0);
				System.out.println("once");
			}
		}, "src/storeImages/arti2.png", 100);
		
		Artifact arti3 = new Artifact("Placeholder", "Name#3", 50, new Action(){
			public void act() {
				System.out.println("told");
			}
		}, "src/storeImages/arti3.png", 150);
		
		Artifact arti4 = new Artifact("Placeholder", "Name#4", 50, new Action(){
			public void act() {
				System.out.println("me");
			}
		}, "src/storeImages/arti4.png", 200);
		
		Artifact arti5 = new Artifact("Placeholder", "Name#5", 50, new Action(){
			public void act() {
				System.out.println("the");
			}
		}, "src/storeImages/arti5.png", 250);
		
		Artifact arti6 = new Artifact("Placeholder", "Name#6", 50, new Action(){
			public void act() {
				System.out.println("world");
			}
		}, "src/storeImages/arti6.png", 300);
		
		Artifact arti7 = new Artifact("Placeholder", "Name#7", 50, new Action(){
			public void act() {
				System.out.println("is");
			}
		}, "src/storeImages/arti7.png", 350);
		
		Artifact arti8 = new Artifact("Placeholder", "Name#8", 50, new Action(){
			public void act() {
				System.out.println("gonna");
			}
		}, "src/storeImages/arti8.png", 400);
		
		Artifact arti9 = new Artifact("Placeholder", "Name#9", 50, new Action(){
			public void act() {
				System.out.println("roll me.");
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
