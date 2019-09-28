package poo;

import java.util.*;



/**
 * @author freyder
 * Ejercicio para aprender como se define y funcionan las clases y metodos abstractos
 * en conclusion las clases abstractas son las que definen el diseño de la herencia
 */
public class Uso_Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona[] lasPersonas=new Persona[2]; //array de tipo Persona
		lasPersonas[0]= new Empleado2("freyder", 50000, 2009, 02, 25);/*instanciando un objeto con param tipo Empleado2 en el
		 																array tipo Persona*/
		lasPersonas[1]=new Alumno("Violetta", "Medicina");/*instanciando un objeto tipo Alumno y enviandolo al array
		 													tipo persona*/
		/*se realiza un for each para recorrer el array*/
		
		for (Persona p: lasPersonas){
			
			System.out.println(p.getNombre() + ", " + p.getDescripcion()); /*imprimiendo en consola el nombre y la descripcion
			 																que corresponde de cada clase*/
		}  
	}
		
}		
		
		
		/**
		 * clase abtracta Persona
		 */
abstract class Persona { // deficion de una clase abstracta ya que tiene
							// un metodo abstracto

	private String nombre;// declaracion de variables

	/********************************************************* metodos********************************************** */
	
	public Persona(String nom) {// contructor clase padre

		nombre = nom;
	}

	public String getNombre() {// gett

		return nombre;
	}

	public abstract String getDescripcion(); // metodo abstracto que
												// deben tener todas las
												// subclases y debe
												// sobreescribirse
}
	/******************************************************************************************************************/

/**
 * clase Empleado2
 */
 class Empleado2 extends Persona {

	/*
	 * variables de clase, que deben ser solo modificadas utilizando los
	 * metodos correspondientes, este caso el metodo constructor
	 */
	private double sueldo;
	private Date altaContrato; // variable de clase Date donde se hace
	// necesario
	// importar el paquete java.util
	private int id;
	private static int idsiguiente ; // con esta variable los
	// trabajadores
	// tendran un id para todos los
	// objetos,
	// no un id de copia;

	/**************************************** Metodos ******************************************************************/

	public Empleado2(String nom, double sue, int agno, int mes,int dia) { /*
						 * metodo constructor1 recibiendo parametros o
						 * argumentos
						 */
		super(nom);// incovando al constructo de la clase padre y
					// enviando el parametro q pide

		sueldo = sue;

		GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia); // creando
		// objeto
		// calendario

		altaContrato = calendario.getTime(); // llamando el metodo para
		// que me
		// devuelva la fecha de
		// calendario que se
		// asigno
		++idsiguiente;
		id = idsiguiente++; // variable estatica, incrementa en el
		// valor, cada
		// vez que crea un objeto

	}

	// getter y setters

	public String getDescripcion() {//metodo abstracto
		
		return "Este empleado tiene un Id=" + id + " con un sueldo=" + sueldo;
	}

	public double getSueldo() { // getter

		return sueldo;
	}

	public Date getFechaContrato() { // getter

		return altaContrato;
	}

	public void setSubeSueldo(double porcentaje) {

		double aumento = sueldo * porcentaje / 100;

		sueldo += aumento;

	}

	public String getdatos() { // getter para darnos los datos de cada
		// uno de
		// los trabajadores

		return "el nombre del trabajador es: " + " y el Id= " + id;
	}

	public static String getIdSiguiente() { // metodo static

		return "El IdSiguiente es: " + idsiguiente;
	}
/******************************************************************************************************************/
}

/**
 * clase Alumno
 */
class Alumno extends Persona{
	/*declaracion de variables de clase*/
	private String carrera;
	
	
/**************************************** Metodos ******************************************************************/
	public Alumno(String nom, String car){ //metodo contructor donde se le pasara el nombre del alumno y la carrera
		
		super(nom); /*como estamos heradando de la clase persona lo primero que se debe de hacer es llamar
			        al constructor de la clase padre o super clase y se le pasa el parametro que se le este
			        dando al constructor de la clase Alumno al crear la instancia u obojeto*/
		carrera=car;
	}
	
	public String getDescripcion(){ //metodo abstracto
		
		return "Este alumno está estudiando la carrera de" + " " + carrera;
	}
/******************************************************************************************************************/	
	
}

	
