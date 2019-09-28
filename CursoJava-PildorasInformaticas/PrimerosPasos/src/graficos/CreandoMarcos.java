package graficos;

import java.awt.Frame;

import javax.swing.*;


/**
 * @author freyder
 * Ejercicios con frames y dibujos
 * como es visible los marcos
 * como cambiar la posición del frame
 */
public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		miMarco marco1= new miMarco();/*instanciando marco*/
		
		/*esto es un ejemplo sobre Github*/
		
		marco1.setVisible(true);/*metodo para que el marco sea visible*/
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/**
		 * el metodo setDefaultCloseOperation(int operation)
		pide un parametro de tipo (int operation), en el api se presenta las opciones
		de operaciones que trabajan con este metodo:DO_NOTHING_ON_CLOSE ,HIDE_ON_CLOSE ,
		DISPOSE_ON_CLOSE ,EXIT_ON_CLOSE = constante de clase static
		entonces establece que  se cierre la ventana el programa tiene que acabar
		 */

	}

}

class miMarco extends JFrame{
	
	public miMarco() {/*metodo constructor*/
		
		setSize(500,300);/**metodo heredado de Window para cambiar el ancho y alto de un frame*/
		
		//setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/**setLocation(1000, 400);/*metodos que manejan un eje de coordenadas cartesiano
		ejemplo: x=0, y=0 quiere decir que es la esquina superior izquierda*/
		
		setBounds(1500,300, 550, 250); /**metodo mas completo que me define ubicación mas ancho y alto*/
		
		/**setResizable(false); metodo que posibilita redimensionar true o false el marco*/
		
		/**setExtendedState(Frame.MAXIMIZED_BOTH);
		metodo que maximiza el frame a pantalla completa
		el metodo 	setExtendedState(int state) es de la clase Frame y en la API indica que 
		el parametro de entrada es un entero state(estado)
		public void setExtendedState(int state)
		Sets the state of this frame. The state is represented as a bitwise mask.
		NORMAL 
		Indicates that no state bits are set.
		ICONIFIED
		MAXIMIZED_HORIZ
		MAXIMIZED_VERT
		MAXIMIZED_BOTH = esta definido en la api: public static final int MAXIMIZED_BOTH
		es un campo estatico que es una constante de clase (clase Frame) por lo cual 
		cuando se llame	debe utilizarse la clase antes del campo para su llamada, si es 
		una constante es porque hay valor predefinido entero que puede interpretar el campo constante
		ese valor en la api es 6, osea que es lo mismo poner setExtendedState(6)*/
		
		setTitle("Ventana");/** Metodo para darle nombre a la ventana o marco*/
		setLocationRelativeTo(null);/*presenta el frame en el centro del monitor*/
	}	
	
}