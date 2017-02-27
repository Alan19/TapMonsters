package interfaces;

import java.util.ArrayList;

import MonsterDex.MonsterGraphic;

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
