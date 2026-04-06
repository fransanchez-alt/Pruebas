import java.io.*;
import java.net.*;

public class ServidorTCPMayus {
    private static final int PUERTO = 50000;

    public static void main(String[] args) {
        System.out.println("[SERVIDOR] Iniciado en puerto " + PUERTO);

        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("[SERVIDOR] Cliente conectado: " + cliente.getInetAddress());
                new HiloCliente(cliente).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HiloCliente extends Thread {
    private Socket socket;

    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        ) {
            String msg = br.readLine();
            String respuesta = msg.toUpperCase();
            pw.println(respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { socket.close(); } catch (IOException ignored) {}
        }
    }
}