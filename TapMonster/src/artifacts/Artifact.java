package artifacts;

import java.awt.image.BufferedImage;

public class Artifact implements ArtifactInterface{
	
	private String description;
	private int price;
	private BufferedImage icon;
	private String name;

	public Artifact(Player player, String desc, String name, int price /*image link stuff*/) {
		this.description = desc;
		this.price = price;
		this.name = name;
	}
	
	public Artifact buyItem(){
		return this;
	}

	public String getDescription(){
		return description;
	}
	
	public int getPrice(){
		return price;
	}

}
