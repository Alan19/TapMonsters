package main;

import java.awt.Graphics2D;
import java.awt.TextArea;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextArea;
import guiPractice.components.Visible;

public class InventoryScreen extends ClickableScreen implements Runnable{
	
	private TextArea title;
	private ArrayList<Artifact> artifacts;
	private Graphics2D g;

	public InventoryScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	//@Override
	//public void initObjects(ArrayList<Visible> arg0) {
		

	//}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		title = new TextArea(40,85,700,25, "Inventory");
		viewObjects.add(title);
	}

	@Override
	public void run() {
		g.drawRect();
		
	}

}
