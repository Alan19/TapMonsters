import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import guiPractice.GUIApplication;
import guiPractice.Screen;
import guiPractice.components.Graphic;
import interfaces.PlayerInterface;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
public class Player extends GUIApplication implements PlayerInterface{

private static final int playerX = 50;
private static final int playerY = 50;
private static Screen main;

Graphic playerDefault = new Graphic(playerX, playerY, 1, "ColorScheme/PlayerPics/default transparent.png");
Graphic playerAttack = new Graphic(playerX, playerY, 1, "ColorScheme/PlayerPics/attack transparent.png");
Graphic playerDodgeLeft= new Graphic(playerX-5, playerY, 1, "ColorScheme/PlayerPics/dodge left transparent.png");
Graphic playerDodgeRight= new Graphic(playerX+5, playerY, 1, "ColorScheme/PlayerPics/dodge right transparent.png");
Graphic playerGuard= new Graphic(playerX, playerY, 1, "ColorScheme/PlayerPics/guard transparent.png");
Graphic[] moveSet = new Graphic[5];

//private moveSet[5] = {playerDefault,playerAttack,playerDodgeLeft,playerDodgeRight,playerGuard};
public Player(int move) {
	
		
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getKey(int key) {
		return key;
	}


}


