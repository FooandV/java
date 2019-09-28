import java.util.*;
public class Enteros_MayorMenor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada= new Scanner(System.in);
		
		int numero1;
		int numero2;
		int numero3;
		int numero4;
		int numero5;
		
		System.out.println("digite el primer entero: ");
		numero1= entrada.nextInt();
		
		System.out.println("digite el segundo entero: ");
		numero2= entrada.nextInt();
		
		System.out.println("digite el tercer entero: ");
		numero3= entrada.nextInt();
		
		System.out.println("digite el cuarto entero: ");
		numero4= entrada.nextInt();
		
		System.out.println("digite el quinto entero: ");
		numero5= entrada.nextInt();
		
		if (numero1 > numero2 && numero1>numero3 && numero1>numero4 && numero1>numero5) {
			System.out.println("El numero: " + numero1 +  " es el mayor del grupo de numeros");
		}
		else if (numero2 > numero1 && numero2>numero3 && numero2>numero4 && numero2>numero5){
			System.out.println("El numero: " + numero2 +  " es el mayor del grupo de numeros");
		}
		else if (numero3 > numero1 && numero3>numero2 && numero3>numero4 && numero3>numero5){
			System.out.println("El numero: " + numero3 +  " es el mayor del grupo de numeros");
		}
		else if (numero4 > numero1 && numero4>numero2 && numero4>numero3 && numero4>numero5){
			System.out.println("El numero: " + numero4 +  " es el mayor del grupo de numeros");
		}
		else if (numero5 > numero1 && numero5>numero2 && numero5>numero3 && numero5>numero4){
			System.out.println("El numero: " + numero5 +  " es el mayor del grupo de numeros");
		}
		

	}

}
