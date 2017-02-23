package guiPractice.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TextLabel extends Component {

	//FIELDS
	private String text;
	private String font;
	private int size;
	private Color color = Color.WHITE;

	public TextLabel(int x, int y, int w, int h, String text) {
		super(x, y, w, h);
		this.text = text;
		font = "Helvetica";
		size = 20;
		update();
	}
	
	public TextLabel(int x, int y, int w, int h, String font, int size, Color color, String text){
		super(x, y, w, h);
		this.text = text;
		this.font = font;
		this.size = size;
		this.color = color;
		update();
	}

	public void setText(String s){
		this.text = s;
		update();
	}

	public void setSize(int size){
		this.size = size;
		update();
	}

	public void setFont(String font){
		this.font = font;
		update();
	}



	public String getText() {
		return this.text;
	}

	public String getFont() {
		return font;
	}

	public int getSize() {
		return size;
	}
	public void setTextColor(Color c){
	this.color = c;
	}
	@Override
	public void update(Graphics2D g) {
		g=clear();//clears image and gets new graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(color);
		if(this.text != null){
			g.setFont(new Font(font,Font.PLAIN,size));
			g.drawString(this.text, 4, getHeight()-5);
		}
	}













}
