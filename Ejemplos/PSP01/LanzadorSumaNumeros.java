package PSP01;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Lanza el programa SumaNumeros pasándole dos números mediante stdin.
 */
public class LanzadorSumaNumeros {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java LanzadorSumaNumeros <numero1> <numero2>");
            System.exit(1);
        }

        double numero1;
        double numero2;
        try {
            numero1 = Double.parseDouble(args[0]);
            numero2 = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Error: Ambos argumentos deben ser numéricos.");
            System.exit(2);
            return;
        }

        Runtime runtime = Runtime.getRuntime();
        String[] comando = {"java", "SumaNumeros"};
        Process proceso = null;
        try {
            // Lanzamos el programa hijo.
            proceso = runtime.exec(comando);

            // Escribimos los dos números que recibimos por argumentos.
            OutputStream os = proceso.getOutputStream();
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {
                writer.write(args[0]);
                writer.newLine();
                writer.write(args[1]);
                writer.newLine();
            }

            // Leemos la salida estándar del hijo y la mostramos.
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println("Hijo > " + linea);
                }
            }

            int exitCode = proceso.waitFor();
            System.out.println("Valor de Salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
