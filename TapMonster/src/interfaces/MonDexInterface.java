package interfaces;

import guiPractice.components.Clickable;

public interface MonDexInterface{
		
	void SetDescription(String des);
	
	int setNumEncountered(int encounters);

	String getFilePath();
	/**
	 *@Alan
	 */
	String getImagePath();

	String getName();
}
