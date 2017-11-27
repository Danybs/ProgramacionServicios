package com.cronometro;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelCrono extends JPanel implements Runnable {

  private Thread t = null;
  private long inicio;
  private Crono crono = new Crono();
  private boolean finalizado = true, pausado = false;
  private Font fuente = new Font("Courier New", Font.BOLD, 25);
  
  public void iniciarCrono() {
    inicio = System.nanoTime();
    if (t == null) {
      t = new Thread(this);
      t.start();
    }
  }
  
  public synchronized void pausarCrono() {
    pausado = true;
  }
  
  public synchronized void reanudarCrono() {
    inicio = System.nanoTime();
    pausado = false;
    notifyAll();
  }
  
  public synchronized void detenerCrono() {
    finalizado=true;
  }
  
  public synchronized void resetearCrono() {
	  crono.reset();
	  finalizado=true;
	  pausado=false;
	  repaint();
	  
	  
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setFont(fuente);
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
      synchronized(this) {
      while (pausado == true)
        try {
          wait();
          break;
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      fin = System.nanoTime();
      crono.add(fin - inicio);
      inicio = fin;
      repaint();
    }
  }
}