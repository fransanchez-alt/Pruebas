package PSP02;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class E11LectorEscritorSeguro extends Thread {
    private static List<String> palabras = new CopyOnWriteArrayList<String>();

    @Override 
    public void run() {
        palabras.add (new String ("Nueva palabra"));
        palabras.size ();
        System.out.println(palabras.size());
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            new E11LectorEscritorSeguro() .start ();
        }
    }
}

