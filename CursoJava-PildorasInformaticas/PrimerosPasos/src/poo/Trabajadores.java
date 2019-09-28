package poo;

/**
 * @author freyder
 * esta interfaz se desarrollo pensando en que este programa es de una empresa en concreto, y esa empresa en concreto
 * tiene por costumbre dar una bonificación en diciembre para todos los trabajadores: Empleados y Jefes es decir
 * afecta las dos clases de la jerarquia de herencia : clase Empleado y clase Jefatura
 * todas aquellas clases que implementen la interfaz "Trabajadores" se ven obligadas a desarrollar el metodo: establece_bonus
 * Se establece que el bonus que se le dara a cada trabajador tiene q tener un limite o un minimo
 * por ello se define una constante en la interface
 */
public interface Trabajadores {
	
	public abstract double establece_bonus(double gratificacion); /*metodo public y abstract no son obligatorios java ya lo sabe*/

	public static final double bonus_base=1500;/*constante static= todas las constantes de las interfaces son
	public,static y final*/
}
