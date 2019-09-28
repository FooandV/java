package pooD;

import java.util.Scanner;

/**
 * @author freyder
 *
 *Este es un ejemplo de POO donde se tiene un metodo con parametro, con una variable de instancia 
  variable o parametro enviado al metodo) 
 *que luego es llamaddo o ejecutado por el main PruebaLibroCalificaciones.java.
 *
 */
/*class LibroCalificaciones {	
	 
	public void mostrarMensaje(String nombreDelcurso){
		
		System.out.printf("Bienvenido al libro de calificaciones para \n%s!\n", nombreDelcurso);
	}
 	 
}*/

/**
 * @author freyder el problema se puede sustentar utilizando la variable de
 *         instancia=variable llamada desde metodos getter y setter dado el caso
 */

class LibroCalificaciones {

	private String nombreDelCurso;
	private String nombreDelInstructor;

	/*
	 * enviando parametros al constructor para que inicialice el objeto que sea
	 * llamado
	 */
	public LibroCalificaciones(String nombreDelCurso, String nombreDelInstructor) {

		this.nombreDelCurso = nombreDelCurso;
		this.nombreDelInstructor = nombreDelInstructor;
	}

	// metodos getter y setter

	public void setNombreDelCurso(String nombreDelCurso) {

		this.nombreDelCurso = nombreDelCurso;
	}

	public String getNombreDelCurso() {
		return nombreDelCurso;
	}

	public void setNobreInstructor(String nombreDelInstructor) {// setter

		this.nombreDelInstructor = nombreDelInstructor;
	}

	public String getNombreIstructor() {// getter

		return nombreDelInstructor;

	}

	/*
	 * Metodo set mostrarMensaje que llama a el metodo "getNombreDelCurso" para
	 * obtener el nombre del curso que representa la clase LibroCalificaciones
	 */
	public void mostrarMensaje(String nombreDelcurso, String nombreInstructor) {

		System.out.printf(" Bienvenido al libro de calificaciones para \n%s!\n ",
				getNombreDelCurso() + " y el instructor que lo impartira es: " + getNombreIstructor());
	}

	/*
	 * metodo SET que determina el promedio de la clase, con base en las 10
	 * calificaciones introducidas por el usuario
	 */
	public void setPromedioClase() {
		// **********variables
		// locales***************************************************
		
		int total; // suma de las calificaciones introducidas por el usuario
		int contadorCalif; // contador de calificaciones al introducirla
		int calificacion;// valor de la calificacion escrita por el usuario
		int promedio; // El promedio de las calificaciones
		// ********************************************************************************
		Scanner entrada = new Scanner(System.in); // crea objeto para introducir
		// por consola
		// fase de inicialización
		total = 0; // inicializa el total
		contadorCalif = 1;// inicializa el contador del ciclo

		while (contadorCalif <= 10) { // while que itera 10 veces

			System.out.println("Escriba la calificación:  ");// indicador
			calificacion = entrada.nextInt(); // lee la calificación del usuario
			total = total + calificacion;// suma calificación al total
			contadorCalif++;// incrementa contador en 1
		}
		promedio = total / 10; // la division entera produce un resultado entero

		System.out.printf(" \nEl total de las 10 calificaciones es %d\n ", total);
		System.out.printf(" \nEl promedio de la clase es %d\n", promedio);

	}

}
