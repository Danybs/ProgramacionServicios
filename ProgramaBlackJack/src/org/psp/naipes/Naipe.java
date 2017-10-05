package org.psp.naipes;

public class Naipe {
	private Palo palo;
	private Rango rango;
	private int valor;
	
	public Naipe(Rango rango, Palo palo) {
		this.palo = palo;
		this.rango = rango;
		valor = rango.ordinal() + 1;
	}
	public Naipe(Palo palo, Rango rango, int valor) {
		this.palo = palo;
		this.rango = rango;
		this.valor = valor;
	}
	public Palo getPalo() {
		return palo;
	}
	public void setPalo(Palo palo) {
		this.palo = palo;
	}
	public Rango getRango() {
		return rango;
	}
	public void setRango(Rango rango) {
		this.rango = rango;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}
