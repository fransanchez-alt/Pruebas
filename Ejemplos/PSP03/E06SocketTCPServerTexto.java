package PSP03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class E06SocketTCPServerTexto {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;

    public E06SocketTCPServerTexto(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        socket = serverSocket.accept();
        is = socket.getInputStream();
        os = socket.getOutputStream();
    }

    public void abrirCanalesDeTexto() {
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        pw = new PrintWriter(os, true);
    }

    public void cerrarCanalesDeTexto() throws IOException {
        br.close();
        isr.close();
        pw.close();
    }

    public void stop() throws IOException {
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
    }

    public String leerMensajeTexto() throws IOException {
        return br.readLine();
    }

    public void enviarMensajeTexto(String mensaje) {
        pw.println(mensaje);
    }

    public static void main(String[] args) {
        try {
            E06SocketTCPServerTexto servidor = new E06SocketTCPServerTexto(49171);
            servidor.start();
            servidor.abrirCanalesDeTexto();
            String mensajeRecibido = servidor.leerMensajeTexto();
            System.out.println("(Servidor) Mensaje recibido: " + mensajeRecibido);
            servidor.enviarMensajeTexto("Mensaje enviado desde el servidor");
            servidor.cerrarCanalesDeTexto();
            servidor.stop();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}