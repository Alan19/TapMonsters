package guiPractice.components;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class MovingComponent extends Component implements Runnable {

	private double vx;
	private double vy;
	private double posx;
	private double posy;
	private boolean running;
	private long moveTime;// time when the image last moved
	public static final int REFRESH_RATE = 20;

	public MovingComponent(int x, int y, int w, int h) {
		super(x, y, w, h);
		vx = 0;
		vy = 0;
		running = false;

	}

	public boolean isAnimated() {
		return true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		posx = getX();
		posy = getY();
		//
		//
		moveTime = System.currentTimeMillis();
		while (running) {
			try {
				Thread.sleep(REFRESH_RATE);
				checkBehaviors();
				update();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public abstract void checkBehaviors();
	

	@Override
	public void update(Graphics2D g) {
		long currentTime = System.currentTimeMillis();
		long difference = currentTime - moveTime;// this calculates time since
													// last move
		if (difference >= REFRESH_RATE) {
			// an update is happening, so update moveTime
			moveTime = currentTime;

			posx += vx * ((double) difference / REFRESH_RATE);
			posy += vy * ((double) difference / REFRESH_RATE);
			// set only the location on the screen
			// NOT actual position
			super.setX((int)posx);
			super.setY((int)posy);
		}
		drawImage(g);
	}

	public abstract void drawImage(Graphics2D g);

	public void setX(int x) {
		super.setX(x);
		posx = x;

	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void setY(int y) {
		super.setY(y);
		posy = y;
	}

	public void play() {
		if (!running) {
			Thread go = new Thread(this);
			go.start();
		}
	}

}
