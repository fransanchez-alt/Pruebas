package PSP02;

import java.util.ArrayList;

public class E05EjemploEstados {

    public static void main (String[] args) {
        // Necesita la clase Raton (implementando Runnable con sleep) del ejemplo RatonMulti1
        E03RatonMulti1 mickey = new E03RatonMulti1 ("Mickey", 6); 
        ArrayList<Thread.State> estadosHilo = new ArrayList<>();
        Thread h = new Thread (mickey) ;
        
        estadosHilo.add(h.getState()); 
        h.start ();
        
        while (h.getState() != Thread.State.TERMINATED) {
            if (!estadosHilo.contains (h.getState())) {
                estadosHilo.add(h.getState());
            }
        } 
        /*
        if (!estadosHilo.contains (h.getState())) {
                estadosHilo.add(h.getState());
            }       
        */
        for (Thread.State estado : estadosHilo) {
            System.out.println(estado);
        }
        
    }   
}
