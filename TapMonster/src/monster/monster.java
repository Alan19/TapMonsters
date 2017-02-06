package monster;

import java.util.ArrayList;

public class monster implements monsterAbilities{

	private static String[] abilities = {"Godly","Frost","Flame","Poison","Normal"};
	private static String[] name1 = {"Terrifying","Big","Tiny","Dangerous","Angry","Cruel","Awesome","Friendly","Deathly","Lonely"};
	private static String[] name2 = {"Calm","Hasty","Lazy","Casual","Caring","Emotional","Brave","Honest","Fluffy","Safe"};
	private static String[] name3 = {"Beast","Humanoid","Demon","Titan","Monster","Thingy"};
	private static String name = "";
	private static ArrayList<String> names;
	private static boolean isUsed = false;

	public monster() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getName() {
		//private method to search for if the name was already used
		int r0 = (int)(Math.random()*abilities.length);
		int r1 = (int)(Math.random()*name1.length);
		int r2 = (int)(Math.random()*name2.length);
		int r3 = (int)(Math.random()*name3.length);
		for(int i=0;i<4;i++){
			if(i==0)name += name1[r1] + " ";
			else if(i==1)name += abilities[r0]+ " ";
			else if(i==2)name += name2[r2]+ " ";
			else name += name3[r3];
		}
		return name;
	}
	
	private static boolean wasNameUsed(String name){
		if(names.size()<1)return true;
		for(int i = 0;i<names.size();i++){
			if(names.get(i)==name){
				isUsed = true;
			}else isUsed = false;
		}
		if(isUsed = true)return false;
		else return true;
	}

	@Override
	public void setEffect() {
		//each name we see we will 
		
	}

	public static void main(String[] args) {
		names = new ArrayList<String>();
		String temp = getName();
		wasNameUsed(temp);
		Print(temp);
		names.add(temp);
	}

	public static void Print(String s){
		String printString = "";
		int cutoff = 45;
		while(s.length() > 0){
			String currentCut = "";
			String nextWord = "";
			while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){
				currentCut += nextWord;
				s = s.substring(nextWord.length());

				int endOfWord = s.indexOf(" ");

				if(endOfWord == -1) {
					endOfWord = s.length()-1;
				}
				nextWord = s.substring(0,endOfWord+1);
			}
			printString +=currentCut+"\n";
		}
		System.out.print(printString);
	}





}
