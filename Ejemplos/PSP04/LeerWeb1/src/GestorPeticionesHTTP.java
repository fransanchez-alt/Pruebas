import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GestorPeticionesHTTP {
    /*
    Esta clase tiene dos métodos principales: uno para obtener el contenido de una URL y otro para guardarlo en un fichero. 

    En el primero, partimos de una dirección en forma de String y creamos un objeto URL a partir de ella. 
    Después abrimos una conexión HTTP con el servidor y configuramos la petición (GET, cabeceras, etc.). 
    Obtenemos el código de respuesta para comprobar si todo ha ido bien, y si es así, 
    leemos el flujo de datos que nos envía el servidor carácter a carácter mediante un Reader, 
    construyendo el contenido en un StringBuilder. Cuando terminamos, cerramos la conexión y devolvemos el resultado.

    El segundo método simplemente recibe ese contenido y lo guarda en un fichero en disco.
    Finalmente, en el main construimos la URL, llamamos al método para obtener el contenido y lo guardamos en un archivo.
    */

    public StringBuilder getContenidoMetodoGet(String direccion) throws Exception {
        StringBuilder respuesta = new StringBuilder();
        URL url = new URL(direccion);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        conexion.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        int estado = conexion.getResponseCode();

        Reader streamReader = null;
        if (estado == HttpURLConnection.HTTP_OK) {
            streamReader = new InputStreamReader(conexion.getInputStream());
            int caracter;
            while ((caracter = streamReader.read()) != -1) {
                respuesta.append((char) caracter);
            }
        } else {
            throw new Exception("Error HTTP " + estado);
        }

        conexion.disconnect();
        return respuesta;
    }

    public static void writeFile(String strPath, String contenido) throws IOException {
        Path path = Paths.get(strPath);
        byte[] strToBytes = contenido.getBytes();
        Files.write(path, strToBytes);
    }

    public static void main(String[] args) {
        try {
            String esquema = "https://";
            String servidor = "es.wikipedia.org/wiki/";
            String recurso = URLEncoder.encode("Informática", StandardCharsets.UTF_8.name());
            //se codifica el recurso para evitar problemas con caracteres especiales

            GestorPeticionesHTTP gp = new GestorPeticionesHTTP();
            String direccion = esquema + servidor + recurso;

            StringBuilder resultado = gp.getContenidoMetodoGet(direccion);

            GestorPeticionesHTTP.writeFile("wikipedia.html", resultado.toString());

            System.out.println("Descarga finalizada");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}


