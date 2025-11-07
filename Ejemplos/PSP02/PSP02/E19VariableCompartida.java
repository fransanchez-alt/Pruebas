package PSP02;

public class E19VariableCompartida extends Thread {
    private static int contador;

    @Override 
    public void run() {
        for (int i=0;i<1000;i++) { 
            //contador++;
            synchronized (E19VariableCompartida.class) {contador++;}
        }
    }

    public static void main (String[] args) { 
        for (int i=0;i<1000;i++) {
            new E19VariableCompartida() .start ();
        }
        try { 
            Thread.sleep (1000);
        } catch (Exception e) { 
            e.printStackTrace();
        }
        System.out.println("Valor de contador:" + contador) ;
    } 
}