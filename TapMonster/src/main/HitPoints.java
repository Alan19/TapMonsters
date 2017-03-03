package main;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPractice.components.Component;

public class HitPoints extends Component{

	public static int score;
	public static int achieved;
	public static int threshold;
	
	public boolean newLevel = false;
	private int seqLength = 0;
	private int playerMaxSeq;
	
	public static int playerHp = 50;
	public static int maxHp = 50;
	
	public HitPoints(int x, int y) {
		super(x, y, 100, 100);
		score = 0;
		
	}

	public void checkHp(int Hp){
		if (playerHp <= maxHp){
			playerHp = 0;
		}
	}
	public void hpDecrease(int number){
		playerHp = playerHp - number;
		update();
	}
	
	public void changeMax(int x){
		maxHp += x;
	}
	
	public int getMax(){
		return maxHp;
	}
	
	public int getHP(){
		return playerHp;
	}

	@Override
	public void update(Graphics2D g) {
		//hp
		int hpBarHeight = 20;
		g.setColor(Color.white);
		g.fillRect(0, getHeight()/2+10, getWidth()-1, hpBarHeight - 1);
		g.setColor(Color.red);
		if (playerHp > 0) g.fillRect(0, getHeight()/2+10, getWidth() * playerHp/maxHp, hpBarHeight);
		else g.fillRect(0, getHeight()/2+10, 0, hpBarHeight);
		g.setColor(Color.black);
		g.drawRect(0, getHeight()/2+10, getWidth()-1, hpBarHeight - 1);
		g.drawString("Hp = " + playerHp + "/" + maxHp + "", 5, getHeight()/2+25);
	}
}
