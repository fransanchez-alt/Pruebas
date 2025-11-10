package PSP02;
public class E20WaitNotifySimple implements Runnable { 
    private volatile boolean ejecutandoMetodo1=false; 
    
    public synchronized void metodo1 () {
        for(int i=0;i<10;i++) { 
            System.out.printf ("Ejecución %d%n",i); 
            if (i==5) {
                try { 
                    this.wait ();
                } catch (InterruptedException e) { 
                    e.printStackTrace () ;
                }
            }
        }
    }

    public synchronized void metodo2 () { 
        for (int i=10;i<20;i++) {
            System.out.printf ("Ejecución %d%n", i);
        }
        this.notifyAll();
    }

    @Override 
    public void run () {
        if (!ejecutandoMetodo1) { 
            ejecutandoMetodo1=true; 
            metodo1 () ;
        } else {
            metodo2 () ;
        }
    }

    public static void main (String[] args) { 
        E20WaitNotifySimple wns = new  E20WaitNotifySimple (); 
        new Thread (wns) . start () ;
        new Thread (wns) . start ();
    }
}
