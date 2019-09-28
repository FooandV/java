package clases_propias;

/**
 * @author freyder
 *en este ejemplo se crearan clases genéricas
 * @param <T>
 */

/**entre corchetes angulares esta especificado el parametro de tipo<>, por convenio
las letras mas utilizadas son en Mayusculas y estas son las letras T, U, K*/
public class Pareja<T> {

	public Pareja(){/*constructor lo unico que hace es dar un estado inicial al campo de clase*/
		primero=null;
	}
	
	/**metodo setter para cambiar el valor del campo de clase*/
	public void setPrimero(T nuevoValor){/**tiene un argumento genérico*/
		primero=nuevoValor;
	}
	/**creando un metodo con un comodin, es decir que este metodo que utiliza como parametro una clase generico con tipo <Empleado> y cualquiera de las
	 * subclases que pudiera tener la  clase Empleado, ejemplo: jefes, consejeros, estudiantes, etc; :
	 * public para que sea accesible
	 * static para que sea de clase
	 * void porque no retorna nada
	 * (Pareja<? extends Empleado> p)= recibe por parametro un objeto de Pareja concretamente de tipo <Empleado> el cual se llama p
	 * Nota: cabe destacar que se esta utilizando un comodin: (Pareja<? extends Empleado>) esto quiere decir que puede recibir un tipo Empleado o
	 * cualquier subclase perteneciente a la clase Empleado
	 * */
	public static void imprimirTrabajador(Pareja<? extends Empleado> p){
		Empleado primero=p.getPrimero();
		System.out.println(primero);
	}
	
	/**metodo getter en cargado de devolvernos el objeto que estemos manejando en cada ocación*/
	public T getPrimero(){/*se le indica que es T ya q nos va devolver un objeto de tipo genérico*/
		return primero;
	}
	
	/**campo con argumento de tipo genérico T*/
	private T primero;
}
