package PSP01;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2c {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
      String comando = "CMD /C DIRR";
        //String[] comando = {"java", "Unsaludo", "Hola Mundo!!", ">fichero.txt"};
        Process p = null;
        try {
            p = r.exec(comando);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null) // lee una línea
                System.out.println(linea);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // COMPROBACION DE ERROR - 0 bien - 1 mal
        int exitVal;
        /*try {
            InputStream err = p.getErrorStream();
            BufferedReader brErr = new BufferedReader(new InputStreamReader(err));
            String line = null;
            while ((line = brErr.readLine()) != null) {
                System.out.println("ERROR > " + line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
}*/

        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
