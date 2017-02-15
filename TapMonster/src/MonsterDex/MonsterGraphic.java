package MonsterDex;

import guiPractice.components.Graphic;

public class MonsterGraphic extends Graphic{
	
	private static int MonsterId = 1;

	public MonsterGraphic(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h," MonsterSprites/"+MonsterId+".gif");
	}
	
	public void NextMon(){
		MonsterId++;
	}
	
	public void NextSpecies(){
		MonsterId += 10;
	}
	
	public void BackMon(){
		while(MonsterId == 1)
		MonsterId--;
	}
	
	public void BackSpecies(){
		while(MonsterId == 10)
		MonsterId -= 10;
	}
	
	public void NextEntry(){
		MonsterId += 6;
	}
	
	public void BackEntry(){
		MonsterId -= 6;
	}

}
