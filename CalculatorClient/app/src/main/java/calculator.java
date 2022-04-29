
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Raquel Romero Pedraza
 * 
 */
public class calculator {

    /**
     * Cabecera de la calculadora 
     */
    public static void cabecera() {
        System.out.println();
        System.out.println("*************************************************");
        System.out.println();
        System.out.println("               SIMPLE CALCULATOR");
        System.out.println();
        System.out.println("*************************************************");
        System.out.println();
        System.out.println("Press 1:SUM 2:SUBS 3:PRODUCT 4:DIVISION 0:EXIT");
        System.out.println("*************************************************");
    }

    /**
     * 
     * @param x
     * @param y
     * @param entrada
     * @return 
     */
    public static int menuCalculadora(double x, double y, Scanner entrada) {
        int operacion;
        boolean valido = true;

        System.out.println();
        System.out.println("Insert operation: ");

        operacion = entrada.nextInt();

        switch (operacion) {
            case 0:
                System.out.println("Exiting calculator...");
                break;
            case 1:
                System.out.println("Sum operation");
                break;
            case 2:
                System.out.println("Subtraction operation");
                break;
            case 3:
                System.out.println("Product operation");
                break;
            case 4:
                System.out.println("Division operation");
                break;
            default:
                valido = false;
        }

        if (!valido) {
            System.out.println("Invalid operation.");
            operacion = 5;
        }

        return operacion;
    }

    /**
     * 
     * @param operacion
     * @param param1
     * @param param2
     * @param calculator
     * @return
     * @throws RemoteException 
     */
    public static double mandarOperacion(int operacion, double param1, double param2, InterfazCalculadora calculator) throws RemoteException {
        double resultado = 0.0;

        switch (operacion) {

            case 1:
                resultado = calculator.add(param1, param2);
                break;
            case 2:
                resultado = calculator.sub(param1, param2);
                break;
            case 3:
                resultado = calculator.mul(param1, param2);
                break;
            case 4:
                resultado = calculator.div(param1, param2);
                break;
        }

        return resultado;
    }

    /**
     *
     * @param conin
     * @param calculadora
     * @return
     * @throws RemoteException
     */
    public static boolean resultado(Scanner entrada, InterfazCalculadora calculatorInterface) throws RemoteException {
        double x = 0.0, y = 0.0, resultado;
        int operacion;
        boolean salir = false;

        operacion = calculator.menuCalculadora(x, y, entrada);

        if (operacion != 5 && operacion != 0) {
            System.out.println("Insert x: ");
            x = entrada.nextDouble();
            System.out.println("Insert y: ");
            y = entrada.nextDouble();

            resultado = calculator.mandarOperacion(operacion, x, y, calculatorInterface);
            System.out.println("Result: " + resultado);
        } else if (operacion == 0) {
            salir = true;
        }
        
        return salir;
    }
}

