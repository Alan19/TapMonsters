import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Button;
import guiPractice.components.Visible;
import interfaces.MonDexInterface;

public class MonsterDex extends ClickableScreen implements Runnable{
	
	private static ArrayList<MonDexInterface> Monsters;
	private Button Next;
	private Button Back;
	
	private static int PosX = 100;
	private static int PosY = 100;
	private int MonID = 1;
	
	public MonsterDex(int width,int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}
	
	
	public void initObjects(Visible viewObjects){
		Monsters = new ArrayList<MonDexInterface>();
		
	}


	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	

}