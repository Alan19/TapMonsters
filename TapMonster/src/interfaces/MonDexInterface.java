package interfaces;

import guiPractice.components.Clickable;

public interface MonDexInterface{
		
	void SetDescription(String des);
	
	int setNumEncountered(int encounters);

	/**
	 *@Alan
	 */
	String getImagePath();

	String getName();
}
