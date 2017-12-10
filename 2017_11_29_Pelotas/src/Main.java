import java.awt.Canvas;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
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

// Pixel X 37795.275590551
// pixel Y 3779.527559055


public class Main extends JFrame implements Runnable {
	
	private boolean running = true;
	private Thread thread;
	private String tittle = "Pelotas";
	private int width = 1000;
	private int height = 700;
	
	Main(){
		
		setTitle(tittle);
		pack(); // default size
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		start();
		add(new Ventana(width,height));
		
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
	    long timer = System.currentTimeMillis();
	    double fps = 30.0;
	    final double ns = 1000000000.0 / fps ;
	    double delta = 0;
	    int frames = 0;
	    int updates = 0;
	    while (running) {
	    	long now = System.nanoTime();
	    	delta += (now - lastTime) / ns;
	    	lastTime = now;
	    	while (delta >=1) {
	    		update();
	    		updates++;
	    		delta--;
	    	}
	    	render();
	    	frames++;
	    	
	    	if(System.currentTimeMillis() - timer > 1000) {
	    		timer += 1000;
	    		setTitle(tittle + " | " + updates + " ups, "+ frames + " fps ");
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
		if(bs==null) {
			createBufferStrategy(3);
			return;
		}
	}
		
	
}


