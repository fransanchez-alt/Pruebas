package PSP02;

import java.util.Timer;
import java.util.TimerTask;

public class E06SistemaRiego extends TimerTask{
    @Override 
    public void run() {
        System.out.println ("Regando...");
    }

    public static void main(String[] args) {
        Timer temporizador = new Timer ();
        temporizador.schedule(new E06SistemaRiego(), 1000, 2000);
    }
}