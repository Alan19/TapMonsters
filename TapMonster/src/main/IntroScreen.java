package main;

import java.util.ArrayList;
import java.util.List;

import guiPractice.ClickableScreen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Clickable;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import artifacts.Artifact;
import interfaces.Attack;
import interfaces.PlayerInterface;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class IntroScreen extends ClickableScreen implements Attack, PlayerInterface {
	public Artifact Art;

	public IntroScreen(int width, int height) {
		super(width, height);
		MonsterDexScreen.filePaths.add(MonsterGraphic.getMonster("Titan"));

	}

	// public static ArrayList<String> art;
	private int difficulty;
	private String instructions;
	private TextArea text;
	private Button startButton;
	private Button diffButton;
	private TextLabel diffLabel;

	// for demo{
	// private Player player;
	// private int zz = 1;
	// }

	//
	// public ArrayList<String> spliceString(String s) {
	// int last = 0;
	// ArrayList<String> out = new ArrayList<String>();
	// for (int i = 0; i < s.length(); i++) {
	// if (s.charAt(i) == 32) {
	// out.add(s.substring(last, i));
	// last = i+1;
	// }
	// }
	// return out;
	// }
	//
	// public void introFormatter(String[] intro){
	// int length = 10;
	// int spacing = 5;
	// int totalSpace = 0;
	//
	// for(int i =0;i<intro.length;i++){
	// ArrayList<String> paragraph = spliceString(intro[i]);
	// ArrayList<String> line=new ArrayList<String>();
	// for(int k = 1; k<=paragraph.size();k++){
	// if(k==paragraph.size()){
	// label = new TextLabel(getWidth()/2-60+total, getHeight()/2-30, 120, 60,
	// "Instructions will be here");
	// viewObjects.add(label);
	// }
	// else if ((k%length)>0){
	//
	//
	// line.add(paragraph.get(k-1));
	//
	// }
	// }
	// }
	// }

	@Override
	public void initAllObjects(final List<Visible> viewObjects) {
		difficulty = 0;
		final String[] diffArray = { "normal", "hard", "extreme" };
		Graphic picture = new Graphic(0, 0, getWidth(), getHeight(), "src/resources/background.jpg");
		instructions = "You are on a journey to fight monsters and get to the highest stage possible. "
				+ "You kill a monster from completing an arrow key sequence in a certain amount of time, bosses also use (A,S,W,D) for their sequence. "
				+ "Certain monsters have abilities that can make things harder on you depending on their abilities. "
				+ "Don’t fret because you have a currency called relics, you gather these relics to buy artifacts for permanent bonuses. "
				+ "There are also things called rewards, these rewards appear randomly and grant different effects. Of course better rewards are harder to come by. "
				+ "You start the game with three hearts, when you don’t complete a sequence in time you will lose a heart, when you run out of hearts it’s ”GAME OVER,” and a death screen with your score and artifacts will show up. "
				+ "There are buttons on the left for you to click after you aren’t in battle such as store, inventory, next level, and prestige. "
				+ "Prestige is something that you can press to reset your stage to the beginning, but you save all of your artifacts and hearts and use those to get further into the game. "
				+ "So if you defeat the monster in the set amount of time given, then the entire main screen freezes, until you are ready to move on to the next stage.";
		// text.setTextColor(Color.WHITE);
		text = new TextArea(30, 30, getWidth() - 60, getHeight() - 60, instructions);
		diffLabel = new TextLabel(getWidth() / 3, getHeight() - 40, 100, 30, "Helvetica", 20, Color.WHITE,
				diffArray[(difficulty % 3)]);
		diffButton = new Button(getWidth() / 5, getHeight() - 40, 100, 30, "difficulty", Color.RED, new Action() {

			public void act() {
				difficulty++;
				diffLabel.setText(diffArray[(difficulty % 3)]);
			}
		});
		startButton = new Button(getWidth() / 2, getHeight() - 40, 100, 30, "START", Color.RED, new Action() {

			public void act() {
				int i = difficulty;

				while (i > 0) {	
					int tempInt = (int) ((TapMonsterGame.artifacts.size()) * Math.random());
					System.out.println(TapMonsterGame.artifacts.get(tempInt).getName());
					TapMonsterGame.artifacts.remove(tempInt);
					TapMonsterGame.artifactPictures.remove(tempInt);
					remove(TapMonsterGame.artifactPictures.get(tempInt));
					i--;
				}
				// viewObjects.remove(viewObjects.size()-1);
				TapMonsterGame.game.setScreen(TapMonsterGame.main);
				// for demo{
				// player.setMove(zz%5);
				// zz++;
				// }

				// System.out.println("BUTTON IS WORKING");

			}

		});	
		// text.setText(instructions);
		viewObjects.add(picture);
		viewObjects.add(text);
		viewObjects.add(startButton);
		viewObjects.add(diffButton);
		viewObjects.add(diffLabel);
		// for demo{
		// viewObjects.add(player);
		// }
	}

	public int getKey(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setMove() {
		// TODO Auto-generated method stub
		System.out.println("PLAYER IS NOT WORKING");
	}

}
