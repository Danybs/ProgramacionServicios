import java.awt.BorderLayout;
import java.awt.Dimension;

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
public class Pelotas_gui extends JFrame implements Runnable{
	
	public Pelotas_gui() {
		setTitle("Pelotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		JPanel ps = new JPanel();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		Pelotas_gui p = new Pelotas_gui();
	}
}
