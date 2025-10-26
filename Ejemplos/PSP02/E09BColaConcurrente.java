package PSP02;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class E09BColaConcurrente implements Runnable {
    private static Queue<Integer> cola = new ConcurrentLinkedDeque<Integer> () ;
    private static int contadorGlobal=0;

    @Override 
    public void run() {
        int contador=0;
        cola.add (10) ;
        for (Integer i : cola) { 
            System.out.println (i+":" + "contador local blucle hilo:" + contador++);
            contadorGlobal++;

        }
        System.out.println("Tamaño cola:" + cola.size());
        System.out.println("Contador global:" + contadorGlobal);
    }

    public static void main (String[] args) {
        for (int i=0;i<10;i++) {
            new Thread (new E09BColaConcurrente ()) .start () ;
        }
        
    }
}
