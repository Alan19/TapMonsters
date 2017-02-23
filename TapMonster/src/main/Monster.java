package main;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import guiPractice.components.Component;

public class Monster extends Component implements MonsterName{

	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;

	public Monster(Game game,int x,int y) {
		super(x,y,WIDTH,HEIGHT);
		this.game = game;
		String temp = getName();
		while(wasNameUsed(temp)){
			temp = getName();
		}	
		names.add(temp);//adds the name of this monster to the history of all names ever created
		name = temp;//sets the name of this monster to temp
		initAbility();
		update();
	}

	private void initAbility() {
		if(element.equals("Poisonous")){
			ability = new MonsterAbility() {

				public void use() {
					// TODO Auto-generated method stub
					game.speedTimer();
				}

				public String getDescription() {
					// TODO Auto-generated method stub
					return "Speeds up the timer";
				}
			};	
		}else if(element.equals("Pyro")){
			ability = new MonsterAbility() {


				public void use() {
					// TODO Auto-generated method stub
					game.decreaseLife();
				}

				public String getDescription() {
					// TODO Auto-generated method stub
					return "Decreases health every 15 seconds you dont kill a monster";
				}

			};
		}else if(element.equals("Godly")){
			ability = new MonsterAbility() {


				public void use() {
					// TODO Auto-generated method stub
					game.addBossSequence();;
				}

				public String getDescription() {
					// TODO Auto-generated method stub
					return "Adds boss sequence";
				}

			};

		}else if(element.equals("Frost")){
			ability = new MonsterAbility() {


				public void use() {
					// TODO Auto-generated method stub
					game.freezeTimer();
				}

				public String getDescription() {
					// TODO Auto-generated method stub
					return "Freezes timer every 5 seconds you can't see the timer do down every second";
				}

			};
		}else{
			ability = new MonsterAbility() {


				public void use() {
					// TODO Auto-generated method stub
					game.nothing();
				}

				public String getDescription() {
					// TODO Auto-generated method stub
					return "Does nothing";
				}

			};

		}

	}

	public static void usablity(){
		ability.use();
	}

	public static String description(){
		return ability.getDescription();
	}

	private static String[] name1 = {"Terrifying","Big","Tiny","Dangerous","Angry","Cruel","Awesome","Friendly","Deathly","Lonely"};
	private static String[] name2 = {"Calm","Hasty","Lazy","Casual","Caring","Emotional","Brave","Honest","Fluffy","Safe"};
	private static String[] name3 = {"Beast","Fiend","Titan","Demon","Colossus","Savage","Monster","Animal","Thingy"};
	private static ArrayList<String> names = new ArrayList<String>();
	private static String[][] abilities = {{"Normal", "0"},{"Frost","1"},{"Pyro","2"},{"Poisonous","3"},{"Godly","4"}};
//	private static String[][] abilities = {{"Pyro", "0"},{"Pyro","1"},{"Pyro","2"},{"Pyro","3"},{"Pyro","4"}};
	private static final int[] RANGE_1 = {0,56,76,91,99};
	private static final int[] RANGE_2 = {55,75,90,98,100};

	private String name;

	private String element;
	private String monsterType;

	private Game game;
	private static MonsterAbility ability;

	//getter method for element
	private static boolean wasNameUsed(String name){
		if(names.size()<1)return false;
		boolean isUsed = false;
		for(int i = 0;i<names.size();i++){
			if(names.get(i)==name){
				isUsed = true;
				break;
			}else isUsed = false;
		}
		if(isUsed == true){
			return false;
		}
		else return true;
	}

	private String abilityProbability(){
		int random = (int)(Math.random()*RANGE_1.length);
		int randomTwo = (int)(Math.random()*100);
		for(int i = 0; i<RANGE_1.length;i++){
			if(RANGE_1[i]<=randomTwo&&randomTwo<=RANGE_2[i]){
				return abilities[i][0];
			}
		}
		return element;
	}

	
	public String getName(){
		name = " ";
		String element = abilityProbability();
		int r1 = (int)(Math.random()*name1.length);
		int r2 = (int)(Math.random()*name2.length);
		int r3 = (int)(Math.random()*name3.length);
		for(int i=0;i<4;i++){
			if(i==0)name += name1[r1] + " ";
			else if(i==1){
				name += element+ " ";
				this.element = element;
			}
			else if(i==2)name += name2[r2]+ " ";
			else{
				name += name3[r3];
				monsterType = name3[r3];
			}
		}
		return name;
	}


	@Override
	public void update(Graphics2D g) {
		if(name!=null){
			g.setColor(Color.white);
			g.drawString(name, 0, 20);
		}
	}

	//To do list
	//Create a next level button to test everything out 
	//

}