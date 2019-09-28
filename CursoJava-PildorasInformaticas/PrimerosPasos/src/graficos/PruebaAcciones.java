package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


/**
 * @author freyder
 * Lo que se pretende con este ejemplo practico es tener 1 elemento oyente y varios elementos fuente, donde
 * el oyente va hacer una lamina que cambiara de color, y los objetos fuente que mandaran a realizar las acciones son
 * los botones y el teclado.
 *
 */
public class PruebaAcciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion marco= new MarcoAccion();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}
class MarcoAccion extends JFrame{
	public MarcoAccion() {
		// TODO Auto-generated constructor stub
		setTitle("Prueba acciones");
		setBounds(600, 350, 600, 300);
		PanelAccion lamina= new PanelAccion();
		add(lamina);/*se agrega la lamina al marco*/
	
	}
	
}

class PanelAccion extends JPanel{
	
	public PanelAccion(){/*constructor de la lamina*/
		/*lo primero que se tiene que hacer es instanciar la clase oyente para despues decir quien es la fuente del evento y poner el objeto
		 * del evento a la escucha:*/
		AccionColor accionAmarillo= new AccionColor("Amarillo",new ImageIcon("src/graficos/bola_amarilla.gif"), Color.yellow );
		AccionColor accionAzul= new AccionColor("Azul",new ImageIcon("src/graficos/bola_azul.gif"), Color.blue );
		AccionColor accionRojo= new AccionColor("Rojo",new ImageIcon("src/graficos/bola_roja.gif"), Color.red );
		
		/*para crear nuestros botones y presentarlos en la lamina:*/
		
		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));
				/*instanciacion y creación de los botones en la lamina:*/
				/*JButton botonAmarillo= new JButton("Amarillo");
				JButton botonAzul= new JButton("Azul");
				JButton botonRojo= new JButton("Rojo");*/
				/*agregacion de los botones a la lamina:*/
				/*add(botonAmarillo);
				add(botonAzul);
				add(botonRojo);*/
		
		/*PASOS A SEGUIR PARA COMBINACION DE TECLAS:*/
		 /*paso1: crear mapa de entrada*/
		InputMap mapaEntrada= getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);/*getInputMap: Devuelve el InputMap que se usa cuando el componente tiene foco.
		por eso primero se crea un objeto perteneciente a la clase InputMap para almacenar lo que devuelve  el metodo dentro de la variable "mapaEntrada", 
		el metodo pertenece a la clase JComponent y tiene una constante de clase(campo static = WHEN_IN_FOCUSED_WINDOW=significa que el comando debe invocarse 
		cuando el componente receptor está en la ventana que tiene el foco o es en sí mismo el componente enfocado.) */
		
		/*paso2: crear mapa de entrada*/
		KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");
		KeyStroke teclaAzul=KeyStroke.getKeyStroke("ct rl B");
		KeyStroke teclarojo=KeyStroke.getKeyStroke("ctrl R");
		
		/*paso3: Asignar combinacion de teclas a objeto:*/		
		mapaEntrada.put(teclaAmarillo, "fondo_amarillo");
		mapaEntrada.put(teclaAzul, "fondo_azul");
		mapaEntrada.put(teclarojo, "fondo_rojo");
		
		/*paso4: Asignar objeto a la acción:*/
		ActionMap mapaAccion=getActionMap();
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
		
		
	}
	
	/*el siguiente paso es poner nuestra lamina a la escucha para que en un futuro los botones o elementos de esta sean oyentes*/
	/*Esta clase  oyente va ser la encargada de cambiar el color de fondo de la lamina mediante los botones*/
	/*clase interna oyente*/
	class AccionColor extends AbstractAction{/*se utiliza la clase:AbstractAction para no implementar la interfaz: Action*/
		
		public AccionColor( String nombre, Icon icono, Color color_boton) {/*este constructor tiene los parametros que seran instanciados cuando se cree el objeto y serviran para
		envio al metodo putValue que almacenara la informacion del evento*/
			putValue(Action.NAME, nombre);/*putValue, para que cuando se construya el objeto del evento se almacene dentro de este metodo, el nombre,icono y color
			en formato: clave:valor.
			nota: putValue(Action.NAME, nombre): name es una constante de la interfaz Action, es static, devuelve un String, segun la api de java es la 
			La clave utilizada para almacenar el nombre de cadena para la acción, utilizada para un menú o botón */
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre );
			putValue("color_de_fondo", color_boton);
		}
		
		
		public void actionPerformed(ActionEvent e) {/*este metodo es sobreescrito y obligado implementarlo ya que es heredado
		de ActionListener*/
			
			Color c=(Color)getValue("color_de_fondo"); /*con esto estamos declarando una clase tipo Color, de donde estamos utilizando un metodo gerValue que es
			de la interfaz Action el cual es capaz de rescatar la información alojada en el objeto creado por el metodo putValue, 
			y se hace un casting para q el valor obtenido sea convertido a una variable tipo Color*/
			setBackground(c);
			
			System.out.println("Nombre: " + getValue(Action.NAME));
		}
		
	}
	
}

