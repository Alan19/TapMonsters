package MonsterDex;

import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Graphic;
import interfaces.MonDexInterface;

public class MonsterGraphic extends Graphic{
	
	public static int MonX = 100;
	public static int MonY = 100;
	private static int randInt;
	
	public static String[] MonsterNames;
	public int[] Encounters = new int[MonsterNames.length];
	
	public MonsterGraphic(int x, int y, int w, int h, String species) {
		super(x, y, getMonster(species));
	}
	
	public static void SetX(int x){
		MonX = x;
	}
	
	public static void SetY(int y){
		MonY = y;
	}
	
	public int getX(){
		return MonX;
	}
	public int getY(){
		return MonY;
	}
	
	public static String getMonster(String type){
		if(type == "Beast"){
			getRandInt(type);
			return "MonsterSprites/Beast"+FilePaths[randInt]+".gif"; 
		}
		
		if(type == "Demon"){
			getRandInt(type);
			return "MonsterSprites/Demon"+FilePaths[randInt]+".gif";
		}

		if(type == "Fiend"){
			getRandInt(type);
			return "MonsterSprites/Fiend"+FilePaths[randInt]+".gif";
		}
		
		if(type == "Monster"){
			getRandInt(type);
			return "MonsterSprites/Monster"+FilePaths[randInt]+".gif";
		}

		if(type == "Thingy"){
			getRandInt(type);
			return "MonsterSprites/Thingy"+FilePaths[randInt]+".gif";
		}
		
		else if(type == "Titan"){
			getRandInt(type);
			return "MonsterSprites/Titan"+FilePaths[randInt]+".gif";
		}
		return null;
	}

	private static void getRandInt(String type) {
		if(type == "Beast"){
			randInt = (int) (Math.random()*12);
		}
		
		if(type == "Demon"){
			randInt = (int) (Math.random()*11) + 12;
		}

		if(type == "Fiend"){
			randInt = (int) (Math.random()*11) + 23;
		}
		
		if(type == "Monster"){
			randInt = (int) (Math.random()*8) + 44;
		}

		if(type == "Thingy"){
			randInt = (int) (Math.random()*8) + 52;
		}
		
		if(type == "Titan"){
			randInt = (int) (Math.random()*11) + 60;
		}
	}

	
	
	

}
