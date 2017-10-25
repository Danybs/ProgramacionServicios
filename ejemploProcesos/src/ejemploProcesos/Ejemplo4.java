package ejemploProcesos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class Ejemplo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		String cmd = "cmd /C date";
		/*String newDate = "01-10-2017" + 
				System.getProperty("line.separator");*/
		Process process = null;
		try {
			process = runtime.exec(cmd);
			
			//escritura - envia entrada a DATE
			OutputStream os = process.getOutputStream();
			os.write(args[0].getBytes());
			os.flush(); //vacia el buffer de salida
			
			//lectura - se obtiene la salida de DATE
			InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(
				new InputStreamReader(is));
			String linea;
			while((linea = br.readLine())!=null) 
				System.out.println(linea);
				br.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// COMPROBACION DE ERROR - 0 bien 1 - mal
		int exitVal;
		try { 
			exitVal = process.waitFor();
			System.out.println("Valor de salida: " + exitVal);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}//Ejemplo4
