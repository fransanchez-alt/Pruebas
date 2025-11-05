package PSP02;

import java.util.concurrent.Exchanger;

public class E10Intercambiador {

    public static void main(String[] args) { 
        Exchanger<String > exchanger = new Exchanger<String> () ;

        new Thread (new E10aTareaA(exchanger) ) .start () ;
        new Thread (new E10bTareaB (exchanger) ) .start () ;
    }
}
