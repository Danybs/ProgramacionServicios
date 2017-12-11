
public class ThreadClass implements Runnable {

	Thread t;
	BallContainer gfx;
	Ball b;
	private boolean running = true;

	public ThreadClass(BallContainer gfx, Ball b) {
		this.b = b;
		this.gfx = gfx;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		try {
			while (running) {
				b.move();
				gfx.repaint();
				Thread.sleep(4);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			running = false;
		}
	}
}