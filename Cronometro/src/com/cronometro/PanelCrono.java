package com.cronometro;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelCrono extends JPanel implements Runnable {

	private Thread t = null;
	private boolean finalizado = true;
	private long inicio;
	private Crono crono = new Crono();
	
	public void iniciarCrono() {
		inicio = System.nanoTime();
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	public void pausarCrono() {
		
	}
	
	public void reanudarCrono() {
		
	}
	
	public void detenerCrono() {
		
	}
	public void paint(Graphics e) {
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.YELLOW);
		FontMetrics fm = g.getFontMetrics();
		String crono = this.crono.toString();
		int width = fm.stringWidth(crono);
		int x = (getWidth() - width) / 2;
		int y = (getHeight() / 2) + fm.getAscent();
		g.drawString(crono, x, y);
	}

	@Override
	public void run() {
		long fin;
		finalizado = false;
		while (!finalizado) {
			fin = System.nanoTime();
			crono.add(fin - inicio);
			inicio = fin;
			repaint();
		}
	}
}
