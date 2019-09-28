package pooD;

import java.util.Scanner;

public class PruebaLibroCalificaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Ejecutando con metodo constructor sin parametros*/
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba el nombre del curso");
		String nombreDelcurso= entrada.nextLine(); //se observa que la variable declarada es = al argumento de instancia
		System.out.println(); //salto de linea
		System.out.println("Escriba el nombre del instructor");
		String nombreDelInstructor= entrada.nextLine(); //se observa que la variable declarada es = al argumento de instancia
		
		LibroCalificaciones miLibroCalificaciones= new LibroCalificaciones(nombreDelcurso, nombreDelInstructor); //llamando constructor sin parametros
		miLibroCalificaciones.setNombreDelCurso(nombreDelcurso); 
		miLibroCalificaciones.setNobreInstructor(nombreDelInstructor); 
		miLibroCalificaciones.mostrarMensaje(nombreDelcurso,nombreDelInstructor);
		
		miLibroCalificaciones.setPromedioClase();
		
		
		//LibroCalificaciones miLibroCalificaciones= new LibroCalificaciones(); //llamando constructor sin parametros
		
		//System.out.println("Escriba el nombre del curso");
				//String nombreDelcurso= entrada.nextLine(); //se observa que la variable declarada es = al argumento de instancia
				//System.out.println(); //salto de linea
				//miLibroCalificaciones.setNombreDelCurso(nombreDelcurso); 
				//miLibroCalificaciones.mostrarMensaje(nombreDelcurso);

		//llamando constructor con  parametros
		//LibroCalificaciones miLibroCalificaciones= new LibroCalificaciones("aprendiendo full java","freyder"); 
		//LibroCalificaciones miLibroCalificaciones2= new LibroCalificaciones("aprendiendo a conocerme","Violetta"); 
		
		
		//System.out.printf("el nombre del curso libro calificaciones es: %s\n", miLibroCalificaciones.getNombreDelCurso()  + " y su instructor sera: " + miLibroCalificaciones.getNombreIstructor() );
		//System.out.printf("el nombre del curso libro calificaciones es: %s\n", miLibroCalificaciones2.getNombreDelCurso());
		
	}

}
