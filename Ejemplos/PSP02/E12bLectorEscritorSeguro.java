package PSP02;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class E12bLectorEscritorSeguro extends Thread {
    private static final int NUM_HILOS = 100;
    private static final List<String> PALABRAS = new CopyOnWriteArrayList<>();
    private static final List<Long> DURACIONES_MS = new ArrayList<>(NUM_HILOS);

    @Override
    public void run() {
        Instant inicio = Instant.now();
        PALABRAS.add("Nueva palabra");
        PALABRAS.size();
        Instant fin = Instant.now();
        synchronized (DURACIONES_MS) {
            DURACIONES_MS.add(Duration.between(inicio, fin).toMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<E12bLectorEscritorSeguro> hilos = new ArrayList<>(NUM_HILOS);
        Instant inicio = Instant.now();

        for (int i = 0; i < NUM_HILOS; i++) {
            E12bLectorEscritorSeguro hilo = new E12bLectorEscritorSeguro();
            hilos.add(hilo);
            hilo.start();
        }

        for (Thread hilo : hilos) {
            hilo.join();
        }

        Instant fin = Instant.now();
        long totalMs = Duration.between(inicio, fin).toMillis();

        double promedioMs;
        synchronized (DURACIONES_MS) {
            promedioMs = DURACIONES_MS.stream()
                    .mapToLong(Long::longValue)
                    .average()
                    .orElse(0.0);
        }

        System.out.println("Palabras almacenadas: " + PALABRAS.size());
        System.out.println("Tiempo total: " + totalMs + " ms");
        System.out.printf("Duración media por hilo: %.3f ms%n", promedioMs);
    }
}
