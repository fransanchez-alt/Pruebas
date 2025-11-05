package PSP02;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class E07SistemaRiego1 implements Runnable {
    @Override 
    public void run() {
        System.out.println ("Regando...");
    }

    public static void main (String[]args) {
        E07SistemaRiego1 sr = new E07SistemaRiego1();
        ScheduledExecutorService stp =
        Executors.newSingleThreadScheduledExecutor () ;
        stp.scheduleAtFixedRate(sr, 1, 2, TimeUnit.SECONDS) ;
        System.out.println("Sistema de riego configurado.");
    }
}


