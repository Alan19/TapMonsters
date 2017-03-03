package main;

import java.awt.Graphics2D;

import artifacts.Artifact;
import guiPractice.components.Component;
import interfaces.InventoryArtifacts;

public class Benefit extends Component implements InventoryArtifacts {

	public static String benefit;
	
	public Benefit(int x, int y) {
		
		super(x,y,100,100);
		benefit = "blank";
	}

	public void displayArtifacts() {
		// TODO Auto-generated method stub

	}

	public void addArtifact() {
		// TODO Auto-generated method stub

	}

	public void changeName() {
		// TODO Auto-generated method stub

	}

	public void changeDescription() {
		// TODO Auto-generated method stub

	}

	public String showLatestGain() {
		// TODO Auto-generated method stub
		if(InventoryScreen.artifactsPurchased.size() > 0){
			return retrieveLatestGain(InventoryScreen.artifactsPurchased.get(InventoryScreen.artifactsPurchased.size()-1));
		}
		return "nothing";
	}

	public String retrieveLatestGain(Artifact lastCollectedArtifact) {
		// TODO Auto-generated method stub
		if(lastCollectedArtifact.getName() == "HERO'S SWORD"){
			return "You just gained (benefit from HERO'S SWORD)!";
		}
		return "not hero sword";
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
