package MonsterDex;

import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Graphic;
import interfaces.MonDexInterface;

public class MonsterGraphic extends Graphic implements MonDexInterface{
	
	public static int MonX = 100;
	public static int MonY = 100;
	private static int randInt;
	
	public static String[] FilePaths = {""};
	public int[] Encounters = new int[FilePaths.length];
	
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
			getRandInt(type)
			return "MonsterSprites/Beast"+FilePaths[randInt]+""; 
		}
		
		if(type == "Demon"){
			
		}

		if(type == "Fiend"){
	
		}
		
		if(type == "Monster"){
			
		}

		if(type == "Thingy"){
			
		}
		
		if(type == "Titan"){
			
		}

	}

	private static void getRandInt(String type) {
		if(type == "Beast"){
			randInt = (int) (Math.random()*12);
		}
		
		if(type == "Demon"){
			
		}

		if(type == "Fiend"){
	
		}
		
		if(type == "Monster"){
			
		}

		if(type == "Thingy"){
			
		}
		
		if(type == "Titan"){
			
		}
	}

	public void SetDescription(String des) {
		// TODO Auto-generated method stub
		
	}

	public int setNumEncountered(int encounters) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MonsterGraphic> getMonsters() {
		
	}
	
	
	
	

}
