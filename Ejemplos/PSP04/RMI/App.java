import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class App {

    public static void registrarCalculadora() {

        try {
            Registry registro = LocateRegistry.createRegistry(5556);

            Calculadora calculadora = new Calculadora();

            ICalculadora stub = (ICalculadora)
                    UnicastRemoteObject.exportObject(calculadora, 0);

            registro.bind("Calculadora", stub);

            System.out.println("Servidor arrancado...");
            
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        registrarCalculadora();
    }
}
