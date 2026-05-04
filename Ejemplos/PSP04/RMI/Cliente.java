import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    private ICalculadora calculadora;

    public Cliente() {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 5555);

            calculadora = (ICalculadora) registro.lookup("Calculadora");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Cliente cliente = new Cliente();

        try {
            int resultado = cliente.calculadora.sumar(3, 20);
            System.out.println(resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}