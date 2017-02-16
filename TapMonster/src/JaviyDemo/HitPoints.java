package JaviyDemo;

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
	
	public static int playerHp = 100;
	public static int maxHp = 100;
	
	public HitPoints(int x, int y) {
		super(x, y, 100, 200);
		score = 0;
		
	}

	public void checkHp(int Hp){
		if (playerHp <= maxHp){
			playerHp = 0;
		}
	}
	public void hpDecrease(int x){
		playerHp = playerHp - 10;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		//hp
			int expBarHeight = 20;
			g.setColor(Color.white);
			g.fillRect(0, getHeight()/2+10, getWidth()-1, expBarHeight - 1);
			g.setColor(new Color(102, 179, 255));
			if (playerHp > 0) g.fillRect(0, getHeight()/2+10, getWidth() * playerHp/maxHp, expBarHeight);
			else g.fillRect(0, getHeight()/2+10, 0, expBarHeight);
			g.setColor(Color.black);
			g.drawRect(0, getHeight()/2+10, getWidth()-1, expBarHeight - 1);
			g.drawString("Exp = " + playerHp + "/" + maxHp + "", 5, getHeight()/2+25);
	}
}
