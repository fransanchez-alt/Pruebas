import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GestorPeticionesHTTPParametros {
    public static void main(String[] args) {
    try {
        String esquema = "https://";
        String servidor = "api.chucknorris.io";
        String path = "/jokes/search";
        String texto = URLEncoder.encode("animal", StandardCharsets.UTF_8.name());
        String parametros = "?query=" + texto;

        GestorPeticionesHTTP gp = new GestorPeticionesHTTP();
        String direccion = esquema + servidor + path + parametros;

        StringBuilder resultado = gp.getContenidoMetodoGet(direccion);

        GestorPeticionesHTTP.writeFile("animal_jokes.html", resultado.toString());

        System.out.println("Descarga finalizada");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
