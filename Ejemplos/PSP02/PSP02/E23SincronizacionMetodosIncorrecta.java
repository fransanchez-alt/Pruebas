package PSP02;

public class E23SincronizacionMetodosIncorrecta extends Thread { 
    public synchronized void metodo1() { 
        System.out.println("Comienzo del método 1"); 
        try {
            Thread.sleep (1000); 
        } catch (InterruptedException ie) {
            return;
        }
        System.out.println("Fin del método 1") ;
    }

    public synchronized void metodo2 () { 
        System.out.println("Comienzo del método 2") ; 
        try {
            Thread.sleep (1000) ; 
        } catch (InterruptedException ie) {
            return;
        }
        System.out.println("Fin del método 2") ;
    }

    @Override 
    public void run() {
        metodo1 (); 
        metodo2 () ;
    }

    public static void main (String[] args) { 
        E23SincronizacionMetodosIncorrecta sm = new E23SincronizacionMetodosIncorrecta ();
        E23SincronizacionMetodosIncorrecta sm2 = new E23SincronizacionMetodosIncorrecta ();
        new Thread(sm).start () ; 
        new Thread (sm2).start () ;
    } 
}