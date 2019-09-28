package serializacion;

import java.util.*;
import java.io.*;


/**
 * @author freyder: este ejercicio representa la serializacion de objetos, dando lugar a generar un flujo de datos con la clase
 * ObjectOutputStream y escribiendo un objeto en un lugar externo con el metodo writeObject(), de la misma manera se emula un receptor para rescatar
 * el objeto de donde fue escrito bajo la clase  ObjectInputStream y leyendolo con el metodo:readObject() 
 * El ejercicio presenta un serialVersionUID el cual es un SHA(El SHA (Secure Hash Algorithm) el cual es una huella que represanta la clase 
 * serializada para que puede ser leida por otros recepteres por si es cambiado su codigo.
 *plñ{d{´ñl
 */
public class Serializando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Administrador jefe= new Administrador("Freyder", 80000, 205, 12, 15);
		
		jefe.setIncentivo(5000);
		
		Empleado[]personal=new Empleado[3];/*este sera el objeto que se va serializar*/
		
		personal[0]=jefe;
		personal[1]=new Empleado("Ana",25000, 2008, 10, 1);
		personal[2]=new Empleado("Luis",18000, 2012, 9, 15);
		
		try{
			/*EMISOR:*/
			/*con esto creamos el flujo de datos de salida por el que va viajar el objeto hacia el exterior :*/
//			ObjectOutputStream escribiendo_fichero=new ObjectOutputStream(new FileOutputStream("C:/Users/freyder/Desktop/java_ser/empleado.dat")); 
			
//			escribiendo_fichero.writeObject(personal);/*crea o escribe el objeto de bytes especificado y lo transmite por el ObjectOutputStream*/
//			escribiendo_fichero.close();/*se cierra el flujo*/
			
			/*RECEPTOR:*/
			/*ahora vamos a rescatar ese objeto:*/
			ObjectInputStream recuperando_fichero=new ObjectInputStream(new FileInputStream("C:/Users/freyder/Desktop/java_ser/empleado.dat"));/*con 
			esto se crea el flujo de datos de entrada*/
			Empleado[]personal_recuperado=(Empleado[])recuperando_fichero.readObject();/*como el objeto que se va recuperar(leer) es un array, este debe
			ser almacenado en un array, el metodo readObject()=retorna un objeto mas no un array por eso hay q hacer el casting y se pone el array
			Empleado[] para que el dato recuperado tipo object sea leido como un array*/
			recuperando_fichero.close();
			
			/*se utilizara el bucle para ir recorriendo el array que se acabo de recuperar y lo imprima pon consola*/
			for(Empleado e: personal_recuperado){
				System.out.println(e);
			}
		}catch(Exception e){
			
		}

	}

}
//---------------------------------------------------------------------------------------------
class Empleado implements Serializable{
	
	/**
	 * huella SHA serialversionUID
	 */
	private static final long serialVersionUID = 1L;/*constante que permite tener un registro o huella de la clase serializada para que pueda
	ser leida por futuros receptores aun con o sin cambios sobre dicha clase*/
	public Empleado(String n, double s, int agno, int mes, int dia){
		
		nombre=n;
		sueldo=s;
		
		GregorianCalendar calendario=new GregorianCalendar(agno, mes-1,dia);
		fechaContrato= calendario.getTime();
	}
	
	public String getNombre(){
		return nombre;
	}
	public double getSueldo(){
		return sueldo;
	}
	public Date getFechaContrato(){
		return fechaContrato;
	}
	
	public void subirSueldo(double porcentaje){
		double aumento=sueldo*porcentaje/100;
		sueldo+=aumento;
	}
	
	public String toString(){/*el metodo toString() se utiliza para especificar una descripsion de nuestra clase
	es como pasar a texto que hace nuestra clase*/
		return "El Nombre=" + nombre + ", sueldo= " + sueldo + ", fecha de contrato= " + fechaContrato;
	}
	
	private String nombre;
	private double sueldo;
	private Date fechaContrato;
	
}
//-----------------------------------------------------------------------------------------------
class Administrador extends Empleado{

	/**
	 * huella SHA serialversionUID
	 */
	private static final long serialVersionUID = 1L;/*constante que permitira tener una huella de la clase*/

	public Administrador(String n, double s, int agno, int mes, int dia){
		super(n,s,agno,mes,dia);
		
		incentivo=0;
	}
	public double getSueldo(){
		double sueldoBase=super.getSueldo();
		return sueldoBase + incentivo;
	}
	public void setIncentivo(double b){
		incentivo=b;
	}
	public String toString(){
		return super.toString() + "Incentivo= " + incentivo;
	}
	
	private double incentivo;
}

