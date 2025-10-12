import java.io.*;

public class Ejemplo5 {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String osName = System.getProperty("os.name").toLowerCase();

        String[] comando;
        if (osName.contains("win")) {
            comando = new String[]{"cmd", "/c", "sort"};
        } else {
            comando = new String[]{"sort"};
        }

        String[] datos = {
                "manzana",
                "pera",
                "banana",
                "kiwi"
        };

        Process p = null;

        try {
            p = r.exec(comando);

            try (OutputStream os = p.getOutputStream();
                 InputStream is = p.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                for (String dato : datos) {
                    os.write(dato.getBytes());
                    os.write(System.lineSeparator().getBytes());
                }
                os.flush(); // vacía el buffer de salida para que sort empiece a procesar
                os.close(); // cierra la entrada del proceso para indicar fin de datos

                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            int exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error en la ejecución del comando");
            e.printStackTrace();
        }
    }
}
