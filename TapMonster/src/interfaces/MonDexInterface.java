package interfaces;

import java.util.ArrayList;

import MonsterDex.MonsterGraphic;
import guiPractice.components.Clickable;

public interface MonDexInterface{
		
	void SetDescription(String des);
	
	int setNumEncountered(int encounters);

	/**
	 *@Alan
	 */
	String getImagePath();

	String getName();
	
	ArrayList<MonsterGraphic> getMonsters();
}
