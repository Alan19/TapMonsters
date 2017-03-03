package main;

import guiPractice.components.Graphic;
import interfaces.MonsterInterface;

public class MonsterGraphic extends Graphic implements MonsterInterface{
	
	public static int MonX = 100;
	public static int MonY = 100;
	private static int randInt;
	public static String tempName;
	private static String monName;
	private static boolean isBoss;
	
	public static String[] beast = {"Anguiform","Bismarck","Fidor","Harpiai","Nastidon","Palidor",
			"Prussian","Red_Wolf","Sand_Horse","Toe_Cutter","Vulture","Were-Rat"};
	public static String[] demon = {"Daredevil","Chupon","Crucifix","Doom Gaze","Harvester","Hidon",
			"Shaman","Slam_Dancer","Steroidite","Tritoch","Trixter"};
	public static String[] fiend = 	{"BioSoldier","Brawler","Guard","Hemophyte","Ninja","Parasoul",
			"Pipsqueak","Samurai","ShadowDancer","Test Rider","Yojimbo"};
	public static String[] monster = {"BoneDragon","Cactuar","Esper","Evil_Oscar","MagicPot",
			"Sandcrawler","Uroburos","WhiteFlame"};
	public static String[] thingy = {"Adamanchyt","Deep Eye","Flan","Mag Roadie","Poplium","Pug",
			"Veteren","Wart Puck"};
	public static String[] titan = {"#128","Atma Weapon","Behemoth","Borras","Chimera","Czar Dragon",
			"Didalos","Kefka","Ultros","Zombone","Zone Eater"};

	
	
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
		System.out.println("Type:" + type);
		if(type.equals("Beast")){
			getRandInt(type);
			tempName = "MonsterSprites/Beast/"+beast[randInt]+".gif";
			System.out.println(tempName);
			monName = beast[randInt];
			return tempName;
		}
		
		else if(type.equals("Demon")){
			getRandInt(type);
			tempName = "MonsterSprites/Demon/"+demon[randInt]+".gif";
			System.out.println(tempName);
			monName = beast[randInt];
			return tempName;
		}

		else if(type.equals("Fiend")){
			getRandInt(type);
			tempName = "MonsterSprites/Fiend/"+fiend[randInt]+".gif";
			System.out.println(tempName);
			monName = beast[randInt];
			return tempName;
		}
		
		else if(type.equals("Monster")){
			getRandInt(type);
			tempName = "MonsterSprites/Monster/"+monster[randInt]+".gif";
			System.out.println(tempName);
			monName = beast[randInt];
			return tempName;	
			}

		else if(type.equals("Thingy")){
			getRandInt(type);
			tempName = "MonsterSprites/Thingy/"+thingy[randInt]+".gif";
			System.out.println(tempName);
			monName = beast[randInt];
			return tempName;
			}
		
		else if(type.equals("Titan")){
			getRandInt(type);
			isBoss = true;
			tempName = "MonsterSprites/Titan/"+titan[randInt]+".gif";
			System.out.println(tempName);
			monName = beast[randInt];
			return tempName;
			}
		
		getRandInt(type);
		
		return "MonsterSprites/Beast/"+thingy[randInt]+".gif"; 
	}

	private static void getRandInt(String type) {
		if(type == "Beast"){
			randInt = (int) (Math.random()*beast.length);
		}
		
		else if(type == "Demon"){
			randInt = (int) (Math.random()*demon.length);
		}

		else if(type == "Fiend"){
			randInt = (int) (Math.random()*fiend.length);
		}
		
		else if(type == "Monster"){
			randInt = (int) (Math.random()*monster.length);
		}

		else if(type == "Thingy"){
			randInt = (int) (Math.random()*thingy.length);
		}
		
		else if(type == "Titan"){
			randInt = (int) (Math.random()*titan.length);
		}
//		randInt = (int) (Math.random()*12);
	}
	
	public String getImagePath() {
		return tempName;
		
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	public int RaiseEnCounter(int encounters) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isBossMonster() {
		return isBoss;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
