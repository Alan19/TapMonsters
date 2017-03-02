package interfaces;

import java.util.ArrayList;

import guiPractice.components.Graphic;

public interface MonDexInterface{
		
	
	void SetDescription(String des);
	
	int setNumEncountered(int encounters);

	/**
	 *@Alan
	 */

	String getName();
	
	ArrayList<Graphic> getMonsters();
}
