package clases_propias;

public class Jefe extends Empleado{
	
	public Jefe(String nombre, int edad, double salario) {//constructor
		// TODO Auto-generated constructor stub
	
		super(nombre, edad, salario);//se llama al constructor de la clase padre=Empleado y se le pasan los 
		//argumentos del constructor de jefe
	}
	double getincentivo(double inc){
		
		return inc;
	}
}
