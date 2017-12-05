import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

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
//public class VentanaPrincipal extends JFrame implements Runnable {
//	final int WIDTH = 700, HEIGHT = 500;
////	final private int width = 1000;
////	final private int height = 700;
//	Thread thread;
//	Pelota p1;
//	Graphics gfx;
//	Image img;
//
//	public VentanaPrincipal() {
//		setTitle("Graficas");
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		pack(); // default size
//		setResizable(false);
//		setVisible(true);
//		setLocationRelativeTo(null);
//		setSize(new Dimension(WIDTH, HEIGHT));
//		getContentPane().setLayout(new BorderLayout());
//	}
//
//	
//	public void lanzar() {
//		// TODO Auto-generated method stub
//		p1 = new Pelota();
//		thread = new Thread(this);
//		thread.start();
//	}
//	
//	@Override
//	public void paint(Graphics g) {
//		p1.draw(gfx);
//	}
//	
//	@Override
//	public void update(Graphics g) {
//		paint(g);
//	}
//	
//	@Override
//	public void run() {
//		for(;;) {
//			p1.move();
//		}
////		repaint();
//	}
//
//	public static void main(String[] args) {
//		VentanaPrincipal p = new VentanaPrincipal();
//		p.lanzar();
//		
//	}
//}
//
//class Pelota {
//	double xVel, yVel, x, y;
//	int count = 0;
//
//	public Pelota() {
//		x = 350;
//		y = 250;
//		xVel = getRandomSpeed() * getRandomDirection();
//		yVel = getRandomSpeed() * getRandomDirection();
//		
//	}
//
//	public double getRandomSpeed() {
//		return ((Math.random() * 30) + 2);
//	}
//
//	public int getRandomDirection() {
//		int rand = (int) (Math.random() * 2);
//		if (rand == 1)
//			return 1;
//		else
//			return -1;
//	}
//
//	public void draw(Graphics g) {
//		g.setColor(Color.white);
//		g.fillOval((int) x - 10, (int) y - 10, 20, 20);
//	}
//	public void move() {
//		x += xVel;
//		y += yVel;
//
//		if (y < 10)
//			yVel = -yVel;
//		if (y > 490)
//			yVel = -yVel;
//	}
//
//	public int getX() {
//		return (int) x;
//	}
//
//	public int getY() {
//		return (int) y;
//	}
//}
//
//interface Escena {
//	public void draw(Graphics g);
//	public void move();
//	public int getY();
//}

-
