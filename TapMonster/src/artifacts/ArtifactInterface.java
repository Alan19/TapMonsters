package artifacts;

import guiPractice.components.Action;

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
