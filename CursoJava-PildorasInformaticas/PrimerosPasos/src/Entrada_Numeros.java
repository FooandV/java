import javax.swing.JOptionPane;


/*ejemplo de raiz cuadrara de un numero ingresando el valor por medio de una ventana*/
/*se utliza el metodo parseDouble de la clase "Double"con objeto de transformar lo que este 
 * almacenado el el String ingresado en la entrada de datos de la clase: JOptionPane con metodo showInputDialog*/
 

public class Entrada_Numeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String num1=JOptionPane.showInputDialog("Introduce un numero");
		
		double num2=Double.parseDouble(num1);
		
		System.out.print("la raiz cuadrada de " + num2 + " es ");
		
		System.out.printf("%1.2f" , Math.sqrt(num2)); //* la linea 20 estamos formateando el valor del resultado 
													  //de que se encuentra en num2 con 2 decimales

	}

}
