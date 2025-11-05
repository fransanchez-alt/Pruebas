package PSP02;

import java.util.concurrent.Exchanger;

public class E10aTareaA implements Runnable { 
    private Exchanger<String> exchanger;

    public E10aTareaA (Exchanger<String > exchanger) { 
        super ();
        this.exchanger = exchanger; 
    }

    public void run() { 
        try {
            String mensajeRecibido = exchanger.exchange ("Mensaje enviado por TareaA");
            System.out.println("Mensaje recibido en TareaA:" + mensajeRecibido);
        } catch (InterruptedException e) { 
            e.printStackTrace ();
        }
    } 
}
