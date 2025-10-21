package PSP01;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ejemplo5 {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        // En macOS/Linux utilizamos sh -c "sort" para disponer de un comando que lee de stdin.
        String[] comando = {"sh", "-c", "sort"};
        Process proceso = null;

        try {
            proceso = runtime.exec(comando);

            OutputStream os = proceso.getOutputStream();// flujo de entrada del proceso
            BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(os));// Aseguramos que se envíen los datos del búffer al proceso
            escritor.write("mandarina\n");
            escritor.write("kiwi\n");
            escritor.write("manzana\n");
            escritor.flush(); // Aseguramos que se envíen los datos del búffer al proceso
            escritor.close();

            InputStream is = proceso.getInputStream();
            BufferedReader lector = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println("sort > " + linea);
            }
            lector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (proceso != null) {
            try {
                int exitVal = proceso.waitFor();
                System.out.println("Valor de Salida: " + exitVal);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
} // Ejemplo5
