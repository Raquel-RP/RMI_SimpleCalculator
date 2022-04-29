
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazCalculadora extends Remote {

    public double add(double param1, double param2) throws RemoteException;

    public double sub(double param1, double param2) throws RemoteException;

    public double mul(double param1, double param2) throws RemoteException;

    public double div(double param1, double param2) throws RemoteException;

}
