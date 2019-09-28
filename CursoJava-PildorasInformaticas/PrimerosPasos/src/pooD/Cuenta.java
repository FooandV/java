package pooD;



/**
 * @author freyder
 * Este ejercicio comprende una clase llamada cuenta la cual mantiene los saldos de una cuenta bancaria, 
 * el saldo de dichas cuentas se representa no como enteros si no en decimales por lo cual se utiliza float o double
 * para el caso es posible realizar abonos a la cuenta y luego presentarse el saldo al cliente cuando lo solicite.
 */
public class Cuenta {
	
	
	private Double Saldo; //variable de instancia o de clase
	
	public Cuenta(double SaldoIinicial){ //metodo constructor donde se le debe enviar por parametro el saldo inicial de la cuenta y se valida que se >0
		
		if (SaldoIinicial>0.0) {
			
			Saldo=SaldoIinicial;
		}
	}
	
	public void abonar(double monto){//setter
		
		Saldo= Saldo+monto; //suma el monto al saldo
	}
	
	public double obtenerSaldo(){//getter
		
		return Saldo; //retorna lo que contenga Saldo de la cuenta
	}
	
	public void retiro(double montoretiro){ //setter
		
		if (Saldo>montoretiro){
		
			Saldo= Saldo-montoretiro;
			
			System.out.println("Su saldo actual quedo en: " + obtenerSaldo());
			
	     }else{
	    	 System.out.println("El monto de retiro: " + montoretiro + " excede el saldo actual "  + obtenerSaldo());
	     }
	}
	
	
	
}
