package PSP02;
public class E22SincronizacionMetodos implements Runnable { 
    
    public synchronized void metodo1() {
        System.out.println("Comienzo del método 1");
        try { 
            Thread.sleep (1000) ;
        } catch (InterruptedException ie) { 
            return;
        }
        System.out.println("Fin del método 1") ;
    }

    public synchronized void metodo2 () {  
        System.out.println("Comienzo del método 2"); 
        try {
            Thread.sleep (1000); 
        } catch (InterruptedException ie) {
            return;
        }
        System.out.println("Fin del método 2");
    }

    @Override 
    public void run () {
        metodo1 (); 
        metodo2 ();
    }

    public static void main(String[] args) { 
        E22SincronizacionMetodos sm = new E22SincronizacionMetodos (); 
        new Thread (sm).start ();
        new Thread (sm).start ();
    } 
}

