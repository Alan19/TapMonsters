package Monster;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import guiPractice.components.Component;

public class Monster extends Component implements MonsterName{

	private static final int WIDTH = 250;
	private static final int HEIGHT = 50;

	public Monster(Game game) {
		super(65,100,WIDTH,HEIGHT);
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
		if(element.equals("Poison")){
			ability = new MonsterAbility() {

				@Override
				public void use() {
					// TODO Auto-generated method stub
					game.speedTimer();
				}

				@Override
				public String getDescription() {
					// TODO Auto-generated method stub
					return "Speeds up the timer";
				}
			};	
		}else if(element.equals("Pyro")){
			ability = new MonsterAbility() {


				@Override
				public void use() {
					// TODO Auto-generated method stub
					game.decreaseLife();
				}

				@Override
				public String getDescription() {
					// TODO Auto-generated method stub
					return "Adds";
				}

			};
		}else if(element.equals("Godly")){
			ability = new MonsterAbility() {


				@Override
				public void use() {
					// TODO Auto-generated method stub
					game.addBossSequence();;
				}

				@Override
				public String getDescription() {
					// TODO Auto-generated method stub
					return "Decreases health every 15 seconds you dont kill a monster";
				}

			};
			
		}else if(element.equals("Frost")){
			ability = new MonsterAbility() {


				@Override
				public void use() {
					// TODO Auto-generated method stub
					game.freezeTimer();
				}

				@Override
				public String getDescription() {
					// TODO Auto-generated method stub
					return "Freezes timer every 5 seconds you can't see the timer do down every second";
				}

			};
		}

	}
	
	public static void usablity(){
		ability.use();
	}
	
	public static void description(){
		ability.getDescription();
	}

	private static String[] abilities = {"Godly","Frost","Pyro","Poison","Normal"};
	private static String[] name1 = {"Terrifying","Big","Tiny","Dangerous","Angry","Cruel","Awesome","Friendly","Deathly","Lonely"};
	private static String[] name2 = {"Calm","Hasty","Lazy","Casual","Caring","Emotional","Brave","Honest","Fluffy","Safe"};
	private static String[] name3 = {"Beast","Fiend","Brute","Demon","Colossus","Savage","Monster","Animal","Thingy"};
	private static ArrayList<String> names = new ArrayList<String>();

	private String name;
	private String element;
	private String monsterType;
	private Game game;
	private static MonsterAbility ability;

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

	public String getName(){
		name = " ";
		int r0 = (int)(Math.random()*abilities.length);
		int r1 = (int)(Math.random()*name1.length);
		int r2 = (int)(Math.random()*name2.length);
		int r3 = (int)(Math.random()*name3.length);
		for(int i=0;i<4;i++){
			if(i==0)name += name1[r1] + " ";
			else if(i==1){
				name += abilities[r0]+ " ";
				element = abilities[r0];
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
			g.setColor(Color.black);
			g.drawString(name, 0, 20);
		}
	}


}
