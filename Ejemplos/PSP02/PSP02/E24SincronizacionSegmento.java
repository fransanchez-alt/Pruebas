package PSP02;
public class E24SincronizacionSegmento extends Thread {
    int id; 
    static Object bloqueol = new Object () ; 
    static Object bloqueo2 = new Object () ;

    public E24SincronizacionSegmento (int id) { 
        this.id = id;
    }

    public void metodo1() { 
        synchronized (bloqueol) {
            System.out.println("Comienzo del método 1 del hilo " + id) ; 
            try {
                Thread.sleep (1000); 
            } catch (InterruptedException ie) {
                return;
            }
            System.out.println("Fin del método 1 del hilo " + id);
        }
    }

    public void metodo2 () { 
        synchronized (bloqueo2) {
            System.out.println ("Comienzo del método 2 del hilo " + id) ; 
            try { 
                Thread.sleep (1000);
            } catch (InterruptedException ie) { 
                return;
            }
            System.out.println("Fin del método 2 del hilo " + id);
        }
    }

    @Override 
    public void run() {
        if (id==1) { 
            metodo1 (); 
            metodo2 ();
        } else { 
            metodo2 (); 
            metodo1 () ;
        }
    }

    public static void main(String[] args) { 
        E24SincronizacionSegmento s1 = new E24SincronizacionSegmento (1);
        E24SincronizacionSegmento s2 = new E24SincronizacionSegmento (2);
        new Thread(s1).start ();
        new Thread(s2).start ();
    } 
}

