package interfaces;

public interface MonsterInterface {

	void setName(String name);

	int RaiseEnCounter(int encounters);
	
	boolean isBossMonster();
	
	String getImagePath();
}
