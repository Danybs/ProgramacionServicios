package fp.dam.psp.hilos;

import java.util.Random;

public class Productor extends Thread {

	private Almacen almacen;
	private long retardo;
	Random r = new Random();
	
	public Productor(Almacen almacen, long retardo) {
		this.almacen = almacen;
		this.retardo = retardo;
	}

	@Override
	public void run() {
		while (true) {
			almacen.agregar(r.nextInt(90000) + 1000);
			System.out.println("Agregado");
			try {
				Thread.sleep(retardo);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
