
import java.net.*;

public class ServidorUDPNotificaciones {
    public static void main(String[] args) {
        final int PUERTO = 60001;

        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            byte[] buffer = new byte[256];
            System.out.println("[UDP] Esperando notificaciones en puerto " + PUERTO);

            while (true) {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String recibido = new String(paquete.getData(), 0, paquete.getLength());
                System.out.println("[UDP] Recibido: " + recibido);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
