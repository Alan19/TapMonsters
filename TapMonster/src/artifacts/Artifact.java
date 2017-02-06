package artifacts;

import guiPractice.components.Action;

import java.awt.image.BufferedImage;

public class Artifact implements ArtifactInterface{
	
	private String description;
	private int price;
	private BufferedImage icon;
	private String name;
	private Action action;

	public Artifact(String desc, String name, int price, Action action /*image link stuff*/) {
		this.description = desc;
		this.price = price;
		this.name = name;
		this.action = action;
	}
	
	public Artifact buyItem(){
		//action.act();
		return this;
	}

	public String getDescription(){
		return description;
	}
	
	public int getPrice(){
		return price;
	}

}
