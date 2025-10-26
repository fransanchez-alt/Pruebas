package PSP02;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E10bLectorEscritorNoSeguro extends Thread {
    private static final int NUM_HILOS = 100;
    private static final List<String> PALABRAS = new ArrayList<>();
    private static final List<Long> DURACIONES_MS = Collections.synchronizedList(new ArrayList<>(NUM_HILOS));

    @Override
    public void run() {
        Instant inicio = Instant.now();
        try {
            PALABRAS.add("Nueva palabra");
            for (String palabra : PALABRAS) {
                PALABRAS.size();
            }
        } finally {
            Instant fin = Instant.now();
            DURACIONES_MS.add(Duration.between(inicio, fin).toMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<E10bLectorEscritorNoSeguro> hilos = new ArrayList<>(NUM_HILOS);
        Instant inicio = Instant.now();

        for (int i = 0; i < NUM_HILOS; i++) {
            E10bLectorEscritorNoSeguro hilo = new E10bLectorEscritorNoSeguro();
            hilos.add(hilo);
            hilo.start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw e;
            }
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
        System.out.println("Tiempo total (hilos): " + totalMs + " ms");
        System.out.printf("Duración media por hilo: %.3f ms%n", promedioMs);
    }
}
