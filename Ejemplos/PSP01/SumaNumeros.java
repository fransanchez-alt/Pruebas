package PSP01;
import java.util.Scanner;

/**
 * Lee dos números desde stdin, verifica que sean numéricos y muestra la suma.
 */
public class SumaNumeros {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Introduce el primer número: ");
            if (!sc.hasNextDouble()) {
                System.err.println("Error: el primer valor no es numérico.");
                System.exit(1);
            }
            double numero1 = sc.nextDouble();

            System.out.print("Introduce el segundo número: ");
            if (!sc.hasNextDouble()) {
                System.err.println("Error: el segundo valor no es numérico.");
                System.exit(2);
            }
            double numero2 = sc.nextDouble();

            double suma = numero1 + numero2;
            System.out.println("La suma es: " + suma);
        }
    }
}
