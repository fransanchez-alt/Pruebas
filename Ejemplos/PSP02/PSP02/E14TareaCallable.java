package PSP02;
import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.Future;

public class E14TareaCallable implements Callable< Integer> { 
    private int numero;

    public E14TareaCallable (int numero) { 
        this.numero = numero;
    }

    @Override 
    public Integer call() throws Exception {
        Thread.sleep (3000) ; 
        for (int i=numero-1;i>1;i--) {
            if (numero%i==0) { 
                return i;
            }
        }
        throw new Exception ("El número es primo");
    }

    public static void main(String[] args) {
        try {
            E14TareaCallable ec = new E14TareaCallable (21) ; 
            ExecutorService servicioEjecucion = Executors.newSingleThreadExecutor(); 
            Future< Integer> resultado = servicioEjecucion.submit (ec); 
            while (!resultado.isDone()) {
                System.out.println("Esperando..."); 
                Thread.sleep (1000) ;
            }
            System.out.println("El número es divisible entre " + resultado.get ()); 
            servicioEjecucion.shutdown ();
        } catch (Exception e) { 
            System.err.println(e.getMessage ());
        }
    }
}