import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class LeerWeb {

    public static void main(String[] args) {
        try {
            URL url = URI.create("http://www.iesdonosocortes.es/").toURL();
            URLConnection conexion = url.openConnection();
            InputStream is = conexion.getInputStream();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, "UTF-8")
            );

            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}