

/*
 * Utilizando la clase Math con el metodo (round) 
 * llevando como parametro un double, donde retorna un long
 * y se realiza una refundicion para que 
 * convierta el resultado a un entero y pueda almacenarce en variable
 * de tipo entero int
 */
public class Calculos_conMath3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double num1=5.85;
		
		int resultado=(int) Math.round(num1);  
		
		System.out.println(resultado);

	}

}