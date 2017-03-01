package interfaces;

import artifacts.Artifact;

public interface InventoryArtifacts {
	public void displayArtifacts();
	public void addArtifact();
	public void changeName();
	public void changeDescription();
	public String showLatestGain();
	public String retrieveLatestGain(Artifact lastCollectedArtifact);
}
