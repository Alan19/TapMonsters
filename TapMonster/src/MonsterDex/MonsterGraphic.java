package MonsterDex;

import guiPractice.components.Action;
import guiPractice.components.Graphic;

public class MonsterGraphic extends Graphic{
	
	public static int MonX;
	public static int MonY;
	
	static final Graphic Mon1 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/Anguiform");
	static final Graphic Mon2 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/Bismark");
	static final Graphic Mon3 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/Fidor");
	static final Graphic Mon4 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/1");
	static final Graphic Mon5 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/1");
	static final Graphic Mon6 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/1");
	static final Graphic Mon7 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/1");
	static final Graphic Mon8 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/1");
	static final Graphic Mon9 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/1");
	static final Graphic Mon10 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/1");
	static final Graphic Mon11 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/1");
	static final Graphic Mon12 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Beast/1");
	static final Graphic Mon13 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon14 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon15 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon16 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon17 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon18 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon19 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon20 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon21 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon22 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	static final Graphic Mon23 = new Graphic(GetX(), GetY(), 1, "MonsterSprites/Demon/1");
	
	public MonsterGraphic(int x, int y, int w, int h, String species) {
		super(x, y, species);
	}
	
	public static void SetX(int x){
		MonX = x;
	}
	
	public static void SetY(int y){
		MonY = y;
	}
	
	public static int GetX(){
		return MonX;
	}
	public static int GetY(){
		return MonY;
	}
	
	

}
