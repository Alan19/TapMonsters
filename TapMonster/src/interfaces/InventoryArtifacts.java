package interfaces;

import artifacts.Artifact;

public interface InventoryArtifacts {
	public String showLatestGain();
	public String retrieveLatestGain(Artifact lastCollectedArtifact);
}
