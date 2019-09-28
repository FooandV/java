package graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;


/**
 * @author freyder
 * este ejercicio presenta sobre un marco las coordenadas x o y cuando se hace click sobre el raton
 *
 */
public class Evento_Raton_Adapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRaton2 mimarco=new MarcoRaton2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoRaton2 extends JFrame{
	
	public MarcoRaton2(){//constructor
		setVisible(true);
		setBounds(700, 300, 600, 450);
		EventosDeRaton2 EventoRaton= new EventosDeRaton2();
		//addMouseListener(EventoRaton);
		addMouseMotionListener(EventoRaton);//poniendo a la escucha
	}
}

//class EventosDeRaton2 extends MouseAdapter{
	
	/*public void mouseClicked(MouseEvent e) {
		System.out.println("Coordenada x: " +e.getX() + " " + "Coordenada Y: " +e.getY());//detecta las coordenadas
		System.out.println("El numero de click es: " +e.getClickCount());//detecta el numero de clicks
	}*/
	
	 //public void mousePressed(MouseEvent e){
		/*System.out.println(e.getModifiersEx());/*valor de las constantes de clase para los  botones del teclado*/
		/*
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK){//validacion del click izquierdo del raton
			System.out.println("haz pulsado el boton izquierdo del raton");
		}else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK){
			System.out.println("Haz pulsado el boton derecho del raton");
		}else if(e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK){
			System.out.println("Hazp pulsado la rueda del raton");
		}*/
	//}
	
//}


 /**
 * @author freyder
 *
 */
class EventosDeRaton2 implements MouseMotionListener{
	
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("estas arrastrando");
	};
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("estas moviendo");
	}
}


