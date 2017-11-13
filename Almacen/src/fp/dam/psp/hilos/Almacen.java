package fp.dam.psp.hilos;

public class Almacen {
	private int [] productos = new int [0x10]; //16 en hexadecimal
	private int primero = 0;
	private int stock = 0;
	
	public synchronized void agregar(int producto) {
		
		if(stock == productos.length)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		productos[primero + stock++ & 0xf] = producto;
		notifyAll();
// 		la ultima linea
//		int posicion = primero + stock;
//		if (posicion >= productos.length)
//			posicion -= productos.length;
//		productos[posicion] = producto;
//		stock++;
		
	}
	
	public synchronized int retirar() {
		if (stock==0)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int producto = productos[primero];
//		if (++primero == productos.length)
//			primero = 0;
		primero = primero + 1 & 0xf;
		stock--;
		notifyAll();
		return producto;
	}
}
