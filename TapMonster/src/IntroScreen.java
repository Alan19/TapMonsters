import java.util.ArrayList;
import java.util.List;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Clickable;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import java.awt.Color;
import java.awt.image.BufferedImage;
public class IntroScreen extends guiPractice.ClickableScreen implements Visible, Clickable, Runnable {
	private String[] instructions;
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

	private Action startGame() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
	public void update() {
		// TODO Auto-generated method stub
		
	}



	public void initAllObjects(List<Visible> viewObjects) {
		
		
		label = new TextLabel(getWidth()/2-60, getHeight()/2-30, 120, 60, "Instructions will be here");
		viewObjects.add(label);
		startButton = new Button(getWidth()/2,(int) (.75*getHeight()),38,20,"START",Color.RED,startGame());
	}
	
	
	public ArrayList<String> spliceString(String s) {
		int last = 0;
		ArrayList<String> out = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 32) {
				out.add(s.substring(last, i));
				last = i+1;
			}
		}
		return out;
	}




}
