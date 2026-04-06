import java.io.*;
import java.net.*;

public class ClienteTCPMayus {
    public static void main(String[] args) {
        final String SERVER = "localhost";
        final int PUERTO = 50000;

        try (
            Socket socket = new Socket(SERVER, PUERTO);
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            System.out.print("Introduce un mensaje: ");
            String mensaje = teclado.readLine();

            pw.println(mensaje);
            String respuesta = br.readLine();
            System.out.println("Servidor responde: " + respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}