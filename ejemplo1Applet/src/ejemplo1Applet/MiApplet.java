package ejemplo1Applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MiApplet extends Applet implements Runnable, KeyListener {

	private Thread t = null;
	private float x;
	private float y;
	private float vx;
	private int radio;
	private BufferedImage buffer;
	private Graphics g1, g2;
	private boolean running = true;

	@Override
	public void init() {
		super.init();
		this.addKeyListener(this);
		x = getWidth() / 2;
		y = getHeight() / 2;
		vx = 30;
		radio = 30;
		buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		g1 = buffer.getGraphics();
		g2 = getGraphics();
		
	}

	@Override
	public void start() {
		running = true;
//		if (t == null) {
			t = new Thread(this);
//		}
		t.start();
	}

	@Override
	public void stop() {
//		super.stop();
		running = false;
//		while (true) {
//			try {
//				t.join();
//				break;
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		t = null;
	}

	public void paint() {
		this.g1.clearRect(0, 0, getWidth(), getHeight());
		this.g1.fillOval((int) x - radio, (int) y - radio, radio * 2, radio * 2);
		g2.drawImage(buffer, 0, 0, null);
	}

	@Override
	public void run() {
		long t0 = System.nanoTime(), t1, lapso;
		while (running) {
			lapso = (t1 = System.nanoTime()) - t0;
			t0 = t1;
			x += lapso * vx / 1000000000L;
			// x += 10 * vx;
			if (x >= getWidth() - radio) {
				x = getWidth() - radio;
				vx *= -1;
			} else if (x <= radio) {
				x = radio;
				vx *= -1;
			}
			paint();
		}
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			stop();
			
			//t.suspend();
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			start();
			//t.resume();
			
		} 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
