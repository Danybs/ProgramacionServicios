package Tennis;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener{
	final int WIDTH = 700, HEIGHT = 500;
	int count=0;
	Thread thread;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	boolean gameStarted;
	Graphics gfx;
	Image img;
	
	@Override
	public void init() {
		this.resize(WIDTH, HEIGHT);
		gameStarted = false;
		this.addKeyListener(this);
		p1 = new HumanPaddle(1);
		b1 = new Ball();
		p2 = new AIPaddle(2, b1);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void paint(Graphics g) {
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(b1.getX() < -10 || b1.getX() > 710) {
			gfx.setColor(Color.red);
			gfx.drawString("Game Over", 350, 250);
			gfx.drawString("Botes: " + b1.count, 600, 300);
		}
		else {
		p1.draw(gfx);
		b1.draw(gfx);
		p2.draw(gfx);
		}
		if(!gameStarted) {
			gfx.setColor(Color.white);
			gfx.drawString("Tennis", 340, 100);
			gfx.drawString("Press Enter to Begin..", 310, 130);
		}
		g.drawImage(img, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {
		for(;;) {
			if(gameStarted) {
			p1.move();
			p2.move();
			b1.move();
			b1.checkPaddleCollision(p1, p2);
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			gameStarted = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
