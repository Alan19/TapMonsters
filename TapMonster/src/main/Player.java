package main;
import java.awt.Graphics2D;

import guiPractice.components.Component;
import guiPractice.components.Graphic;
import guiPractice.components.MovingComponent;
import interfaces.Attack;
import interfaces.KeysToPlayer;
import interfaces.PlayerInterface;

public class Player extends Component  {

	private static final int playerX = 50;
	private static final int playerY = 50;

	static final Graphic playerDefault = new Graphic(playerX, playerY, 1, "src/resources/default transparent.png");
	static final Graphic playerAttack = new Graphic(playerX, playerY, 1, "src/resources/attack transparent.png");
	static final Graphic playerDodgeLeft= new Graphic(playerX-5, playerY, 1, "src/resources/dodge left transparent.png");
	static final Graphic playerDodgeRight= new Graphic(playerX+5, playerY, 1, "src/resources/dodge right transparent.png");
	static final Graphic playerGuard= new Graphic(playerX, playerY, 1, "src/resources/guard transparent.png");
	static final Graphic[] moveSet ={playerDefault,playerAttack,playerDodgeRight,playerGuard,playerDodgeLeft};
	
	private int currentState=Attack.DEFAULT;

	//private moveSet[5] = {playerDefault,playerAttack,playerDodgeLeft,playerDodgeRight,playerGuard};
	public Player(int x, int y) {
		super(x,y,playerDefault.getWidth(),playerDefault.getHeight());

		// TODO Auto-generated constructor stub
	}

public void setMove(int move){
	//System.out.println("PLAYER IS WEIRD");
	Graphic newState = moveSet[move];
	currentState= move;
	setWidth(newState.getWidth());
	setHeight(newState.getHeight());
	clear();
	update();
}





	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(moveSet[currentState].getImage(),0,0,null);
		
	}

}


