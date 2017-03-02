package interfaces;

import java.util.ArrayList;

import guiPractice.components.Clickable;
import guiPractice.components.Graphic;
import main.Monster;

public interface MonDexInterface{
		
	
	void SetDescription(String des);
	
	int setNumEncountered(int encounters);

	/**
	 *@Alan
	 */
	String getImagePath();

	String getName();
	
	ArrayList<Graphic> getMonsters();
}
