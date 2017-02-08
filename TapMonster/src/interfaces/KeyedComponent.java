package interfaces;

import java.awt.event.KeyListener;

import guiPractice.components.Visible;

public interface KeyedComponent extends KeyListener, Visible{

	public boolean isHovered(int x, int y);

	public void setFocus(boolean b);

}