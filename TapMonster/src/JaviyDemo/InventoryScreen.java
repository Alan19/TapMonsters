package JaviyDemo;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import guiPractice.components.TextArea;
import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickGraphicsScreen;

public class InventoryScreen extends ClickGraphicsScreen implements Runnable{
	
	private TextArea title;
	private ArrayList<Artifact> artifacts;
	private Graphics2D g;

	public InventoryScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		g.drawRect(100, 100, 100, 100);
		
	}

	public void initAllObjects(List<Visible> viewObjects) {
		title = new TextArea(40,85,700,25, "Inventory");
		viewObjects.add(title);
	}

}
