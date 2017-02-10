package guiPractice;

import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class GUIApplication extends JFrame implements Runnable{

	private Screen currentScreen;

	
	
	
	
	public GUIApplication(int width2, int height2) {
		//terminate program when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
		int x = 40;
		int y = 40;
		int width = 600;
		int height = 400;
		setBounds(x,y,width,height);
		initScreen();
		setVisible(true);
	}



/**
 * method for creating and setting the starting screen
 */
	protected abstract void initScreen();

	
	public void setScreen(Screen screen){
		//stop controls from last Screen
		if(currentScreen != null){
			if(currentScreen.getMouseListener() != null){
				removeMouseListener(
						currentScreen.getMouseListener());
			}
			if(currentScreen.getMouseMotionListener() != null){
				removeMouseMotionListener(
						currentScreen.getMouseMotionListener());
			}
		}
		currentScreen = screen;
		//add controls for new screen
		if(currentScreen != null){
			addMouseListener(currentScreen.
					getMouseListener());
			addMouseMotionListener(currentScreen.
					getMouseMotionListener());
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}

	
	
	
	
	
	public void run(){
		while(true){
			currentScreen.update();
			//updates the Window
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}