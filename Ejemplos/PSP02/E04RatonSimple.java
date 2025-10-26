package PSP02;

public class E04RatonSimple implements Runnable {
    private String nombre;
    private int tiempoAlimentacion;
    private int alimentoConsumido;

    public E04RatonSimple (String nombre, int tiempoAlimentacion) {
        super ();
        this.nombre = nombre ;
        this. tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer () {
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
            Thread. sleep (tiempoAlimentacion * 1000) ;
            alimentoConsumido++;
            System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
            System.out.printf ("Alimento consumido: %d%n", alimentoConsumido);
        } catch (InterruptedException e) {
            e.printStackTrace () ;
        }
    }

    @Override
    public void run() {
        this.comer ();
    }

    public static void main(String[] args) {
        E04RatonSimple fievel = new E04RatonSimple ("Fievel", 4);
        /*new Thread (fievel) .start ();
        new Thread (fievel) . start ();
        new Thread (fievel) .start ();
        new Thread (fievel) .start () ;
*/
        for (int i = 0; i < 100; i++) {
        new Thread(fievel).start ();
        }
    }
}


