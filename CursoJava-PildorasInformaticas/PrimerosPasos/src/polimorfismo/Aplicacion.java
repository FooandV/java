package polimorfismo;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Perro firulais= new Perro();
		//firulais.Comunicarse();
		
		/*cuando se utiliza poliformismo trabaja de la siguiente manera:
		 * nota: como Animal es una superclase y es abstracta ya puede ser instanciada
		 * con el hijo osea con el Perro o el Gato*/
		Animal firulais= new Perro();//el objeto firulais de tipo Animal se comporta
									 //en un objeto tipo perro= un perro es un Animal	
		firulais.Comunicarse();//metodo del perro
		System.out.println();
		
		firulais=new Gato(); //ahora el objeto firulais tipo Animal va hacer un gato
		firulais.Comunicarse();//este metodo ahora es del gato
		
		/*Ejemplo si quiero tener un arreglo donde se almacene perros y gatos:*/
		
		Animal arregloAnimales[]=new Animal[4];
		arregloAnimales[0]=new Perro();
		arregloAnimales[1]= firulais;
		arregloAnimales[2]=new Gato();
		
		/*validando que se puede hacer un Animal de tipo perro, pero no se puede hacer
		 * un perro de tipo animal:*/
		Perro dog=(Perro)firulais; /*se hace un casteo de tipo perro*/
	}

}
