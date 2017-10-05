import java.util.Scanner;

import org.jplb.retratosrobot.Retrato;

public class RetratosRobot {

	public static void main(String[] args) throws Exception {
		int opcionPelo;
		int opcionOjos;
		int opcionNariz;
		int opcionBoca;
		int opcionBarbilla;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Elige una opción para el pelo:");
		Retrato.mostrarOpcionesRasgo(0);
		opcionPelo = in.nextInt();
		
		System.out.println("Elige una opción para los ojos:");
		Retrato.mostrarOpcionesRasgo(1);
		opcionOjos = in.nextInt();
		
		System.out.println("Elige una opción para la nariz:");
		Retrato.mostrarOpcionesRasgo(2);
		opcionNariz = in.nextInt();
		
		System.out.println("Elige una opción para la boca:");
		Retrato.mostrarOpcionesRasgo(3);
		opcionBoca = in.nextInt();
		
		System.out.println("Elige una opción para la barbilla:");
		Retrato.mostrarOpcionesRasgo(4);
		opcionBarbilla = in.nextInt();
		
		Retrato r = new Retrato(opcionPelo, opcionOjos, opcionNariz, opcionBoca, opcionBarbilla);
		System.out.print(r);
	}

}//end
