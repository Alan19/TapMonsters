package guiPractice.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HoverableClickable extends ClickableGraphic {

	private Action hoverAct;
	private Action exitAct;

	public HoverableClickable(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
	}

	public HoverableClickable(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
	}

	public HoverableClickable(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
	}
	
	public void setHoverAction(Action action){
		this.hoverAct = action;
	}
	
	public void setExitAction(Action action){
		this.exitAct = action;
	}
	
	public void hoverAct(){
		hoverAct.act();
	}

}
