
import java.rmi.RemoteException;

public class ImplementCalculadora implements InterfazCalculadora {

    public ImplementCalculadora() throws RemoteException {
    }
    
    @Override
    public double add(double param1, double param2) {
        double resultado;
        resultado = param1 + param2;
        return resultado;
    }

    @Override
    public double sub(double param1, double param2) {
        double resultado;
        resultado = param1 - param2;
        return resultado;
    }

    @Override
    public double mul(double param1, double param2) {
        double resultado;
        resultado = param1 * param2;
        return resultado;
    }

    @Override
    public double div(double param1, double param2) {
        double resultado;
        resultado = param1 / param2;
        return resultado;
    }   
}
