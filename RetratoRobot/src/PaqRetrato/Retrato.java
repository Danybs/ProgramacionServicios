package PaqRetrato;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Retrato {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Rasgos r1 = new Rasgos();
		Cara c1;
		r1.menu();
		System.out.println("Escoja los rasgos: ");
		System.out.println("  Pelo:  ");
		int p = teclado.nextInt();
		System.out.println("  Ojos:  ");
		int o = teclado.nextInt();
		System.out.println("  Orejas/Nariz:  ");
		int on = teclado.nextInt();
		System.out.println("  Boca:  ");
		int b = teclado.nextInt();
		c1 = new Cara(p, o, on, b);
		c1.imprimir();
	}
}

class Rasgos {
	private String pDenso = " WWWWWWWWW";
	private String pEscaso = " |||||||||";
	private String Rapado = " |'''''''|";
	private String aRaya = " \\\\///////";
	private String ojos1 = " |  O O  |";
	private String ojos2 = " |-(· ·)-|";
	private String ojos3 = " |-(o o)-|";
	private String ojos4 = " |  \\ /  |";
	private String orejasNariz1 = "@    J    @";
	private String orejasNariz2 = "{    \"    }";
	private String orejasNariz3 = "[    j    ]";
	private String orejasNariz4 = "<    -    >";
	private String boca1 = " |  ===  |";
	private String boca2 = " |   -   |";
	private String boca3 = " |  ___  |";
	private String boca4 = " |  ---  |";
	private String barb = "  \\_____/";

	public String getpDenso() {
		return pDenso;
	}

	public String getpEscaso() {
		return pEscaso;
	}

	public String getRapado() {
		return Rapado;
	}

	public String getaRaya() {
		return aRaya;
	}

	public String getOjos1() {
		return ojos1;
	}

	public String getOjos2() {
		return ojos2;
	}

	public String getOjos3() {
		return ojos3;
	}

	public String getOjos4() {
		return ojos4;
	}

	public String getOrejasNariz1() {
		return orejasNariz1;
	}

	public String getOrejasNariz2() {
		return orejasNariz2;
	}

	public String getOrejasNariz3() {
		return orejasNariz3;
	}

	public String getOrejasNariz4() {
		return orejasNariz4;
	}

	public String getBoca1() {
		return boca1;
	}

	public String getBoca2() {
		return boca2;
	}

	public String getBoca3() {
		return boca3;
	}

	public String getBoca4() {
		return boca4;
	}

	public String getBarb() {
		return barb;
	}

	public void menu() {
		System.out.println("Rasgos: \n" + pDenso + "   " + pEscaso + "   " + Rapado + "   " + aRaya + "\n" + ojos1
				+ "   " + ojos2 + "   " + ojos3 + "   " + ojos4 + "\n" + orejasNariz1 + "  " + orejasNariz2 + "  "
				+ orejasNariz3 + "  " + orejasNariz4 + "\n" + boca1 + "   " + boca2 + "   " + boca3 + "   " + boca4
				+ "\n" + barb + "    " + barb + "    " + barb + "    " + barb + "\n" + "-- n. 1 --" + "   "
				+ "-- n. 2 --" + "   " + "-- n. 3 --" + "   " + "-- n. 4 --" + "\n");
	}
}

class Cara extends Rasgos {
	private int pelo;
	private int ojos;
	private int orNa;
	private int boca;
	
	public Cara(int pelo, int ojos, int orNa, int boca) {
		super();
		this.pelo = pelo;
		this.ojos = ojos;
		this.orNa = orNa;
		this.boca = boca;
	}

	public void imprimir() {
		System.out.println("\n--Descripcion del sospechoso--");
		switch (pelo) {
		case 1:
			System.out.println(getpDenso());
			break;
		case 2:
			System.out.println(getpEscaso());
			break;
		case 3:
			System.out.println(getRapado());
			break;
		case 4:
			System.out.println(getaRaya());
			break;
		default:
			break;
		}
		switch (ojos) {
		case 1:
			System.out.println(getOjos1());
			break;
		case 2:
			System.out.println(getOjos2());
			break;
		case 3:
			System.out.println(getOjos3());
			break;
		case 4:
			System.out.println(getOjos4());
			break;
		default:
			break;
		}
		switch (orNa) {
		case 1:
			System.out.println(getOrejasNariz1());
			break;
		case 2:
			System.out.println(getOrejasNariz2());
			break;
		case 3:
			System.out.println(getOrejasNariz3());
			break;
		case 4:
			System.out.println(getOrejasNariz4());
			break;
		default:
			break;
		}
		switch (boca) {
		case 1:
			System.out.println(getBoca1());
			break;
		case 2:
			System.out.println(getBoca2());
			break;
		case 3:
			System.out.println(getBoca3());
			break;
		case 4:
			System.out.println(getBoca4());
			break;
		default:
			break;
		}
		System.out.println(getBarb());

	}

}//end
