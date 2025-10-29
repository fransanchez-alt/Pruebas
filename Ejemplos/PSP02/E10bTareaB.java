package PSP02;

import java.util.concurrent.Exchanger;

public class E10bTareaB implements Runnable { 
    private Exchanger<String> exchanger;

    public E10bTareaB (Exchanger<String > exchanger) { 
        super ();
        this.exchanger = exchanger;
    }

    public void run() { 
        try {
            String mensajeRecibido = exchanger.exchange ("Mensaje enviado por TareaB") ;
            System.out.println ("Mensaje recibido en TareaB:" + mensajeRecibido);
        } catch (InterruptedException e) { 
            e.printStackTrace (); 
        }
    }
}
