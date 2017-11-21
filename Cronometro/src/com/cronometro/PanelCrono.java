package com.cronometro;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelCrono extends JPanel implements Runnable  {

	private int horas = 0,minutos = 0,segundos = 0;
	
	private Thread t = null;
	private boolean finalizado = true;
	
	public void iniciarCrono() {
		if (t==null) {
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
	public void run() {
		finalizado = false;
		while(!finalizado) {
			
		}
	}
}
