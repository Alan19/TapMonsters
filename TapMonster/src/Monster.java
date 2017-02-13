import java.awt.Image;

import guiPractice.components.Graphic;
import interfaces.MonsterInterface;

public class Monster extends Graphic implements MonsterInterface{
	
	public Monster(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		
	}

	private int encounter = 1;

	

	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	public int RaiseEnCounter(int encounters) {
		// TODO Auto-generated method stub
		return 0;
	}
}	
