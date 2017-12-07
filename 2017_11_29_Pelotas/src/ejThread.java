//import java.awt.BorderLayout;
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

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class ejThread {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    JFrame marco=new MarcoRebote();
    
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    marco.setVisible(true);

  }

}




//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
  
  // Mueve la pelota invirtiendo posición si choca con límites
  
  public void mueve_pelota(Rectangle2D limites){
    
    x+=dx;
    
    y+=dy;
    
    if(x<limites.getMinX()){
      
      x=limites.getMinX();
      
      dx=-dx;
    }
    
    if(x + TAMX>=limites.getMaxX()){
      
      x=limites.getMaxX() - TAMX;
      
      dx=-dx;
    }
    
    if(y<limites.getMinY()){
      
      y=limites.getMinY();
      
      dy=-dy;
    }
    
    if(y + TAMY>=limites.getMaxY()){
      
      y=limites.getMaxY()-TAMY;
      
      dy=-dy;
      
    }
    
  }
  
  //Forma de la pelota en su posición inicial
  
  public Ellipse2D getShape(){
    
    return new Ellipse2D.Double(x,y,TAMX,TAMY);
    
  }  
  
  private static final int TAMX=15;
  
  private static final int TAMY=15;
  
  private double x=0;
  
  private double y=0;
  
  private double dx=1;
  
  private double dy=1;
  
  
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
  
  //Añadimos pelota a la lámina
  
  public void add(Pelota b){
    
    pelotas.add(b);
  }
  
  public void paintComponent(Graphics g){
    
    super.paintComponent(g);
    
    Graphics2D g2=(Graphics2D)g;
    
    for(Pelota b: pelotas){
      
      g2.fill(b.getShape());
    }
    
  }
  
  private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
  
  public MarcoRebote(){
    
    setBounds(600,300,400,350);
    
    setTitle ("Rebotes");
    
    lamina=new LaminaPelota();
    
    add(lamina, BorderLayout.CENTER);
    
    JPanel laminaBotones=new JPanel();
    
    ponerBoton(laminaBotones, "Dale!", new ActionListener(){
      
      public void actionPerformed(ActionEvent evento){
        
        comienza_el_juego();
      }
      
    });
    
    
    ponerBoton(laminaBotones, "Salir", new ActionListener(){
      
      public void actionPerformed(ActionEvent evento){
        
        System.exit(0);
        
      }
      
    });
    
    add(laminaBotones, BorderLayout.SOUTH);
  }
  
  
  //Ponemos botones
  
  public void ponerBoton(Container c, String titulo, ActionListener oyente){
    
    JButton boton=new JButton(titulo);
    
    c.add(boton);
    
    boton.addActionListener(oyente);
    
  }
  
  //Añade pelota y la bota 1000 veces
  
  public void comienza_el_juego (){
    
          
      Pelota pelota=new Pelota();
      
      lamina.add(pelota);
      
      Runnable r = new PelotaHilos(pelota, lamina);
      
      Thread t= new Thread(r);
      
      t.start();
    
    
  }
  
  private LaminaPelota lamina;
  
  
}


class PelotaHilos implements Runnable {

  private Pelota pelota;
  private Component componente;
  
   public PelotaHilos(Pelota unaPelota, Component unComponente) {
    // TODO Auto-generated constructor stub
     
     pelota = unaPelota;
     componente = unComponente;
   
   }
  
   
  @Override
  public void run() {
    // TODO Auto-generated method stub
    
    while(true){
      
      pelota.mueve_pelota(componente.getBounds());
      
      componente.paint(componente.getGraphics());
      
      
      try {
        Thread.sleep(4);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
  }
  
}


