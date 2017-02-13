import java.awt.Image;

import interfaces.MonsterInterface;

public class Monster extends Graphic implements MonsterInterface{
	
	private int encounter = 1;

	public Mole(int x, int y) {
		super(x, y, .50, "resources/sampleImages/"+encounter+".jpg");
	
	}
}	
