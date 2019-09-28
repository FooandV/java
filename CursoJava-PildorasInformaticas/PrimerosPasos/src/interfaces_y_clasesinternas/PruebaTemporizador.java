package interfaces_y_clasesinternas;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

/*Ejemplo de utilización de la clase Timer donde tiene el metodo constructor
 Timer(int delay, ActionListener listener)
Creates a Timer and initializes both the initial delay and between-event delay to delay milliseconds.
igual se observa la utilizacion de un argumento que es una interfas= ActionListener y para la utlilización de este
se obliga a implementar los metodos definidos en esta:metodo: 	actionPerformed(ActionEvent e)
*/

public class PruebaTemporizador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DameLahora oyente= new DameLahora(); //es = ActionListener oyente= new DameLahora();
		
		Timer mitemporizador = new Timer(5000, oyente);/*el primer parametro es ponerle el tiempo,
		de cada x tiempo se va ejecutar el evento u acción del segundo parametro q es un objeto de tipo interfaz
		ActionListener que implementa el metodo:actionPerformed(ActionEvent e),
		por ello es necesario crear una clase q implemente esta interfaz*/
		
		mitemporizador.start(); /*inicia el objeto*/
		
		JOptionPane.showMessageDialog(null, "Pulse Aceptar para terminar");/*presenta una ventana con un mensaje y boton*/
		
		System.exit(0);/*instruccion que detiene la ejecucion del programa*/
		
	}
	
}

/*Clase que va implementar la interfaz ActionListener*/
class DameLahora implements ActionListener{ /*esto obliga a que desarrollemos todos los metodos de la interfaz
en este caso el metodo "actionPerformed(ActionEvent e)"*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Date ahora= new Date(); /*estoy almacenando en la variable objeto ahora, la hora actual del sistema*/
		
		System.out.println("Te pongo la hora cada 5 segundos: " + ahora);
		/*clase Tookkit: permite acceder a los recursos de nuestro sistema operativo*/
		Toolkit.getDefaultToolkit().beep();/*esto llamara el sonido beep de windows cuando se lance el evento de captura hora*/
		

	}
	
	
}

