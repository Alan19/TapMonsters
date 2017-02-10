package interfaces;

import guiPractice.components.Clickable;

public interface MonDexInterface extends Clickable{
		
	void SetDescription(String des);
	
	int setNumEncountered(int encounters);
}
