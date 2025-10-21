package PSP01;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ejemplo6 {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        
        String[] comando = {"java","EjemploLectura"};
        Process proceso = null;

        try {
            proceso = runtime.exec(comando);

            OutputStream os = proceso.getOutputStream();// flujo de entrada del proceso
            BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(os));// Aseguramos que se envíen los datos del búffer al proceso
            System.out.println("Escribiendo en el hijo....");
            escritor.write("Hola Manuel\n");
            escritor.flush(); // Aseguramos que se envíen los datos del búffer al proceso
            escritor.close();

            InputStream is = proceso.getInputStream();
            BufferedReader lector = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea recibida desde el hijo:   " + linea);
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
} // Ejemplo6

    

