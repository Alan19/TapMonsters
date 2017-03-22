package guiPractice.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TextArea extends TextLabel {

	public TextArea(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
	}


	public void update(Graphics2D g){
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g = clear();
		g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
		FontMetrics fm = g.getFontMetrics();
		g.setColor(Color.WHITE);
		
		if(getText() != null){
		
			//split text into array of words
			String[] words = getText().split(" ");
			if(words.length >0){
				//index of word
				int i = 0;
				final int SPACING = 2;
				//y value represents y-coordinate of each line
				int y = 0 + fm.getHeight()+SPACING;
				String line = words[i] + " ";
				i++;
				//loop as long as there are words left
				while(i < words.length){
					//add to current line until horizontal space is outside of bounds
					while(i < words.length && fm.stringWidth(line) + fm.stringWidth(words[i]) < getWidth()){
						line += words[i]+" ";
						i++;
					}
					//keep adding lines while there is vertical space
					if(y < getHeight()){
						g.drawString(line, 2, y);
						y += fm.getDescent() + fm.getHeight()+SPACING;
						//rest line
						line = "";
					}else{
						//no more vertical space
						break;//print no more text
					}
				}
			}

		}
	}

}