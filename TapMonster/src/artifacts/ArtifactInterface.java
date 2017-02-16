package artifacts;

import guiPractice.components.Action;

import java.awt.image.BufferedImage;

public interface ArtifactInterface {
	public Artifact buyItem();
	
	public int getPrice();
	
	public Action getAction();
	
	/**
	 * @author Alan19
	 *
	 */
	public String getDescription();
	
	public String getImagePath();
		
	public String getName();
	
}
