package artifacts;

import guiPractice.components.Action;

import java.awt.image.BufferedImage;

public class Artifact implements ArtifactInterface{
	
	private String description;
	private int price;
	private String imagePath;
	private String name;
	private Action action;

	public Artifact(String desc, String name, int price, Action action, String imagePath) {
		this.description = desc;
		this.price = price;
		this.name = name;
		this.action = action;
		this.imagePath = imagePath;
	}
	
	public Artifact buyItem(){
		action.act();
		return this;
	}

	public String getDescription(){
		return description;
	}
	
	public String getName(){
		return name;
	}

	public int getPrice(){
		return price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public BufferedImage getIcon() {
		return null;
	}

}
