import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.List;

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

//1 metro = 3.779,57517575 pixel
//100 metros = 3779/300=1260
//70 metros = 

public class showGUI extends JFrame implements Runnable {
	private boolean running = true;
	private Thread thread;
	private String tittle = "Pelotas";
	private BallContainer gfx;
	private Ball ball, ball1;
	private ThreadClass h1, h2;
	private Dimension screenSize;
	int width, height;

	showGUI() {
		setTitle(tittle);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (screenSize.width / 2);
		height = (screenSize.height / 2);
		setSize(width, height);
		start(); // fps
		ball = new Ball(width, height);
		ball.setInitialPosition();
		ball1 = new Ball(width, height);
		ball1.setInitialPosition();
		gfx = new BallContainer(width, height, ball, ball1);
		add(gfx);
		h1 = new ThreadClass(gfx, ball);
		h2 = new ThreadClass(gfx, ball1);
	}

	public static void main(String[] args) {
		showGUI GUI = new showGUI();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double fps = 30.0;
		final double ns = 1000000000.0 / fps;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				setTitle(tittle + " | " + updates + " ups, " + frames + " fps ");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void update() {

	}

	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
	}

}
