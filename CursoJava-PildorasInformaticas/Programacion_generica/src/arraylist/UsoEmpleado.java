package arraylist;
import java.util.*;

public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Empleado listaEmpleados[]=new Empleado[3];
//		listaEmpleados[0]=new Empleado("Freyder", 35, 5000000);
//		listaEmpleados[1]=new Empleado("Violetta", 3, 500000);
//		listaEmpleados[2]=new Empleado("Maria", 25, 3000000);
		
		/*utlizando arrayList:*/
		ArrayList<Empleado> listaEmpleados= new ArrayList<Empleado>();
		
		/*importante: si es utilizado el constructor por defecto del ArrayList: ArrayList() segun la API informa:
		  que este tiene una capacidad de 10 elementos, si son creados mas no genera error pero lo que hace es
		  consumir mas recursos, mas reserva de espacio en memoria, ya que interiormente se crea un arraylist de 
		  mas elementos y elimina la primer  copia, por lo cual es importante definirle la capacidad del arraylist 
		  con el metodo: ensureCapacity() **/
//		listaEmpleados.ensureCapacity(11);
		
		/*para ir almacenando objetos en un ArrayList se debe utilizar el metodo add q esta en la API*/
		listaEmpleados.add(new Empleado("Freyder", 35, 5000000));
		listaEmpleados.add(new Empleado("Violetta", 3, 500000));
		listaEmpleados.add(new Empleado("Maria", 25, 3000000));
		
		listaEmpleados.add(new Empleado("Maria", 25, 3000000));
		listaEmpleados.add(new Empleado("Maria", 25, 3000000));
		listaEmpleados.add(new Empleado("Freyder", 35, 5000000));
		listaEmpleados.add(new Empleado("Violetta", 3, 500000));
		listaEmpleados.add(new Empleado("Maria", 25, 3000000));
		listaEmpleados.add(new Empleado("Maria", 25, 3000000));
		listaEmpleados.add(new Empleado("Maria", 25, 3000000));
		listaEmpleados.add(new Empleado("Pedro", 22, 4500000));
		listaEmpleados.add(new Empleado("Pedro", 22, 4500000));
		listaEmpleados.add(new Empleado("Pedro", 22, 4500000));
		
		
		/*si se esta seguro de que no se agregaran mas elementos al ArrayList:*/
//		listaEmpleados.trimToSize();/*esto corta el exceso en memoria*/
		listaEmpleados.add(new Empleado("Juan", 22, 4500000));
		listaEmpleados.add(new Empleado("Olga", 22, 4500000));
		
		/*si es necesario insertar en cualquier otro lugar en el ArrayList se utiliza el metodo get*/
//		listaEmpleados.set(1, new Empleado("Sara", 30, 1500000));
		/*si se quiere obtener la información de un objeto en especifico del ArrayList:*/
//		System.out.println(listaEmpleados.get(0).getdameDatos());
		
//		System.out.println(listaEmpleados.size());
		/****************rrecorriendo con foreach*****************************************************************************************/	
		/*rrecorriendo el arraylist con un bucle foreach*/
//		for(Empleado e: listaEmpleados){
//			System.out.println(e.getdameDatos());
//		}
		
		/*****************rrecorriendo con un Iterator****************************************************************************************/	
		/*recorriendo el ArrayList a travez de un iterador=Iterator*/
		Iterator<Empleado> mi_iterador=listaEmpleados.iterator();    /*encargado de recorrer elemento a elemento la coleccion del ArrayList y se
		le especifica el tipo de elemento el cual es "Empleado"*/
		
		while(mi_iterador.hasNext()){/*el metodo hasNext() nos dice si tenemos mas objetos dentro de la coleccion*/
			System.out.println(mi_iterador.next().getdameDatos());/*el metodo next()recorre la coleccion de objetos*/
		}
		
		
		/*********************rrecorriendo con bucle normal**********************************************************************************/		
		/*recorriendo el ArrayList con un bucle normal, cabe destacar que el ArrayList no tiene indices*/
//		for(int i=0; i<listaEmpleados.size(); i++){
			/*se crea una variable objeto de tipo Empleado*/
//			Empleado e=listaEmpleados.get(i);//se va almacenando dentro de la variable objeto e todos los elementos
			//que vaya encontrando al recorrer el arraylist normal para cada vuelta de bucle
			
//			System.out.println(e.getdameDatos());
//		}
	
		/**********************copiando objetos del ArrayList a un Array normal***********************************************************************************/	
//		para las personas que esten acostumbradas a manejar un array y se les dificulte usar el ArrayList y 
//		rrecorrerlo con un foreach o bucle normal for se puede	realizar lo siguiente:
		
		/*copiar lo que se tiene en el ArrayList en una array convencional:*/
		
//		Empleado arrayEmpleados[]=new Empleado[listaEmpleados.size()];/*la dimension del array normal debe
//		coincidir con la dimencion del ArrayList para poder traspasar los elementos de un lado al otro:*/
//		
//		listaEmpleados.toArray(arrayEmpleados);/*con este metodo lo que conseguimos es copiar lo que tenemos en el ArrayList
//		al array: arrayEmpleados[]*/
//		
//		for(int i=0; i<arrayEmpleados.length; i++){
//			System.out.println(arrayEmpleados[i].getdameDatos());
//		}
	}

}

class Empleado{
	
	public Empleado(String nombre, int edad, double salario){/*constructor*/
		
		this.nombre=nombre;
		this.edad=edad;
		this.salario= salario;
	}
	
	public String getdameDatos(){
		return "el empleado se llama: " + nombre + ", tiene " + edad + " años. " + " Y  un salario de: " + salario;
	}
	
	private String nombre;
	private int edad;
	private double salario;
}
