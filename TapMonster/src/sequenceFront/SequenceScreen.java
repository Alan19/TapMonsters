package sequenceFront;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Visible;
import main.Sequence;

public class SequenceScreen extends Screen implements KeyListener{

	public static ArrayList<Sequence> monsterSequence;
	
	public SequenceScreen(int width, int height) {
		super(width, height);
		monsterSequence = new ArrayList<Sequence>();
		fillArrayList(monsterSequence);
	}

	public void fillArrayList(ArrayList<Sequence> arr){
		
	}
	
	public void initObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
