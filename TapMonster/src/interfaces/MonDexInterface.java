package interfaces;

import java.util.ArrayList;

import guiPractice.components.Clickable;
import main.Monster;

public interface MonDexInterface{
		
	
	void SetDescription(String des);
	
	int setNumEncountered(int encounters);

	/**
	 *@Alan
	 */
	String getImagePath();

	String getName();
	
	ArrayList<Monster> getMonsters();
}
