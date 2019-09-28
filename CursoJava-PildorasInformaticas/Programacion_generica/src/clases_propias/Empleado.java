package clases_propias;

public class Empleado {
	
	public Empleado(String nombre, int edad, double salario) {/* constructor */

		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}

	public String getdameDatos() {
		return "el empleado se llama: " + nombre + ", tiene " + edad + " años. " + " Y  un salario de: " + salario;
	}

	private String nombre;
	private int edad;
	private double salario;

}
