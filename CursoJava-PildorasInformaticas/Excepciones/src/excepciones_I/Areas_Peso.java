package excepciones_I;
import java.util.Scanner;
import javax.swing.*;


/**
 * @author freyder: .
 * esta clase nos averigua las areas de diferentes figuras geometrcias: cuadraro, rectangulo,Triángulo, Círculo
 * también nos averigua el peso ideal de una persona en función  de su altura
 *	 El ejercicio evidencias como se utiliza la instruccion finally, captura la posible excepcion dado el caso se introduzca texto en la 
 * entrada del Scanner pero continua el funcionamiento para la otra parte del codigo que es la del peso de la persona.
 */
public class Areas_Peso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada= new Scanner(System.in);
		
		System.out.println("Elige una opción: \n1: Cuadrado \n2: Rectángulo: \n3: Triángulo \n4: Círculo");
		try{
		figura=entrada.nextInt();
		
//		entrada.close();//con esta instruccion cerramos la entrada que se abrio con Scanner
		}catch(Exception e){
			System.out.println("Ha ocurrido un error");
		}finally{//lo que ocurra dentro de la instrucción finally se va ejecutar siempre, tanto si se lanza la excepcion como si no se lanza
			entrada.close();
		}
		
		
		
		switch (figura) {
		case 1:
			
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			
			System.out.println("El área del cuadrado es " + Math.pow(lado, 2));
			
			break;
		
		case 2:
			
			int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			
			int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			
			System.out.println("El área del Rectángulo es " + base*altura);
			
			break;	
			
		case 3:
			
			 base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			
			 altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			
			System.out.println("El área del Triángulo es " + (base*altura)/2);
			
			break;	
			
		case 4:
			
			 int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
			
			 System.out.print("El área del circulo es ");
			 
			 System.out.printf("%1.2f", Math.PI*(Math.pow(radio, 2)));
			
			break;	
			
		default:
		 System.out.println("La opción no es correcta");
		}
		
		//*************************************************************************************************
		
		try{
			int altura= Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));
			System.out.println("Si eres hombre tu peso ideal es: " + (altura-110) + " kg");
			System.out.println("Si eres mujer tu peso ideal es: " + (altura-120) + " kg");
		}catch(NumberFormatException e){
			System.out.println("error no haz introducido valor numericos");
		}
			
		}
	static int figura;

}
