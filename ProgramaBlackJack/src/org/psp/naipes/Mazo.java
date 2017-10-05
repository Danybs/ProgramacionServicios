package org.psp.naipes;

import java.util.ArrayList;

public class Mazo {
	private ArrayList<Naipe> naipes;
	
	public Mazo() {
		naipes = new ArrayList();
	}
	
	public void addNaipe(Naipe naipe) {
		naipes.add(naipe);
	}
	
	public Naipe getNaipe() {
		try {
			Naipe n = naipes.get(0);
			naipes.remove(0);
			return n;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public Naipe getNaipe(int posicion) {
		try {
			Naipe n = naipes.get(0);
			naipes.remove(0);
			return n;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
}
