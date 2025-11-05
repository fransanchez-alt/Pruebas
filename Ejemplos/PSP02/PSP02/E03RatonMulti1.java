package PSP02;

public class E03RatonMulti1 implements Runnable {
    private String nombre;
    private int tiempoAlimentacion;

    public E03RatonMulti1 (String nombre, int tiempoAlimentacion) {
        super ();
        this.nombre = nombre;
        this. tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer () {
        try{
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre) ;
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    @Override
    public void run() {
        this.comer ();
    }

    public static void main(String[] args) {
        E03RatonMulti1 fievel = new E03RatonMulti1 ("Fievel", 4) ;
        E03RatonMulti1 jerry = new E03RatonMulti1("Jerry", 5) ;
        E03RatonMulti1 pinky = new E03RatonMulti1("Pinky", 3);
        E03RatonMulti1 mickey = new E03RatonMulti1("Mickey", 6) ;
        new Thread (fievel) .start ();
        new Thread (jerry) .start () ;
        new Thread (pinky) .start ();
        new Thread (mickey) .start ();
    }
}