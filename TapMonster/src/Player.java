import java.awt.Graphics2D;
import java.util.List;
import guiPractice.GUIApplication;
import interfaces.PlayerInterface;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
public class Player extends GUIApplication implements PlayerInterface{
public static final String userInput = new String();
public static final int playerX = 50;
public static final int playerY = 50;

	public Player(int x, int y, int scale, String userInput) {
		x = playerX;
		y = playerY;
		Graphics2D playerGraphic;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub

	}

}
