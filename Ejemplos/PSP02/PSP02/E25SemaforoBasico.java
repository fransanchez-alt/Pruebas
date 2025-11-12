package PSP02;
import java.util.concurrent.Semaphore; 

public class E25SemaforoBasico implements Runnable {

    Semaphore semaforo = new Semaphore (3) ;

    @Override
    public void run() { 
        try {
            semaforo.acquire ();
            System.out.println("Paso 1"); 
            Thread.sleep(1000); 
            System.out.println ("Paso 2"); 
            Thread.sleep (1000) ; 
            System.out.println ("Paso 3"); 
            Thread.sleep(1000);
            semaforo.release();
        } catch (InterruptedException ie) { 
            ie.printStackTrace ();
        }
    }

    public static void main (String[] args) { 
        E25SemaforoBasico sb = new E25SemaforoBasico (); 
        for (int i=0;i<5;i++) {
            new Thread (sb) .start ();
        }
    } 
}