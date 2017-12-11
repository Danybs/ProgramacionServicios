import java.awt.Color;
import java.awt.Graphics;

class Ball {
	private int width;
	private int height;
	private int x, y, dir, ball = 18;

	Ball(int width, int height) {
		this.width = width;
		this.height = height;
		setInitialPosition();
	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x, y, ball, ball);
	}

	public void move() {

		switch (dir) {
		case 1:
			x--;
			y--;
			if (x == 0)
				dir = 2;
			if (y == 0)
				dir = 4;
			break;
		case 2:
			x++;
			y--;
			if (x == (width - ball))
				dir = 1;
			if (y == 0)
				dir = 3;
			break;
		case 3:
			x++;
			y++;
			if (x == (width - ball))
				dir = 4;
			if (y == (height - ball))
				dir = 2;
			break;
		case 4:
			x--;
			y++;
			if (x == 0)
				dir = 3;
			if (y == (height - ball))
				dir = 1;
			break;
		}
	}

	private int getPointsX() {
		int num;
		num = (int) Math.round(Math.random() * width);
		return num;
	}

	private int getPointsY() {
		int num;
		num = (int) Math.round(Math.random() * height);
		return num;
	}

	private int dir() {
		int num;
		num = (int) Math.round(Math.random() * 4);
		return num;
	}

	public void setInitialPosition() {
		x = getPointsX();
		y = getPointsY();
		dir = dir();
	}
}