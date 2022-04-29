
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {

    public static void main(String args[]) {
        Cliente cliente = new Cliente();
    }

    public Cliente() {
        System.setProperty("java.rmi.server.codebase", "file://C:/Users/raque/OneDrive/Escritorio/ING.TELECO/SEGUNDO_CUATRI/DESARROLLO_DE_APLICACIONES_EN_RED/P3_RMI/Cliente2/app/build/classes/java/main");
        System.setProperty("java.security.policy", "file://C:/Users/raque/OneDrive/Escritorio/ING.TELECO/SEGUNDO_CUATRI/DESARROLLO_DE_APLICACIONES_EN_RED/P3_RMI/Cliente2/server.policy");
        try {
            String registroURL = "rmi://localhost:1099/calculator";
            
            // invocar ahora el metodo remoto
            InterfazCalculadora calculadora = (InterfazCalculadora) Naming.lookup(registroURL); // Busca el servidor en la URL que le pasamos               

            calculator.cabecera();
            
            boolean salir = false;
            Scanner conin = new Scanner(System.in);

            while (!salir) {
                salir = calculator.resultado(conin, calculadora);
            }

        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
