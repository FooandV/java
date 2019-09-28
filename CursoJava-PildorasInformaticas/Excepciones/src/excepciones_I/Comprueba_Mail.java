package excepciones_I;

import java.io.EOFException;

import javax.swing.JOptionPane;

public class Comprueba_Mail {

	public static void main(String[] args) {

		String el_mail = JOptionPane.showInputDialog("Introduce Mail");
		try{
		examina_mail(el_mail);
		}catch (Exception e){
			System.out.println("La direcci�n de email no es correcta");
			e.printStackTrace();/*imprime la pila de llamada del error*/
		}
	}

//	static void examina_mail(String mail) throws ArrayIndexOutOfBoundsException{
//	static void examina_mail(String mail) throws EOFException{/*como se puso a que se lance una excepcion controlada es necesario declarar 
	//un bloque try-catch para capturar la excepcion
	static void examina_mail(String mail) throws Longitud_mail_erronea { /*realizando captura de una excepcion propia creada Longitud_mail_erronea
	la cual extiende de la excepcion generica: Exception y obliga a capturarse dentro de un bloque try-catch*/
		int arroba = 0;
		boolean punto = false;

		/*
		 * se va generar un error implicito para que lanze una excepcion y luego
		 * sea capturada, pero dicha excepcion sera lanzada como un
		 * checkException o excepcion comprobada para el caso si el mail tiene
		 * un string <3 caracteres lanzara un error capturado por un objeto
		 * excepcion, como no se sabe en la API de java una excepcion que se
		 * adapte a un String demasiado corto, entonces se utilizara una
		 * excepcion conocida aunque no se adapte o no tenga sentido, solo se
		 * har� para conocer la clausula throw
		 */
		if (mail.length() <= 3) {
			/*
			 * se realiza la instanciacion de la clase
			 * ArrayIndexOutOfBoundsException
			 */
			//ArrayIndexOutOfBoundsException mi_excepcion = new ArrayIndexOutOfBoundsException();
			// luego se lanza una excepcion de forma manual:
//			throw new ArrayIndexOutOfBoundsException();
			throw new Longitud_mail_erronea("EL mail es demasiado corto");
		}else{

				for (int i = 0; i < mail.length(); i++) {
		
					if (mail.charAt(i) == '@') {
		
						arroba++;
					}
					if (mail.charAt(i) == '.') {
		
						punto = true;
					}
				}
					if (arroba == 1 && punto == true) {
			
						System.out.println("Es correcto el Mail");
					} else {
			
						System.out.println("No es correcto el Mail");
					}
			  }
	}
	
}
class Longitud_mail_erronea extends Exception{
	
	public Longitud_mail_erronea(){}
	public Longitud_mail_erronea(String msg_error){
		super(msg_error);
	}
}
