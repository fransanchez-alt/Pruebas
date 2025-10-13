public class Ejemplo1 {

	public static void main (String[] args) { 
		Runtime r = Runtime.getRuntime();
		String comando = "notepad"; 
		Process p; 
		try {
			p = r.exec(comando);
			System.out.println("Notepad started successfully.");
		} catch (Exception e) {
			System.out.println("Error en : " + comando); 
			e.printStackTrace();
		}
	}
}


