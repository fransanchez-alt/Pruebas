package PSP02;
public class E17InterrupcionBasico extends Thread {

    @Override 
    public void run() {
        int contador=0; 
        while (true) {
            contador++; 
            try {
                System.out.println(contador); 
                if (contador==3) {
                    this.interrupt ();
                }
                // Tras activar el flag de interrupción, se lanza 
                //la excepción y el último sleep no se completa porque lo interrumpe
                Thread.sleep (1000) ; 
            } catch (InterruptedException ie) {
                System.out.println("El hilo ha sido interrumpido");
                ie.printStackTrace();
                return;
            }
        }
    }

    public static void main (String[] args) {
        new E17InterrupcionBasico ().start ();
    } 
}
