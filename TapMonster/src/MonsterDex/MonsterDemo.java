import java.awt.Color;
import java.util.ArrayList;

import guiPractice.GUIApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class MonsterDemo extends GUIApplication {

	public static MonsterDex Dex;

	public MonsterDemo() {
		super();;
	}

	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(getWidth(),getHeight());
		setScreen(demo);
	}
	
	public static void main(String[] args){
		MonsterDemo demo = new MonsterDemo();
		Thread app = new Thread(demo);
		app.start();
	}
	
	private class DemoScreen extends ClickableScreen{

		private Button back;
		
		public DemoScreen(int width, int height) {
			super(width, height);
		}

		@Override
		public void initAllObjects(ArrayList<Visible> arg0) {
			back = new Button(40,100,90,40,"back",Color.red,new Action() {
					
					@Override
					public void act() {
						//MonsterDemo.Pikmin.
					}
				});
			arg0.add(back);
		}
		
	}

}
