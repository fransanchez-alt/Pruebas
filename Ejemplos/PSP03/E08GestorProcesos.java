package PSP03;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class E08GestorProcesos extends Thread {
    private Socket socket;
    private OutputStream os;

    public E08GestorProcesos(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            realizarProceso();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void realizarProceso() throws IOException {
        os = this.socket.getOutputStream();
        Random generador = new Random();
        int tiempoEspera = generador.nextInt(60);
        try {
            TimeUnit.SECONDS.sleep(tiempoEspera);
            os.write(tiempoEspera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }
}