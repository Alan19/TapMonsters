import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;
import interfaces.MonDexInterface;

public class MonsterDex extends ClickableScreen implements Runnable{
	
	private static ArrayList<Monster> Monsters;
	private Button Next;
	private Button Back;
	
	private static int PosX = 100;
	private static int PosY = 100;
	private int MonID = 1;
	
	public MonsterDex(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		
	}
	
	
	public void initObjects(Visible viewObjects){
		Monsters = new ArrayList<Monster>();
		for(int i = MonID; i < (MonID + 6); i++){
			//Monsters.setDescription(still unsure how to go about this/maybe scrap?
			//Monster.setNumEncountered(1+variable)
			
			MonID++;
		}
	}


	@Override
	public void SetDescription(String des) {
		
		
	}


	@Override
	public int setNumEncountered(int encounters) {
		return 1;
	}


	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}



	

}