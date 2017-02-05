import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Clickable;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import java.awt.Color;
public class IntroScreen extends ClickableScreen implements Visible, Clickable, Runnable {

	private TextLabel label;
	private Button startButton;
	

	public IntroScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
	app.start();
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
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		label = new TextLabel(getWidth()/2-60, getHeight()/2-30, 120, 60, "Instructions will be here");
		viewObjects.add(label);
		startButton = new Button(getWidth()/2,(int) (.75*getHeight()),38,20,"START",Color.RED,startGame());
	}

	private Action startGame() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
