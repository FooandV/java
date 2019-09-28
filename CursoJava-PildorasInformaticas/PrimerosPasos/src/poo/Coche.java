package poo;

public class Coche {

	private int ruedas;

	private int largo;

	private int ancho;

	private int peso_plataforma;

	private String color;

	private int peso_total;

	boolean asientos_cuero, climatizador;

	/*
	 * metodo constructor= inicializa la clase, tiene el mismo nombre de la
	 * clase
	 */

	public Coche() {
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		// motor=1600;
		peso_plataforma = 500;
	}

	public String getLargo() {// metodo getter
		return "El largo del coche es: " + largo;
	}

	/*
	 * Si quiero traer todos los atributos o propiedades generales de la clase:
	 * ruedas,largo,ancho,motor; pes_plataforma:
	 */
	
	public String get_datos_generales() {
		return "La plataforma del vehiculo tiene " + ruedas + " ruedas " + ".Mide " + (largo / 1000)
				+ " metros, con un ancho de " + ancho + " cm y un peso de la plataforma de " + peso_plataforma + " kg";
	}

	// metodo setter, se manda parametro declarando una variable para que cuando
	// se instancie un objeto
	// se ponga el parametro que se necesite.

	public void setcolor(String color_coche) {

		color = color_coche;
	}

	public String getcolor() {

		return "El color del coche es: " + color;
	}

	/*
	 * Como se puede observar el argumento= variable de la clase por lo cual se
	 * hace necesario el operador: this
	 */

	public void set_configura_asientos(String asientos_cuero) {

		if (asientos_cuero.equalsIgnoreCase("si")){

			this.asientos_cuero = true;
		} else {
			this.asientos_cuero = false;
		}
	}

	public String get_asientos_cuero() {

		if (asientos_cuero == true) {

			return "El coche tiene asientos de cuero";
		} else {

			return "El coche tiene asientos de serie";
		}
	}

	public void set_aire_acondicionado(String climatizador) {

		if (climatizador.equalsIgnoreCase("si")) {

			this.climatizador = true;

		} else {

			this.climatizador = false;
		}
	}

	public String get_aire_acondicionado() {

		if (climatizador == true) {

			return "El carro  tiene aire acondicionado";
		} else {

			return "el carro no tiene aire acondicionado";
		}
	}

	/* Metodo Get y Set juntos= no aconcejado */

	public String dime_peso_coche() {

		int peso_carroceria = 500; // variable que solo se puede ver dentro de
									// este metodo

		peso_total = peso_plataforma + peso_carroceria; //estoy seteando una variable de la clase

		if (asientos_cuero == true) {

			peso_total = peso_total + 50;
		}
		if (climatizador == true) {

			peso_total = peso_total + 20; //seteando o asignando valor a variable de clase
		}

		return "el peso total del carro es: " + peso_total;

	}

	public int get_precio_coche() { // metodo GETTER

		int precio_final = 10000;

		if (asientos_cuero == true) {

			precio_final += 2000;
		}

		if (climatizador == true) {

			precio_final += 1500;
		}

		return precio_final;

	}

}
