package PSP01;
public class Lanzador {
    public static void main(String[] args) {
        try {
            // Ejecuta MostrarNombre con argumento "Juan" usando ProcessBuilder
            ProcessBuilder pb = new ProcessBuilder("java","-cp", "src", "MostrarNombre", "Juan");
            Process p = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(p.getInputStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error ejecutando MostrarNombre");
            e.printStackTrace();
        }
    }
}
