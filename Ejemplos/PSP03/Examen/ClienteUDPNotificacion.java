

import java.net.*;

public class ClienteUDPNotificacion {
    public static void main(String[] args) {
        final int PUERTO = 60001;
        final String SERVER = "localhost";

        try (DatagramSocket socket = new DatagramSocket()) {
            String ip = InetAddress.getLocalHost().getHostAddress();
            String mensaje = "FIN " + ip;

            byte[] datos = mensaje.getBytes();
            DatagramPacket paquete =
                new DatagramPacket(datos, datos.length, InetAddress.getByName(SERVER), PUERTO);

            socket.send(paquete);
            System.out.println("[UDP] Notificación enviada.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
