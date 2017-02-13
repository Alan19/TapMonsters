package main;
import java.awt.Image;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.TextArea;
import guiPractice.components.Visible;

public class MonsterDex extends ClickableScreen{
	

	private int MonNum = 1;
	private int xLoc = 50;
	private int yLoc = 50;
	
	private Graphic Pikmin;
	private TextArea description;
	private Button Next;
	private Button Back;
	
	public MonsterDex(int width, int height) {
		super(width,height);	
	}

	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	


	

	

}
