public class Ejemplo2 {

    public static void main(String[] args) {
        String comando = "CMD";
        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process p = pb.start();
            System.out.println("Comando started successfully.");
        } catch (Exception e) {
            System.out.println("Error en : " + comando);
            e.printStackTrace();
        }
    }
}
