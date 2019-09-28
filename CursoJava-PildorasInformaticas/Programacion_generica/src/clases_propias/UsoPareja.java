package clases_propias;

public class UsoPareja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * se instancia la clase pareja que es genérica y entre corchetes <tipo
		 * de objeto> que va manejar:
		 */
		Pareja<String> una = new Pareja<String>();

		/**
		 * Nota importante: cuando se instancia una clase genérica de algun
		 * tipo, este tipo de objeto se adapta a los objetos, metodos futuros
		 * que vayan a ser utilizados
		 */

		una.setPrimero("Freyder");/* esto quiere decir que primero="Freyder" */
		System.out.println(una.getPrimero());
		
		Persona pers1=new Persona("Ana");/*se instancia un objeto de la clase Persona*/
		
		Pareja<Persona> otra=new Pareja<Persona>();
		
		otra.setPrimero(pers1);
		
		System.out.println(otra.getPrimero());
		
	}

}

class Persona {

	public Persona(String nombre) {

		this.nombre = nombre;
	}
	public String toString(){
		
		return nombre;
		
	}
	

	private String nombre;

}
