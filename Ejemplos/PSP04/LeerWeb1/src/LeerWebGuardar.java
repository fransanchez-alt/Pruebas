import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class LeerWebGuardar {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.iesdonosocortes.es/");
            URLConnection conexion = url.openConnection();
            InputStream is = conexion.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("pagina.html"));

            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Archivo pagina.html creado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}