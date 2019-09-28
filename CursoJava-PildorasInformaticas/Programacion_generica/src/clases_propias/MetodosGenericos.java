package clases_propias;

import java.util.GregorianCalendar;

public class MetodosGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombres[]={"Freyder", "Violetta", "Adriana"};/*creacion de un array*/
		
		/**se le pasa al metodo genérico el array creado por parametros, para que nos devuelva la longitud:*/
		String elementos= MisMatrices.getElementos(nombres);
		System.out.println(elementos);
		
		/********************creando array de tipo Empleado:*******************************************/
		Empleado misEmpleados[]={
				new Empleado("Freyder", 35, 5000000),
				new Empleado("Carolina", 32, 4500000),
				new Empleado("Violetta", 3, 1000000),
				new Empleado("Eliana", 25, 3000000),
				new Empleado("Marcela", 28, 2000000)
		};
		
		System.out.println(MisMatrices.getElementos(misEmpleados));/*se esta imprimiendo un array de elementos de tipo Empleado,
		como se observa el metodo genérico permite adaptarse a cualquier tipo de objeto*/
		/***********************************************************************************************/
		/**************validacion del metodo genérico:  T getMenor(T[]a) ********************************************************************/
		
		System.out.println(MisMatrices.getMenor(nombres));/*debe de imprimir "Adriana ya que es el elemento menor del array"*/
		
		GregorianCalendar fechas[]={new GregorianCalendar(2018, 01, 21),
									new GregorianCalendar(2017, 03, 21),
									new GregorianCalendar(2015, 02, 21),};
		System.out.println(MisMatrices.getMenor(fechas).getTime());
	}

}

/**Esta clase contiene  metodos genérico*/
class MisMatrices{
	
	/**
	 * Este metodo genérico va devolver un String, una cadena de texto que nos
	 * va decir la longitud que tiene un array que le pasemos por parametro a el
	 * metodo genérico: .es un metodo 
	 * public= para que sea accesible desde otras clases 
	 * .static= para convertirlo en un metodo de clase y de esta forma no
	 * necesitar una instancia perteneciente a la clase MisMatrices .
	 * <T>= tiene especificado el argumento de tipo .String= es el tipo de dato que va
	 * devolver el metodo . 
	 * getElementos= el nombre del metodo
	 * .(T[]a)=argumentos del metodo, como se le va pasar un array genérico, en
	 * principio no sabemos de que tipo va hacer, si sera de String, fechas,
	 * empleados, etc.Entonces se utiliza el argumento de tipo
	 */
	
	public static <T> String getElementos(T[]a){
		
		return "El array tiene: " + a.length + " elementos";
		
	}
	
	
	/**Los metodos genéricos pueden encontrarse con problemas, derivados de que podemos pasarle por argumento un objeto de cualquier tipo y eso
	 * acarrea problemas, igualmente esto tambien tiene solucion:
	 * este metodo genérico lo que va hacer es decirnos en el array que se le pase por argumentos cual es el elemento menor ordenado por orden
	 * alfabetico: {"Freyder", "Violetta", "Adriana"} debe decir que el elemento menor es "Adriana"
	 * <T> va recibir un argumento de tipo
	 * T (dato genérico que  va devolver) porque va retornar el elemento del array que sea menor, si se le pasa un String debe retornar un String,
	 * si se le pasa un Date debe devolver un Date, si se pasa un Empleado debe devolver un Empleado)
	 * extends Comparable<T>, ya que el metodo compareTo() obliga a implementar la interfaz "Comparable", lo cual indica que todos los argumentos
	 * que se le pasen a este metodo generico tengan que ser objetos que implementen la interfaz comparable*/
	
	public static<T extends Comparable<T>> T getMenor(T[]a){
		if(a==null|| a.length==0){/*si el array que se le paso por parametro esta vacio, o tiene una longitud de 0 que no devuelva nada*/
			return null;
		}
		
		/**variable para almacenar el elemento menor del array*/
		T elementoMenor=a[0];
		
		for (int i=1; i<a.length; i++){/*se empieza a rrecorrer el array desde la posicion 1 y no desde la 0 ya que la posicion 0 ya esta almacenada
		en elementoMenor*/
			if(elementoMenor.compareTo(a[i])>0){/*el metodo compareTo() pertenece a la interfaz Comparable*/
				elementoMenor=a[i];
			}
		}
		return elementoMenor;
		
	}

	
}