package ejemploHilo;

/**
 * 
 * @author Dani
 *
 */
public class MiClase {
	public static void main(String[] args) {
		Thread hilo = new Thread(new Runable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hilo secundario " + i);
				}
			}
		});
		hilo.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Hilo principal " + i);
		}
	}

}
