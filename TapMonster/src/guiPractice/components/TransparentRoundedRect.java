package guiPractice.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TransparentRoundedRect extends Component {
	
	//private Color color;
	private int arcWidth;
	private int arcHeight;

	public TransparentRoundedRect(int x, int y, int width, int height, int arcW, int arcH) {
		super(x, y, width, height);
		this.arcWidth = arcW;
		this.arcHeight = arcH;
		update();
		//this.color = c;
	}

	@Override
	public void update(Graphics2D g) {
		g=clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(0.65f, 0.65f, 0.65f, 0.65f));
		g.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(5));
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcWidth, arcHeight);
	}

}
