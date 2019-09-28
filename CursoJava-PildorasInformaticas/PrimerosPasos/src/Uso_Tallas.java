import java.util.*;

 /**
 * @author freyder
 * tema: TIPOS ENUMERADOS CLASE ENUM
 * nos permite crear objetos enumerados de la clase ENUM
 * muchas veces surge la necesidad de almacenar en una variable una serie de valores
 * pero no queremos que en esa variable se pueda almacenar en un futuro valores
 * un determinado numero de valores o tipo de valores,
 * con la clase enum de la API podemos almacenar un determinado tipo de valores
 * y luego trabajar con ellos instanciando a traves de un objeto.
 * los tipos enumerados tambien permiten la programaciòn de getter y setters, esto se 
 * observa en el codigo2
 */

public class Uso_Tallas {
	
	/*codigo1 para ejemplarizar la declaraciòn de una varia objeto "enum" y como puede
	  ser instanciada*/
	/*enum Talla{MINI,MEDIANO,GRANDE,MUY_GRANDE};*/ /*se debe declarar fuera del medoto main
	 											como si fuera una instancia, enum es una clase
	 											de la api de java y a continuacion el nombre 
	 											perteneciente a esta clase, dentro de las llaves
	 											poner los valores que se pueden almacenar dentro
	 											de esa variable separados por coma*/
	/*codigo2*/
	
	enum Talla{
		MINI("S"),MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");/*declarando los valores que
		admite el tipo enumerado "enum" llamado talla, es decir los parametros
		que se le pasaran como abreviatura al constructor*/
		
		
		private Talla(String abreviatura){/*metodo constructor y debe ser private, ya que
		una de las caracteristicas de los tipos "enum"(enumerados) es que no admiten
		la creaciòn de objetos, es decir no se puede invocar a un constructor creando
		una instancia enumerada, es decir no se admite instanciar con el operador New*/
			this.abreviatura= abreviatura;
		}
		public String getAbreviatura(){//metodo getter
			return abreviatura;
		}
		
		
		private String abreviatura;//declaracion de variable de clase
		
		
	}
	
	public static void main(String[] args) {
		
		/*código1 para ejemplarizar como se instancia una variable objeto "enum"*/
		//Talla s=Talla.MINI; /*instanciando una variable objeto de tipo "talla"*/
		//Talla m=Talla.MEDIANO; /*instanciando una variable objeto de tipo "talla"*/
		//Talla l=Talla.GRANDE; /*instanciando una variable objeto de tipo "talla"*/
		//Talla xl=Talla.MUY_GRANDE; /*instanciando una variable objeto de tipo "talla"*/
	
		Scanner entrada= new Scanner(System.in);
		System.out.println("Escribe una talla: MINI, MEDIANO, GRANDE, MUY_GRANDE");/*imprimiendo
		mensaje que debe salirle al usuario*/
		
		String entrada_datos=entrada.next().toUpperCase();/*pasando a mayusculas lo que el
		usuario pueda introducir por consola, si introduce mini pasarlo a MINI...*/
		
		/*se declara una variable de tipo "Talla", luego se utiliza el metodo valueof de 
		 * la clase Enum, que devuelve nombre de la constante enumerada a la que pertenece 
		 * el texto introducido que fue almacenado en entrada_datos :*/
		 Talla la_talla=Enum.valueOf(Talla.class, entrada_datos);
		
		 
		 System.out.println("Talla:" + la_talla);
		 System.out.println("Abreviatura=" + la_talla.getAbreviatura());
	}

}
