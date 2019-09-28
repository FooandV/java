package excepciones_I;

import javax.swing.JOptionPane;


/**
 * @author freyder: este ejercicio se estudiaran las excepciones donde se crearan varias y seran capturadas por varios catch,
 * nota: no hay manera de abreviar los catch, hay que poner 1 de tras de otro.
 *
 */
public class Varias_Excepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			division();
		}catch (ArithmeticException e){
			System.out.println("No se puede divir por 0");
		}catch(NumberFormatException e){
			System.out.println("No haz introducido un numero entero");
			
//			System.out.println(e.getMessage()); este metodo captura el mensaje introducido por el usuario y lo muestra en consola
			System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
		}
		
	}
	
	
	static void division(){
		int num1= Integer.parseInt(JOptionPane.showInputDialog("Indroduce el dividendo"));
		int num2= Integer.parseInt(JOptionPane.showInputDialog("Indroduce el divisor"));
	
		System.out.println("El resultado es: " + num1/num2);
	}

}

