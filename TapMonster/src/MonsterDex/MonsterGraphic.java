package MonsterDex;

import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Graphic;
import interfaces.MonDexInterface;

public class MonsterGraphic extends Graphic{
	
	public static int MonX = 100;
	public static int MonY = 100;
	private static int randInt;
	
	public static String[] monsterNames = {
			"Anguiform","Bismarck","Fidor","Harpiai","Nastidon","Palidor","Prussian","Red_Wolf","Sand_Horse","Toe_Cutter","Vulture","Were-Rat"
			,"Acra","Chupon","Crucifix","Doom_Gaze","Harvester","Hidon","Sage","Slam_Dancer","Steroidite","Tritoch","Trixter",
			"BioSoldier","Brawler","Guard","Hemophyte","Ninja","Paramal","Pipsqueak","Samurai","ShadowDancer","Test_Rider","Yojimbo",
			"BoneDragon","Cactuar","Esper","Evil_Oscar","MagicPot","Sandcrawler","Uroburos","WhiteFlame",
			"Adamanchyt","Deep_Eye","Flan","Mag_Roadie","Poplium","Pug","Veteren","Wart_Puck"
			,"#128","Atma_Weapon","Behemoth","Borras","Chimera","Czar_Dragon","Didalos","Kefka","Ultros","Zombone","Zone_Eater"
	};
	public static int[] encounters = new int[monsterNames.length];
	
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
			return "MonsterSprites/Beast"+monsterNames[randInt]+".gif"; 
		}
		
		if(type == "Demon"){
			getRandInt(type);
			encounters[randInt] += 1;
			return "MonsterSprites/Demon"+monsterNames[randInt]+".gif";
		}

		if(type == "Fiend"){
			getRandInt(type);
			return "MonsterSprites/Fiend"+monsterNames[randInt]+".gif";
		}
		
		if(type == "Monster"){
			getRandInt(type);
			return "MonsterSprites/Monster"+monsterNames[randInt]+".gif";
		}

		if(type == "Thingy"){
			getRandInt(type);
			return "MonsterSprites/Thingy"+monsterNames[randInt]+".gif";
		}
		
		else if(type == "Titan"){
			getRandInt(type);
			return "MonsterSprites/Titan"+monsterNames[randInt]+".gif";
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
