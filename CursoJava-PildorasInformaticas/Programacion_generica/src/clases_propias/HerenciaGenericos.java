package clases_propias;

public class HerenciaGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Empleado Administrativa=new Empleado("Freyder", 35, 4500000);
//		Jefe DirectoraComercial= new Jefe("Ana", 27, 3500000);
//		
//		Empleado nuevoEmpleado=DirectoraComercial; //herencia en funcionamiento, principio de sustitucion
		
		/**trabajando con clases genéricas:*/
		Pareja<Empleado> Administrativa=new Pareja<Empleado>();
		
		Pareja<Jefe> DirectoraComercial=new Pareja<Jefe>();
		
		/*aplicando principio de sustitucion no va funcionar:*/
		
		//Pareja<Empleado> nuevoEmpleado=DirectoraComercial;
		
		Pareja.imprimirTrabajador(Administrativa);
	
		Pareja.imprimirTrabajador(DirectoraComercial);
	}

}
