import java.awt.Canvas;
import java.awt.Color;
<<<<<<< HEAD
=======
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
>>>>>>> 28b63551a817384e95af6118d8a174e5d2bb54fb
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
Zona rectangular 100x70 metros
Un par de hilos que muevan un par de pelotas con una direccion inicial aleatoria mas o mens entre el centro
Veloicdad tiene que variar entre 1 y 30m/s, velocidad aleatoria inicial

Radio pelotas 9 metros

Las pelotas no revotan entre si, si con las paredes

Tercer hilo genera la escena a un maximo de 30 frames por segundo

g.scale
rebote entre bolas


*/

// Pixel X 37795.275590551
// pixel Y 3779.527559055
<<<<<<< HEAD


public class Main extends JFrame {
	private int width = 1000;
	private int height = 800;
	private JPanel p1;

	Main() {
		setTitle("Pelotas");

		pack(); // default size
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		p1 = new JPanel();
		add(p1);
		p1.setSize(WIDTH, HEIGHT);
		p1.setBackground(Color.YELLOW);
		pelota p = new pelota();
		p.start();
		pelota p1 = new pelota();
		p1.start();
	}

	// Elaborando el metodo inicial MAIN
	public static void main(String args[]) {
		new Main();
=======
public class Main {
		public static void main(String args[]) {
			new ventana();
		}
}

class ventana extends JPanel implements Runnable{
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public synchronized void () {
>>>>>>> 28b63551a817384e95af6118d8a174e5d2bb54fb
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		
	}
	

}

class pelota implements Runnable {	
	private int width = 1000;
	private int height = 800;
	private int x;
	private int y;
	private int dir;
	private Thread t;
	private boolean running;

	@Override
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
				// imprime las cordenadas
				System.out.println(Thread.currentThread().getId()+" -> " + x + " " + y + " " + dir);
//				repaint();
				// velocidad en la que se mueve la bolita
				t.sleep(4);
			}
		} catch (InterruptedException e) {
			running = false;
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

<<<<<<< HEAD
=======
class pelota {
	public void move() {
		
	}
	
}

class Hiloescena {
	
}


//private int width = 100;
//private int height = 70;
//ventana() {
//	setTitle("Pelotas");		
//	pack(); // default size
//	setResizable(false);
//	setBackground(Color.yellow);
//	setVisible(true);
//	setLocationRelativeTo(null);
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	setSize(width, height);
//}
>>>>>>> 28b63551a817384e95af6118d8a174e5d2bb54fb
