package PSP03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class E07SocketTCPServerMultihilo {
    private ServerSocket serverSocket;

    public E07SocketTCPServerMultihilo(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("(Servidor) Conexión establecida");
            new E08GestorProcesos(socket).start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            new E07SocketTCPServerMultihilo(49171);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}