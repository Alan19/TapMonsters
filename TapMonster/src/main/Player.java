package main;
import java.awt.Graphics2D;

import guiPractice.components.Graphic;
import guiPractice.components.MovingComponent;
import interfaces.Attack;
import interfaces.PlayerInterface;

public class Player extends MovingComponent  {

	private static final int playerX = 50;
	private static final int playerY = 50;

	static final Graphic playerDefault = new Graphic(playerX, playerY, 1, "ColorScheme/PlayerPics/default transparent.png");
	static final Graphic playerAttack = new Graphic(playerX, playerY, 1, "ColorScheme/PlayerPics/attack transparent.png");
	static final Graphic playerDodgeLeft= new Graphic(playerX-5, playerY, 1, "ColorScheme/PlayerPics/dodge left transparent.png");
	static final Graphic playerDodgeRight= new Graphic(playerX+5, playerY, 1, "ColorScheme/PlayerPics/dodge right transparent.png");
	static final Graphic playerGuard= new Graphic(playerX, playerY, 1, "ColorScheme/PlayerPics/guard transparent.png");
	static final Graphic[] moveSet ={playerDefault,playerAttack,playerDodgeRight,playerGuard,playerDodgeLeft};
	
	private int currentState=Attack.DEFAULT;

	//private moveSet[5] = {playerDefault,playerAttack,playerDodgeLeft,playerDodgeRight,playerGuard};
	public Player() {
		super(playerX,playerY,playerDefault.getWidth(),playerDefault.getHeight());

		// TODO Auto-generated constructor stub
	}

public void setMove(int move){
	Graphic newState = moveSet[move];
	currentState= move;
	setWidth(newState.getWidth());
	setHeight(newState.getHeight());
	clear();
	update();
}

	public void drawImage(Graphics2D g){
		g.drawImage(moveSet[currentState].getImage(),0,0,null);
	}

	@Override
	public void checkBehaviors() {
		// TODO Auto-generated method stub
		
	}

}


