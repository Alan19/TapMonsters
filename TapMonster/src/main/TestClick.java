package main;

import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class TestClick extends ClickableScreen{

	public TestClick(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		ClickableGraphic artifact = new ClickableGraphic(50, 50, 100, 100, "src/storeImages/arti1.png");
		artifact.setAction(new Action(){
			public void act() {
				System.out.println("yeet my g");
			}
		});

		viewObjects.add(artifact);
	}

}
