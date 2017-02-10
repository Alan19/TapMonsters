package main;

import java.util.ArrayList;
import java.util.List;

import guiPractice.Simon.ProgressInterfaceSimon;
import guiPractice.Simon.ProgressJaviy;
import guiPractice.TapMonsters.monster.Game;
import guiPractice.TapMonsters.Monster.Monster;
import guiPractice.TapMonsters.Monster.MonsterName;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class TapMonstersScreen extends ClickableScreen implements Runnable,Game{

	private TextLabel label;
	private TextLabel monsterName;
	private MonsterName monster;
	
	//private String munster;
	
	public TapMonstersScreen(int width,int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("TAP MONSTERS");
		
	}
	
	private void changeText(String string) {
		try {
			label.setText(string);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	private Monster getName() {
		return new Monster(this);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		label = new TextLabel(200,50,300,40,"TAP MONSTERS");
		addAMonster();
		viewObjects.add(label);
		
	}
	
	public void addAMonster(){
		monster = getName();
		Monster.usablity();
		Monster.description();
		addObject(monster);
	}

	@Override
	public void decreaseLife() {
		// TODO Auto-generated method stub
		System.out.println("Decrease life");
		System.out.println(Monster.description());
	}

	@Override
	public void addBossSequence() {
		// TODO Auto-generated method stub
		//Max needs to add the boss sequence here
		System.out.println("Add boss sequence");
		System.out.println(Monster.description());
	}

	@Override
	public void speedTimer() {
		// TODO Auto-generated method stub
		System.out.println("Speed timer");
		System.out.println(Monster.description());
		
	}

	@Override
	public void freezeTimer() {
		// TODO Auto-generated method stub
		System.out.println("Freeze timer");
		System.out.println(Monster.description());
		
	}

	@Override
	public void nothing() {
		// TODO Auto-generated method stub
		System.out.println("No special effects");
		System.out.println(Monster.description());
	}

	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
		
	}

}
