package org.psp.blackjack;

import org.psp.naipes.Mazo;
import org.psp.naipes.Naipe;
import org.psp.naipes.Palo;
import org.psp.naipes.Rango;

public class BarajaBJ extends Mazo{
	public BarajaBJ(int numBarajas) {
		super();
		
		for (int i=0; i< numBarajas; i++) {
			for (Palo p: Palo.values()) {
				for (Rango r: Rango.values()) {
					addNaipe(new Naipe(r, p));
				}
			}
		}
	}
}
