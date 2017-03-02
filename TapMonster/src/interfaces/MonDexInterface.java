package interfaces;

import java.util.ArrayList;

import guiPractice.components.Graphic;
import main.MonsterGraphic;

public interface MonDexInterface{
		
	
	void SetDescription(String des);
	
	int setNumEncountered(int encounters);

	/**
	 *@Alan
	 */

	String getName();
	
	ArrayList<MonsterGraphic> getMonsters();
}
