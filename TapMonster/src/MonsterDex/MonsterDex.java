package MonsterDex;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import interfaces.MonDexInterface;

public class MonsterDex extends ClickableScreen implements Runnable{
	
	private static ArrayList<MonDexInterface> Monsters;
	private Button Next;
	private Button Back;
	private Graphic Background;
	private static Graphic MonsterImg;
	private static TextArea Description;
	private TextLabel Name;
	
	private static int PosX = 100;
	private static int PosY = 100;
	private int MonID = 1;
	
	public MonsterDex(int width,int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}
	
	
	public void initObjects(final ArrayList<Visible> viewObjects){
		Next = new Button(getWidth() - 110, getHeight() - 70, 90, 50, "Next", Color.decode("#a52a2a"), null);
		Back = new Button(20, getHeight() - 70, 90, 50, "Back", Color.decode("#a52a2a"), new Action() {
			public void act() {
				MonID++;
			}
		});
		
		Background = new Graphic(0,0,getWidth(),getHeight(),"src/resources/background.jpg");
		MonsterImg = new Graphic(0,0,100,100,"MonsterSprites/Beast/1.gif");
		viewObjects.add(Background);
		viewObjects.add(Next);
		viewObjects.add(Back);	
		viewObjects.add(MonsterImg);

	}

	private Graphic getMonster() {
		MonID++;
		return new MonsterGraphic(PosX, PosY, 100, 100, MonID);
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	

}