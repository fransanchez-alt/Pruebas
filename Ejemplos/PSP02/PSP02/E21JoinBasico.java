package PSP02;
public class E21JoinBasico extends Thread {
    private int id; 
    private boolean esperar = false; 
    private Thread hiloReferencia; 
    
    public E21JoinBasico (int id) {
        this.id=id;
    }

    public void esperarA (Thread hiloReferencia) { 
        this.esperar=true; 
        this.hiloReferencia=hiloReferencia;
    }

    @Override 
    public void run() {
        try { 
            for (int i=0;i<3;i++) {
                /*if (esperar) { 
                    hiloReferencia.join();
                }*/
                System.out.printf("Hilo %d. Iteración %d %n", id, i) ;
                Thread.sleep (1000) ;
            } 
        } catch (Exception e) { 
            e.printStackTrace () ;
        }
    }

    public static void main(String[] args) {
        E21JoinBasico hilo1 = new E21JoinBasico (1) ;
        E21JoinBasico hilo2 = new E21JoinBasico (2) ; 
        hilo1. start (); 
        hilo2.start (); 
        hilo2.esperarA(hilo1); // hilo2 esperará a hilo1
    } 
}

