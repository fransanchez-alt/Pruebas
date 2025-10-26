package PSP02;

public class E02RatonConcurrente extends Thread {
    private String nombre;
    private int tiempoAlimentacion;

    public E02RatonConcurrente (String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre) ;
            Thread.sleep (tiempoAlimentacion * 1000);
            System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.comer();
    }

    public static void main(String[] args) {
        E02RatonConcurrente fievel = new E02RatonConcurrente("Fievel", 4);
        E02RatonConcurrente jerry = new E02RatonConcurrente ("Jerry", 5);
        E02RatonConcurrente pinky = new E02RatonConcurrente ("Pinky", 3);
        E02RatonConcurrente mickey = new E02RatonConcurrente ("Mickey", 6);
        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
    }
}
