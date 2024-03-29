package poo;

public class Ejemplo_Final_Constantes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Empleados trabajador1= new Empleados("Freyder",1); //instanciando un nuevo objeto sobre el constructor que lo esta inicializando
		//Empleados trabajador2= new Empleados("Alejandra",2); //Pasando dos parametros al constructor
		
		Empleados trabajador1= new Empleados("Freyder"); //instanciando un nuevo objeto sobre el constructor que lo esta inicializando
		Empleados trabajador2= new Empleados("ana"); //Pasando parametro al constructor
		Empleados trabajador3= new Empleados("Violetta"); //Pasando parametro al constructor
		Empleados trabajador4= new Empleados("Cecilia"); //Pasando parametro al constructor
		
		
		//System.out.println(trabajador1.getdatos());
		
		trabajador1.setseccion("Desarrollo");//seteando o cambiando la secci�n de los trabajadores que ya no sera "Administraci�n" 
		
		System.out.println(trabajador1.getdatos());
		
		//Empleados.Id++; //se incrementa el valor de la variable static en 1, y como se observa una variable o metodo static debe ser 
						//precedido por la clase, en conclusion una variable statica pertenece a la clase mas no a los objetos y
						//no se puede llamar o instanciar un objeto para llamar una variable static. Mas sin embargo no se sigue 
						//el proceso de encapsulacion porque la variable id es publica, y cada q se cree un objeto se debe llamar
		                //la clase e incrementar la variable Id++ por lo tanto se dio soluci�n creando otra variable static "Idsiguiente"
		System.out.println(trabajador2.getdatos());
		System.out.println(trabajador3.getdatos());
		System.out.println(trabajador4.getdatos());
		//System.out.println(trabajador1.getdatos() + "\n" + trabajador2.getdatos() + "\n " + trabajador3.getdatos() + "\n" + trabajador4.getdatos());
		
		System.out.println( "El Id siguiente es: " + Empleados.getIdSiguiente()); //llamando al metodo estatico 
		
	
				
	}

}

class Empleados{
	
	//declaracion de variables de clase
	
	private final String nombre; //declaracion de variable tipo constante
	private String seccion;
	
    private int Id;         
    
    private static int Idsiguiente=1; //con esta variable los trabajadores tendran un id para todos los objetos, no un id de copia 
    //para cada objeto
    /*en el evento de que sean muchos mas trabajadores y muchos mas objetos instanciados, cada vez que 
	 * creo un trabajador debo saber en que Id voy, o puede pasar que un trabajador pueda tener el mismo id,
	 * para dar soluci�n a ello debo utilizar la palabra reservada "Static"
	 * la cual debe aplicarse a la variable de clase "id" con objeto de que no sea una copia para cada
	 * objeto si no una variable Unica para que todos los objetos la compartan
	 * a diferencia de las otras dos variables de clase que si pueden tomar una copia para cada objeto
	 * nota: pero esta declaraci�n no es correcta porque no estoy llevando el concepto de encapsulacion
	 * porque estoy declarando una variable public: para ello se declara otra variable llamada
	 * private static int Idsiguiente=1 y se deja la variable Id private sin el static, esto
	 * permitira crear objetos y no realizar un incremento por cada objeto creado*/
	
	
	/*
	 * Metodos
	 * 
	 * 
	 * El ejemplo refiere a la creacion de una serie de trabajadores nuevos siempre tendran la seccion "Administration"
	   y con el tiempo se puede cambiar de seccion
	 */
	public Empleados(String nom){ //constructor para inicializar los objetos que se utilicen
		
		nombre=nom;
		seccion= "Administracion";
		Id=Idsiguiente;
		Idsiguiente++; //variable estatica, incrementa en el valor, cada vez que crea un objeto
	}
	
	public void setseccion(String seccion){ //setter donde permite cambiar de seccion si se solicita
		
		this.seccion= seccion; // this apunta a la variable o campo de clase, el otro es el parametro o argumento del metodo
	}
	
	public String getdatos(){ //getter para darnos los datos de cada uno de los trabajadores
		
		return "el nombre del trabajador es: " + nombre + " y la secci�n es: " + seccion + " y el Id= " + Id;
	}
	
	public static String getIdSiguiente(){ //metodo static
		
		return "El IdSiguiente es: " + Idsiguiente;
	}

	
	
	
}

