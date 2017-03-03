package interfaces;

import java.util.ArrayList;

import main.MonsterGraphic;

public interface MonDexInterface{
		
	ArrayList<MonsterGraphic> monsters = new ArrayList<MonsterGraphic>();
	
	void SetDescription(String des);
	
	int setNumEncountered(int encounters);

	/**
	 *@Alan
	 */

	String getName();
	
	ArrayList<monsterDex.MonsterGraphic> getMonsters();
}
