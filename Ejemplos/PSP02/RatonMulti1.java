package PSP02;

public class RatonMulti1 implements Runnable {
    private String nombre;
    private int tiempoAlimentacion;

    public RatonMulti1 (String nombre, int tiempoAlimentacion) {
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
        RatonMulti1 fievel = new RatonMulti1 ("Fievel", 4) ;
        RatonMulti1 jerry = new RatonMulti1("Jerry", 5) ;
        RatonMulti1 pinky = new RatonMulti1("Pinky", 3);
        RatonMulti1 mickey = new RatonMulti1("Mickey", 6) ;
        new Thread (fievel) .start ();
        new Thread (jerry) .start () ;
        new Thread (pinky) .start ();
        new Thread (mickey) .start ();
    }
}