package ejemploHilo;

public class Runnable123 {
	/**
	 * 
	 */
	public static void main(String[] args) {
		// con esto creamos un hilo
		Thread hilo = new Thread(new Runnable123());
		// aki lo comenzamos para que nos haga 2 drocesos a la vez...
		// si lo ejecutamos muchas veces se demuestra que los numeros cambian y hace
		// cada proceso a su ritmo
		hilo.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Hilo principal " + i);
		}

	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hilo secundario " + i);
		}
	}
}
