import java.awt.Color;
import java.awt.Graphics;

class Pelota implements Runnable {
	private int width = 1000;
	private int height = 700;
	private int x;
	private int y;
	private int dir;
	private Thread t;
	private boolean running;

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x, y, 18, 18);
	}

	@Override
	public void run() {
		try {
			while (running) {
				move();
				// imprime las cordenadas
				System.out.println(Thread.currentThread().getId() + " -> " + x + " " + y + " " + dir);
				
				// velocidad 
				t.sleep(4);
			}
		} catch (InterruptedException e) {
			running = false;
		}
	}
	public void move() {
		if (dir == 1) {
			x--;
			y--;
			if (x == 0)
				dir = 2;
			if (y == 0)
				dir = 4;
		}
		if (dir == 2) {
			x++;
			y--;
			if (x == (width - 12))
				dir = 1;
			if (y == 0)
				dir = 3;
		}
		if (dir == 3) {
			x++;
			y++;
			if (x == (width - 12))
				dir = 4;
			if (y == (height - 12))
				dir = 2;
		}
		if (dir == 4) {
			x--;
			y++;
			if (x == 0)
				dir = 3;
			if (y == (height - 12))
				dir = 1;
		}
	}
	private int getPointsX() {
		int num;
		do {
			num = (int) Math.round(Math.random() * 10000);
		} while (num >= width - 12);
		return num;
	}

	private int getPointsY() {
		int num;
		do {
			num = (int) Math.round(Math.random() * 10000);
		} while (num >= height - 12);
		return num;
	}

	private int dir() {
		int num;
		do {
			num = (int) Math.round(Math.random() * 10);
		} while ((num > 4) || (num == 0));
		return num;
	}

	public void start() {
		if (t == null) {
			x = getPointsX();
			y = getPointsY();
			dir = dir();
			running = true;
			t = new Thread(this);
			t.start();
		}
	}
}