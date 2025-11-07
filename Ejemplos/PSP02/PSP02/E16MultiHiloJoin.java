package PSP02;
public class E16MultiHiloJoin extends Thread {
    private String nombre;
    private int tiempoAlimentacion;

    public E16MultiHiloJoin(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    @Override
    public void run() {
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            System.out.println("El ratón " + nombre + " ha terminado de alimentarse");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        E16MultiHiloJoin fievel = new E16MultiHiloJoin("Fievel", 4);
        E16MultiHiloJoin jerry = new E16MultiHiloJoin("Jerry", 4);
        E16MultiHiloJoin pinky = new E16MultiHiloJoin("Pinky", 4);
        E16MultiHiloJoin mickey = new E16MultiHiloJoin("Mickey", 4);

        fievel.start(); jerry.start(); pinky.start(); mickey.start();
        fievel.setPriority(Thread.MIN_PRIORITY);
        mickey.setPriority(Thread.MAX_PRIORITY);
        if (fievel.isAlive() || jerry.isAlive() || pinky.isAlive() || mickey.isAlive()) {
            System.out.println("Los ratones están comiendo");
        }
        /*try {fievel.join(); jerry.join(); pinky.join(); mickey.join();          
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Los ratones han terminado de comer");        
    }
}
