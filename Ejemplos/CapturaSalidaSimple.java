import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CapturaSalidaSimple {

    public static void main(String[] args) {
        String[] comando = {"uptime"};
        String nombreFichero = "uptime.txt";

        ProcessBuilder pb = new ProcessBuilder(comando);
        try {
            Process process = pb.start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                 PrintWriter writer = new PrintWriter(new FileWriter(nombreFichero))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    writer.println(line);
                }
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Salida capturada en " + nombreFichero);
            } else {
                System.err.println("El comando terminó con código " + exitCode);
            }
        } catch (IOException e) {
            System.err.println("No se pudo ejecutar el comando: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("La espera del proceso fue interrumpida.");
        }
    }
}
