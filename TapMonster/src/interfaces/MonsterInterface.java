package interfaces;

public interface MonsterInterface {

	String getName();

	int RaiseEnCounter(int encounters);
	
	/**
	 *@Alan
	 */
	
	boolean isBossMonster();
	
	String getImagePath();
	
	void addToList();
}
