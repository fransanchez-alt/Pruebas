package PSP01;
public class MostrarNombre {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Debes proporcionar un nombre como argumento.");
            System.exit(1);
        }
        System.out.println("El nombre recibido es: " + args[0]);
    }
}
