package main;

import java.awt.image.BufferedImage;

public interface Artifact {
	public String getDescription();
	public String getName();
	public BufferedImage getIcon();
	public String getImagePath();
}
