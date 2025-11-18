package PSP03;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class E05SocketTCPClientTexto {
    private String serverIP;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private InputStreamReader isr;
    private BufferedReader br;
    private PrintWriter pw;

    public E05SocketTCPClientTexto(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws UnknownHostException, IOException {
        socket = new Socket(serverIP, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();
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
    }

    public void enviarMensajeTexto(String mensaje) {
        pw.println(mensaje);
    }

    public String leerMensajeTexto() throws IOException {
        return br.readLine();
    }

    public static void main(String[] args) {
        E05SocketTCPClientTexto cliente = new E05SocketTCPClientTexto("localhost", 49171);
        try {
            cliente.start();
            cliente.abrirCanalesDeTexto();
            cliente.enviarMensajeTexto("Mensaje enviado desde el cliente");
            String mensajeRecibido = cliente.leerMensajeTexto();
            System.out.println("(Cliente) Mensaje recibido: " + mensajeRecibido);
            cliente.cerrarCanalesDeTexto();
            cliente.stop();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}