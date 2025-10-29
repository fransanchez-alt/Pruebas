package PSP02;

import java.util.ArrayList;
import java.util.List;

public class E11aLectorEscritorNoSeguro extends Thread {
    private static List<String> palabras = new ArrayList<String>() ;

    @Override 
    public void run () {
        palabras.add (new String ("Nueva palabra"));
        for (String palabra : palabras) {
            palabras.size();
        }
        System.out.println(palabras.size());
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++) {
            new E11aLectorEscritorNoSeguro () .start () ;
        }
    }
}
