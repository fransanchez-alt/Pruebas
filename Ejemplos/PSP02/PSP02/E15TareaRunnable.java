package PSP02;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class E15TareaRunnable implements Runnable { 
    private int numero;
    private int divisor = -1; 

    public E15TareaRunnable (int numero) { 
        this.numero = numero;
    }

    public int getDivisor() { 
        return divisor;
    }

    @Override 
    public void run () {
        try { 
            Thread.sleep (3000) ;
            for (int i=numero-1; i>1; i--) {
                if (numero%i==0) { 
                    divisor=i; 
                    break;
                }
            } 
        } catch (Exception e) { 
            e.printStackTrace (); 
        }
    }

    public static void main(String[] args) { 
        try { 
            E15TareaRunnable tr = new E15TareaRunnable (11) ;
            ExecutorService servicioEjecucion = Executors.newSingleThreadExecutor();
            Future resultado = servicioEjecucion.submit (tr) ; 
            while (!resultado.isDone()) {
                System.out.println ("Esperando..."); 
                Thread.sleep(1000);
            }
            if (tr.getDivisor () != -1) { 
                System.out.println("El número es divisible entre " + tr.getDivisor()); 
            } else { 
                System.out.println("El número es primo");
            }
            servicioEjecucion.shutdown () ; 
        } catch (Exception e) { 
            System.err.println (e.getMessage ()) ; 
        }
    } 
}