
    public class Ejemplo1b {

	public static void main (String[] args) { 
		Runtime r = Runtime.getRuntime();
		String comando = "CMD /C DIR"; 
		Process p; 
		try {
			p = r.exec(comando);
			System.out.println("DIR started successfully.");
		} catch (Exception e) {
			System.out.println("Error en : " + comando); 
			e.printStackTrace();
		}
	}
}


