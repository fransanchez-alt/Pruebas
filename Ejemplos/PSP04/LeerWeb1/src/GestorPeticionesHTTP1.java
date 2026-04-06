
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class GestorPeticionesHTTP1 {
    /*
En esta versión utilizamos la API moderna de Java (HttpClient, HttpRequest y HttpResponse),
que simplifica mucho el trabajo con HTTP. En lugar de abrir conexiones manualmente y leer
el flujo de datos carácter a carácter, aquí creamos un cliente, definimos una petición y
obtenemos una respuesta de forma más estructurada. Además, mediante BodyHandlers indicamos
qué hacer con el contenido recibido; en este caso, se guarda directamente en un fichero
sin necesidad de procesarlo manualmente. Esto hace el código más limpio, más claro y más
cercano al funcionamiento real del protocolo HTTP (cliente → petición → respuesta).
*/

    public int almacenarPagina(String esquema, String servidor,
                               String recurso, String path) throws Exception {

        // No codificamos la ruta completa, solo parámetros si los hubiera
        String direccion = esquema + servidor + recurso;

        HttpClient httpClient = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(direccion))
                .headers("Content-Type", "text/plain")
                .setHeader("User-Agent", "Mozilla/5.0")
                .build();

        HttpResponse<Path> response =
                httpClient.send(request,
                        HttpResponse.BodyHandlers.ofFile(Path.of(path)));

        return response.statusCode();
    }

    public static void main(String[] args) {
        String esquema = "https://";
        String servidor = "api.chucknorris.io";
        String recurso = "/jokes/random";

        GestorPeticionesHTTP1 gestor = new GestorPeticionesHTTP1();

        try {
            int codigoEstado = gestor.almacenarPagina(
                    esquema, servidor, recurso, "resultado.html");

            if (codigoEstado == HttpURLConnection.HTTP_OK) {
                System.out.println("Descarga finalizada");
            } else {
                System.err.println("Error " + codigoEstado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}