package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBotones mimarco=new MarcoBotones();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotones extends JFrame{
	public MarcoBotones() {
		setTitle("Botones y Eventos");
		setBounds(700, 300, 500, 300);
		LaminaBotones milamina=new LaminaBotones();
		add(milamina);
		
		
	}
	
}
class LaminaBotones extends JPanel implements ActionListener{
	
	JButton botonAzul=new JButton("azul");/*construyendo el boton*/
	/*construir el constructor para agregarlo a la lamina:*/
	/*otros botones:*/
	JButton botonAmarillo=new JButton("Amarillo");
	JButton botonRojo=new JButton("Rojo");
	
	
	public LaminaBotones(){
		add(botonAzul);
		botonAzul.addActionListener(this);/* metodo: addActionListener(ObjetoListener)
		notas: 
		***objeto evento= Action(al hacer click),
		***objeto Fuente= el botonAzul,
		***objeto listener= this
		el operador "this" hace referencia al objeto donde nos encontramos, de esta forma le estamos diciendo
		a nuestro botonAzul que va desencadenar un evento (concretamente al hacer click) y que ese evento lo tiene que recibir el objeto a la escucha(this)
		al poner un "this" estamos haciendo referencia que ponemos a la escucha a la propia (LaminaBotones).
		nota: como el metodo addActionListener(ObjetoListener) pide un "objetoListener" se debe implementar la interfaz "ActionListener" por lo cual
		estamos obligados a reescribir los metodos q tenga dicha interfaz */
		
		add(botonAmarillo);
		botonAmarillo.addActionListener(this);
		add(botonRojo);
		botonRojo.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {/*el metodo actionPerformed(ActionEvent e) tiene una clase ActionEvent con una instancia e,*/
		
		/*si queremos que cada boton realice algo diferente, debemos utilizar el metodo "getSource()" perteneciente a la clase (ActionEvent), este
		 * captura el origen del evento, es decir que objeto fuente es el que desencadena, porque de no utilizar este metodo le da igual al metodo
		 * actionPerformed(ActionEvent e) ejecutar las acciones */
		Object BotonPulsado=e.getSource();
		
		if(BotonPulsado==botonAzul){
			setBackground(Color.blue);
		}
		else if(BotonPulsado==botonAmarillo){
			setBackground(Color.yellow);
		}
		else{
			setBackground(Color.red);
		}
		
		
	}
	
	
}
