package MonsterDex;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import interfaces.MonDexInterface;

public class MonsterDex extends ClickableScreen implements Runnable{
	
	private static ArrayList<MonDexInterface> Monsters;
	private Button Next;
	private Button Back;
	//temporary cause i don't want to get bogged down with unnecessary stuff
	private Graphic MonsterImg;
	
	private static int PosX = 100;
	private static int PosY = 100;
	private int MonID = 1;
	
	public MonsterDex(int width,int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}
	
	
	public void initObjects(ArrayList<Visible> viewObjects){
		Monsters = new ArrayList<MonDexInterface>();
		Next = new Button(getWidth() - 110, getHeight() - 70, 90, 50, "Next", Color.decode("#a52a2a"), null);
		Back = new Button(20, getHeight() - 70, 90, 50, "Back", Color.decode("#a52a2a"), null);
		MonsterImg = new Graphic(PosX,PosY, 100,100,"src/MonsterSprites/1.gif");
		viewObjects.add(MonsterImg);
		viewObjects.add(Next);
		viewObjects.add(Back);	
//		for(int i = MonID; i < MonID+2; i++){
//			MonsterImg = new Graphic(PosX,PosY, 100,100,"src/MonsterSprites/"+MonID+".gif");
//			PosX += 200;
//			MonID++;
//			viewObjects.add(MonsterImg);
//		}
	}


	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	

}