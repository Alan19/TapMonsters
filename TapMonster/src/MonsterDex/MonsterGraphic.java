package MonsterDex;

import guiPractice.components.Action;
import guiPractice.components.Graphic;

public class MonsterGraphic extends Graphic{
	
	private static int MonID;

	public MonsterGraphic(int x, int y, int w, int h, int species) {
		super(x, y, w, h, getMonster(species));
	}

	private static String getMonster(int species) {
//		return "src/MonsterSprites/"
//			+Integer.toString(species)
//				+randInt()
//					+".gif";
		return "src/MonsterSprites/"+species+".gif";
	}
	
	private static String randInt() {
		return Integer.toString((int)(Math.random()*10));
	}

	public void act() {
		// TODO Auto-generated method stub
		
	}

	
	
}
