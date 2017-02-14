package MonsterDex;

import guiPractice.components.Graphic;

public class MonsterGraphic extends Graphic{
	
	private static int MonsterId = 1;

	public MonsterGraphic(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h," MonsterSprites/"+MonsterId+".gif");
	}
	
	public void NextEntry(){
		MonsterId++;
	}
	
	public void NextSpecies(){
		MonsterId += 10;
	}
	
	public void BackEntry(){
		while(MonsterId == 1)
		MonsterId--;
	}
	
	public void BackSpecies(){
		while(MonsterId == 10)
		MonsterId -= 10;
	}

}
