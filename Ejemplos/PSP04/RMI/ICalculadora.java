import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadora extends Remote {

    int sumar(int o1, int o2) throws RemoteException;

    int restar(int o1, int o2) throws RemoteException;

    int multiplicar(int o1, int o2) throws RemoteException;

    int dividir(int o1, int o2) throws RemoteException;
}
