package poo;

public interface Jefes extends Trabajadores {/*Jerarquia de interface: Jefes hereda de Trabajadores, es decir que
aquellas clases que implementen la interface "Jefes" estan obligadas a implementar los metodos de Jefes y Traajadores*/
	
	public abstract String tomar_decisiones(String decision);/*los metodos de las interfaces siempre son abstractos y 
	publicos*/

}
