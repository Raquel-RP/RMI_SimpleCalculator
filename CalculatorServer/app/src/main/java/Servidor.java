
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
	
        public static void main(String args[]) {
            Servidor servidor = new Servidor();
	}
        
        @SuppressWarnings("CallToPrintStackTrace")
        
	public Servidor () {

                System.setProperty("java.rmi.server.hostname","localhost");
                System.setProperty("java.rmi.server.codebase","file://C:/Users/raque/OneDrive/Escritorio/ING.TELECO/SEGUNDO_CUATRI/DESARROLLO_DE_APLICACIONES_EN_RED/P3_RMI/Servidor2/app/build/classes/java/main");
		System.setProperty("java.security.policy","file://C:/Users/raque/OneDrive/Escritorio/ING.TELECO/SEGUNDO_CUATRI/DESARROLLO_DE_APLICACIONES_EN_RED/P3_RMI/Servidor2/server.policy");

                try {
                    Registry registry = LocateRegistry.getRegistry(1099);
                    System.out.println("No valid RMI register in port 1099");
                    registry = LocateRegistry.createRegistry(1099);
                    System.out.println("RMI register created in port 1099");
               } catch (RemoteException ex) {
                    System.out.println("RMI register not created");
                }

                if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());  }	  
                
		try {
			// se registra el objeto como stub
			InterfazCalculadora objExportado = (InterfazCalculadora) new ImplementCalculadora();
			//se crea el stub dinamicamente y se asocia al puerto 0
			InterfazCalculadora stub = (InterfazCalculadora) UnicastRemoteObject.exportObject(objExportado,0);
			//se registra stub en el servidor RMI
			Registry registry = LocateRegistry.getRegistry(); // Puerto por defecto 1099
			//para registrarlo o sustituirlo
			registry.rebind("calculator", stub);
		} catch (RemoteException e) {e.printStackTrace(); System.exit(0);}
		System.out.println("Calculator server ready.");
	}

    }
        