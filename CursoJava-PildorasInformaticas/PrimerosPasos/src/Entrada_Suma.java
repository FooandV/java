import java.util.*;

public class Entrada_Suma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		int numero1, numero2, resultado;
		
		System.out.println("Introdusca el primer numero:");
		numero1= entrada.nextInt();
		
		System.out.println("Introduzca el segundo numero:");
		numero2= entrada.nextInt();
		
		 resultado = numero1+numero2;
		
		System.out.println(" el resultado de la suma es: " + resultado);
		

	}

}
