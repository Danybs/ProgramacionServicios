import java.awt.*;
import javax.swing.*;

public class bolita extends JFrame {
	// Construyendo la pelota
	bolita() {
		super("las pelotas");
		// tamano de la pantalla
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rect = getBounds();
		pantalla p = new pantalla((int) rect.width, (int) rect.height);
		getContentPane().add(p);
		pack();
		setVisible(true);
		p.start();
	}

	// Elaborando el metodo inicial MAIN
	public static void main(String args[]) {
		new bolita();
	}

	// declaracion de las Variables locales
	private Rectangle rect;
	
	
}

class pantalla extends Canvas implements Runnable {
	// Construyendo la pantalla
	pantalla(int x, int y) {
		setSize(x, y);
		setBackground(Color.yellow);
		rect = getBounds();
	}

	// parametros de la bolita
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x, y, 18,18);
	}

	public void run() {
		try {
			while (running) {
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
					if (x == (rect.width - 12))
						dir = 1;
					if (y == 0)
						dir = 3;
				}
				if (dir == 3) {
					x++;
					y++;
					if (x == (rect.width - 12))
						dir = 4;
					if (y == (rect.height - 12))
						dir = 2;
				}
				if (dir == 4) {
					x--;
					y++;
					if (x == 0)
						dir = 3;
					if (y == (rect.height - 12))
						dir = 1;
				}
				// imprime las cordenadas
				System.out.println(" -> " + x + " " + y + " " + dir);
				repaint();
				// velocidad en la que se mueve la bolita
				t.sleep(4);
			}
		} catch (InterruptedException e) {
			running = false;
		}
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

	// refresca la pantalla
	public void update(Graphics g) {
		rect = getBounds();
		Image image = createImage(rect.width, rect.height);
		Graphics gi = image.getGraphics();
		gi.clearRect(0, 0, rect.width, rect.height);
		paint(gi);
		g.drawImage(image, 0, 0, null);
	}

	private int getPointsX() {
		int num;
		do {
			num = (int) Math.round(Math.random() * 10000);
		} while (num >= rect.width - 12);
		return num;
	}

	private int getPointsY() {
		int num;
		do {
			num = (int) Math.round(Math.random() * 10000);
		} while (num >= rect.height - 12);
		return num;
	}

	private int dir() {
		int num;
		do {
			num = (int) Math.round(Math.random() * 10);
		} while ((num > 4) || (num == 0));
		return num;
	}

	private Rectangle rect;
	private int x;
	private int y;
	private int dir;
	private Thread t;
	private boolean running;
}