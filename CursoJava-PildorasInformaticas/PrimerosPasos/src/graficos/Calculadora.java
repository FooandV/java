package graficos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCalculadora mimarco= new MarcoCalculadora();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}
class MarcoCalculadora extends JFrame{
	
	public MarcoCalculadora(){
		setTitle("Calculadora");
		setBounds(500, 300, 450, 300);/*con esto se le daposicion y tamaño a la calculadora*/
		
		LaminaCalculadora milamina= new LaminaCalculadora();
		add(milamina);
		//pack();/*este metodo permite darle un tamaño por defecto a los elementos del contenedor*/
	}
}

/*agradando una lamina1:*/
class LaminaCalculadora extends JPanel{
	
	public LaminaCalculadora(){//constructor
		
		principio=true;
		setLayout(new BorderLayout());
		
		pantalla= new JButton("0");/*pantalla viene siendo el display*/
		pantalla.setEnabled(false);/*con esto estamos dejando desabilitado el boton*/
		
		add(pantalla,BorderLayout.NORTH);
		/*vamos a crear una segunda lamina:*/
		/*creamos una instancia perteneciente a JPanel:*/
		milamina2= new JPanel();
		/*se indica que esta lamina tiene una disposición de gridLayout:*/
		milamina2.setLayout(new GridLayout(4,4));/*se crea una instancia del objeto GridLayout seteandolo con setLayout sobre la lamina y luego
		se le dice cuantas filas y columnas va tener el grid*/
		/*se setean los botones en la lamina2*/
		
		/*se crea una instancia a la clase perteneciente insertaNumero:*/
		ActionListener insertar=new InsertaNumero(); 
		/*creando una instancia respecto AccionOrden para pasarla por parametro a ponerBoton:*/
		ActionListener orden=new AccionOrden();
		
		
		ponerBoton("7", insertar);
		ponerBoton("8", insertar);
		ponerBoton("9", insertar);
		ponerBoton("/", orden);
		ponerBoton("4", insertar);
		ponerBoton("5", insertar);
		ponerBoton("6", insertar);
		ponerBoton("*", orden);
		ponerBoton("1", insertar);
		ponerBoton("2", insertar);
		ponerBoton("3",insertar);
		ponerBoton("-",orden);
		ponerBoton("0", insertar);
		ponerBoton(".", insertar);
		ponerBoton("=",orden);
		ponerBoton("+",orden);
		
		add(milamina2, BorderLayout.CENTER);/*esto para que la lamina 2 se ubique en la zona center*/
		ultimaOperacion="=";
	}
	
	/*agregando botones: se crea un metodo para q luego vaya agregando los botones a la lamina y tambien para ponerlos a la escucha:*/
	private void ponerBoton(String rotulo, ActionListener oyente){
		JButton boton=new JButton(rotulo);
		
		boton.addActionListener(oyente);/*con esto ya estamos poniendo el boton a la escucha, para que cuando el usuario haga click encima del
		boton lance o construya un objeto de tipo evento, y ese objeto de tipo evento concretamente de tipo ActionListener se almacene en la variable
		oyente*/
		
		milamina2.add(boton);
	}
		/*clase interna: para insertar numeros*/
		private class InsertaNumero implements ActionListener{
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				/*para capturar el texto asociado al momento del usuario seleccionar un boton:*/
			
				String entrada=e.getActionCommand();/*el metodo getActionCommand:Devuelve la cadena de comando asociada a esta acción. Es decir
				con esta variable se captura el texto del boton pulsado*/
				
				if(principio){/*en el caso de que pincipio sea true: una variable booleana cuando se compara tiene por defecto ==true*/
					pantalla.setText("");/*nos borra la pantalla*/
					principio=false;
				}
				
				
				/*luego tenemos que hacer que en la pantalla aparezca ese texto:*/
				pantalla.setText(pantalla.getText() +entrada);/*nuetro display se llamaba pantalla, el metodo setText permite establecer un texto en el objeto del boton
				si se ejecuta solamenta con entrada, al momento de seleccionar un boton los numeros desaparecen uno detras de otro, para solucionar
				esto y darle realidad de calculadora los numero al seleccionarlos deben aparecer todos sobre el display o pantalla, para ello
				se debe setear lo que haya en la pantalla + la entrada asi: pantalla.getText() + entrada*/
			}
		}
			/*clase interna que insertara las acciones de los botones Operadores matematicos*/
			private class AccionOrden implements ActionListener{
	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String operacion=e.getActionCommand();/*con este metodo consigo es almacenar un String en la variable operación que corresponde
					al texto del boton*/
//					System.out.println(operacion);
					calcular(Double.parseDouble(pantalla.getText()));/*este metodo sera el encargadado de ir realizando todas las operaciones matematicas
					como lo que hay en pantalla es un boton no un cuadro de texto donde se aloja texto, se debe capturar ese string y convertirlo a un
					double para poder trabajar con el: 			*
					*/
					ultimaOperacion=operacion;/*aca se ira almacenando la ultima operacion que haya hecho el usuario*/
					
					
					
					
					/*1. al momento de pulsar en cualquier boton el valor numerico que venga a continuacion sea nuevo */
					principio=true;/*con esto al pulsar en el boton de la operacion pertinente el siguiente sea nuevo*/
				}
				public void calcular(double x){/*este metodo va ser el cerebro del programa y encargado de realizar todas las operaciones:*/
				
					if (ultimaOperacion.equals("+")){
						resultado+=x;/*en la variable resultado acomular lo que le hemos pasado por parametro osea la X*/
//						System.out.println(resultado);
					}
					else if(ultimaOperacion.equals("-")){
						resultado-=x;
					}
					else if(ultimaOperacion.equals("*")){
						resultado*=x;
					}
					else if(ultimaOperacion.equals("/")){
						resultado/=x;
					}
					else if (ultimaOperacion.equals("=")){
						resultado=x;
					}
					pantalla.setText(""+ resultado);
					
				}
				
			}
	
	
	
	
	private JPanel milamina2;
	private JButton pantalla;
	private boolean principio; /*esta variable nos permitira saber si es el principio de la ejecución de la calculadora para q el 0 se muestre o no,
	por defecto las variables booleanas declaradas son false*/
	
	 private double resultado;/*variable contador donde se ira almacenando los numero introducidos para realizar la operación, el resultado
	 de todas las operaciones que vayamos realizando*/
	 private String ultimaOperacion;/*para saber cual es la ultima operacion que el usuario a seleccionado en la calculadora*/
}
