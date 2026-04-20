import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;

public class LeerWebHTTP {
 public static void main(String[] args) {
     
    HttpURLConnection conexion = null;
    try {
   //URL url = new URL("http://www.iesdonosocortes.es/");
    //URL url = new URL("http://httpbin.org/status/404");
    URL url = new URL("https://api.chucknorris.io/jokes/random");
    

    conexion = (HttpURLConnection) url.openConnection();

    // 1. Configuración
    conexion.setRequestMethod("GET");
    

    // 2. Código de respuesta
    // conexion.setInstanceFollowRedirects(false);
    int codigo = conexion.getResponseCode();
    System.out.println("Código HTTP: " + codigo);
    System.out.println("Mensaje: " + conexion.getResponseMessage());

    // 3. Lectura solo si OK
    if (codigo == HttpURLConnection.HTTP_OK) {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(conexion.getInputStream())
        );

        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
    
       
    
        br.close();
    } else {
        System.out.println("Error: La respuesta no fue exitosa");
    }
} catch (Exception e) {
            e.printStackTrace();
        } finally {
    // 4. Desconexión
    if (conexion != null) {
        conexion.disconnect();
    }
}
}
}
