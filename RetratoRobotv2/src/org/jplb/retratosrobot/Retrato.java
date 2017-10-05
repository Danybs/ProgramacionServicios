package org.jplb.retratosrobot;

public class Retrato {
	
	static private String [][] rasgos = {
			{"WWWWWWWWW", "\\\\\\//////", "|\"\"\"\"\"\"\"|", "|||||||||"},
			{"|  O O  |", "|-(· ·)-|", "|-(o  o)-|", "|  \\ /  |"},
			{"@   J   @", "{   \"   }", "[   j   ]", "<   -   >"},
			{"|  ===  |", "|   -   |", "|  ___  |", "|  ---  |"},
			{"\\_______/", "\\,,,,,,,/"}
	};
	
	private int pelo;
	private int ojos;
	private int nariz;
	private int boca;
	private int barbilla;
	
	public Retrato(int pelo, int ojos, int nariz, int boca, int barbilla) throws Exception {
		if (pelo < 0 || pelo >= rasgos[0].length)
			throw new Exception("Opción de pelo no válida");
		if (ojos < 0 || ojos >= rasgos[1].length)
			throw new Exception("Opción de ojos no válida");
		if (nariz < 0 || nariz >= rasgos[2].length)
			throw new Exception("Opción de nariz no válida");
		if (boca < 0 || boca >= rasgos[3].length)
			throw new Exception("Opción de boca no válida");
		if (barbilla < 0 || barbilla >= rasgos[4].length)
			throw new Exception("Opción de barbilla no válida");
		this.pelo = pelo;
		this.ojos = ojos;
		this.nariz = nariz;
		this.boca = boca;
		this.barbilla = barbilla;
	}
	
	@Override
	public String toString() {
		return rasgos[0][pelo] + System.getProperty("line.separator") +
			   rasgos[1][ojos] + System.getProperty("line.separator") +
			   rasgos[2][nariz] + System.getProperty("line.separator") +
			   rasgos[3][boca] + System.getProperty("line.separator") +
			   rasgos[4][barbilla] + System.getProperty("line.separator");
	}
	
	public static void mostrarOpcionesRasgo(int rasgo) {
		for (int i=0; i<rasgos[rasgo].length; i++)
			System.out.println(i + " - " + rasgos[rasgo][i]);
	}

	public int getPelo() {
		return pelo;
	}

	public void setPelo(int pelo) {
		this.pelo = pelo;
	}

	public int getOjos() {
		return ojos;
	}

	public void setOjos(int ojos) {
		this.ojos = ojos;
	}

	public int getNariz() {
		return nariz;
	}

	public void setNariz(int nariz) {
		this.nariz = nariz;
	}

	public int getBoca() {
		return boca;
	}

	public void setBoca(int boca) {
		this.boca = boca;
	}

	public int getBarbilla() {
		return barbilla;
	}

	public void setBarbilla(int barbilla) {
		this.barbilla = barbilla;
	}
	
	public String getStringPelo() {
		return rasgos[0][pelo];
	}
	
	public String getStringOjos() {
		return rasgos[1][ojos];
	}
	
	public String getStringNariz() {
		return rasgos[2][nariz];
	}
	
	public String getStringBoca() {
		return rasgos[3][boca];
	}
	
	public String getStringBarbilla() {
		return rasgos[4][barbilla];
	}
}//end
