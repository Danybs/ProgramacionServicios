package fp.dam.psp.hilos;

public class Prueba {
	public static void main(String[] args) {
		Almacen almacen = new Almacen();
		Productor productor = new Productor(almacen, 1000);
		Consumidor consumidor = new Consumidor(almacen, 1300);
		productor.start();
		consumidor.start();
		while (true) {
			try {
				productor.join();
				consumidor.join();
				break;
			} catch (InterruptedException e) {
			}
		}

	}
}
