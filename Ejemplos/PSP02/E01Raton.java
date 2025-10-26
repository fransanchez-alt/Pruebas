package PSP02;

public class E01Raton {
    private String nombre;
    private int tiempoAlimentacion;

    public E01Raton(String nombre, int tiempoAlimentacion) {
        super () ;
        this.nombre = nombre;
        this. tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer () {
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
            Thread. sleep(tiempoAlimentacion * 1000);
            System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre) ;
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public static void main(String[] args) {
        E01Raton fievel = new E01Raton ("Fievel", 4) ;
        E01Raton jerry = new E01Raton ("Jerry", 5) ;
        E01Raton pinky = new E01Raton ("Pinky", 3) ;
        E01Raton mickey = new E01Raton ("Mickey", 6) ;
        fievel.comer();
        jerry.comer();
        pinky.comer();
        mickey.comer();
    }
}
