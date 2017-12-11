import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class BallContainer extends JPanel {

	private Ball ball, ball1;
	private int width, height;

	BallContainer(int width, int height, Ball ball, Ball ball1) {
		this.ball = ball;
		this.ball1 = ball1;
		this.width = width;
		this.height = height;
		setSize(width, height);
		setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		// Graphics2D g2 = (Graphics2D) g;
		// g2.scale(5.0, 5.0);
		g.fillRect(0, 0, width, height);
		ball.draw(g);
		ball1.draw(g);
	}
}