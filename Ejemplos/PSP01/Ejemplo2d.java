package PSP01;
public class Ejemplo2d {

    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "dir");
            Process p = pb.start();

            // Mostrar la salida del comando
            java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(p.getInputStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
               System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error ejecutando CMD /C dir");
            e.printStackTrace();
        }
    }
}
