package ejemplo1Applet;
//pon
import java.applet.Applet;
import java.awt.Graphics;

public class MiApplet extends Applet implements Runnable{
	
	private Thread t = null;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		t = new Thread(this);
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while() {
			// varias los parametros de la animacion
			repaint();
			Thread.sleep(100);
		}
	}
}
