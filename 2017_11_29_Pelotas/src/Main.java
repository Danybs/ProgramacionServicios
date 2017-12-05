import java.awt.Canvas;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

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
public class Main {
		public static void main(String args[]) {
			new ventana();
		}
}

class ventana extends JPanel implements Runnable{
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public synchronized void () {
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		
	}
	


}



class pelota {
	public void move() {
		
	}
	
}

class Hiloescena {
	
}


//private int width = 100;
//private int height = 70;
//ventana() {
//	setTitle("Pelotas");		
//	pack(); // default size
//	setResizable(false);
//	setBackground(Color.yellow);
//	setVisible(true);
//	setLocationRelativeTo(null);
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	setSize(width, height);
//}