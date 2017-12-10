import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class Ventana extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private Pelota ball, ball1;
	private boolean running = true;

	Ventana(int width, int height) {
		setSize(width, height);
		setBackground(Color.YELLOW);
		ball = new Pelota();
		ball.start();
		ball1 = new Pelota();
		ball1.start();
		start();
	}

	@Override
	public void run() {
		try {
			while (running) {
				repaint();
				System.out.println("repintando");
				thread.sleep(4);
			}
		} catch (Exception e) {
			running = false;
		}
	}

	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		// Graphics2D g2 = (Graphics2D) g;
		// g2.scale(5.0, 5.0);
		ball.draw(g);
		ball1.draw(g);
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

}