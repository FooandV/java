package pooD;

import java.util.Scanner;

public class PruebaCuenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cuenta cuenta1 = new Cuenta(50.00); // Crea objeto1
		//Cuenta cuenta2 = new Cuenta(30.53); // Crea objeto2
		// muestra el saldo inicial de cada objeto
		System.out.printf("El saldo de la cuenta1 es: $%.2f\n", cuenta1.obtenerSaldo());
		//System.out.printf("El saldo de la cuenta1 es: $%.2f\n\n", cuenta2.obtenerSaldo());

		Scanner entrada = new Scanner(System.in); // crea objeto scanner para
													// ingresar informaciòn por
													// la consola
		double montoDeposito; // variable donde se almacena el deposito escrito
								// por el usuario
		double montoretiro;

		System.out.print("Escriba el monto a depositar en la cuenta1: ");
		montoDeposito = entrada.nextDouble();// obtiene la entrada del usuario
		System.out.printf("\n sumando %.2f al saldo de cuenta1\n\n", montoDeposito);
		cuenta1.abonar(montoDeposito); // suma al saldo de la cuenta1

		// muestra los saldos de cuenta1 y cuenta2
		System.out.printf("El saldo de la cuenta1 es: $%.2f\n", cuenta1.obtenerSaldo());
		//System.out.printf("El saldo de la cuenta2 es: $%.2f\n\n", cuenta2.obtenerSaldo());

		//System.out.print("Escriba el monto a depositar en la cuenta2: ");
		//montoDeposito = entrada.nextDouble();// obtiene la entrada del usuario
		//System.out.printf("\n sumando %.2f al saldo de cuenta2\n\n", montoDeposito);
		//cuenta2.abonar(montoDeposito); // suma al saldo de la cuenta2

		// muestra los saldos de cuenta1 y cuenta2
		//System.out.printf("El saldo de la cuenta1 es: $%.2f\n", cuenta1.obtenerSaldo());
		//System.out.printf("El saldo de la cuenta2 es: $%.2f\n\n", cuenta2.obtenerSaldo());

		// retiros cuenta1
		System.out.print("Escriba el monto de retiro en la cuenta1: ");
		montoretiro = entrada.nextDouble();// obtiene la entrada del usuario
		System.out.printf("\n restando %.2f al saldo de cuenta1\n\n", montoretiro);
		cuenta1.retiro(montoretiro);

		// muestra los saldos de cuenta1 y cuenta2
		System.out.printf("El saldo de la cuenta1 es: $%.2f\n", cuenta1.obtenerSaldo());
		//System.out.printf("El saldo de la cuenta2 es: $%.2f\n\n", cuenta2.obtenerSaldo());
		
		//retiros cuenta2
		//System.out.print("Escriba el monto de retiro de la cuenta2: ");
		//montoretiro = entrada.nextDouble();// obtiene la entrada del usuario
		//System.out.printf("\n restando %.2f al saldo de cuenta2\n\n", montoDeposito);
		//cuenta2.retiro(montoretiro);; // suma al saldo de la cuenta2
		
		// muestra los saldos de cuenta1 y cuenta2
		System.out.printf("El saldo de la cuenta1 es: $%.2f\n", cuenta1.obtenerSaldo());
		//System.out.printf("El saldo de la cuenta2 es: $%.2f\n\n", cuenta2.obtenerSaldo());

	}

}
