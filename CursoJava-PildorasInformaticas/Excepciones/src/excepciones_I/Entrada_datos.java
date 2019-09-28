package excepciones_I;
import java.util.*;
public class Entrada_datos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("¿Qué deseas hacer?");
		System.out.println("1. Introducir datos");
		System.out.println("2. Salir del programa");
		
		Scanner entrada=new Scanner (System.in);
		
		int decision=entrada.nextInt();
		
		if (decision==1){
			
			try{
				pedirDatos();
			}catch(InputMismatchException e){
				System.out.println("Que demonios has introducido en la edad?");
			}
		}else{
			
			System.out.println("Adios");
			
			System.exit(0);
		}
		
		entrada.close();
		
	}
	
		static void pedirDatos() throws InputMismatchException    {	/*el throws lanza la excepcion y no se esta obligado
		a capturarla, pero para el caso vamos a capturarla con un try-catch*/		
		
//		try{	
			Scanner entrada=new Scanner(System.in);
			
			System.out.println("Introduce tu nombre, por favor");
			
			String nombre_usuario=entrada.nextLine();
			
			System.out.println("Introduce edad, por favor");
			
			int edad=entrada.nextInt(1);	
				
			System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad+1) + " años");
			
			entrada.close();
//		  }catch(InputMismatchException e){/*al capturar la excepcion debe ser la misma que se lanza en la declaración del metodo
//		  o que este por encima de la herencia*/
//			  System.out.println("Que demonios has introducido en la edad?");
//		  }
		System.out.println("Hemos terminado");
		
	}
		
		
}