package graficos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

 
/**
 * @author freyder
 * ejercicio de eventos de teclado, el codigo Java captura las teclas o codigos de las teclas al desencadenar un evento de teclado
 *
 */
public class EventosTeclado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConTeclas mimarco= new MarcoConTeclas();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConTeclas extends JFrame{
	public MarcoConTeclas() {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setBounds(700, 300, 600, 450);
		
		EventoDeTeclado tecla=new EventoDeTeclado();//instanciando el objeto oyente o clase creada
		addKeyListener(tecla);//poniendo la clase a la escucha.
		
	
	
	}
	
}

class EventoDeTeclado implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int codigo=e.getKeyCode();
		System.out.println(codigo);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {/*metodo que devuelve el codigo y la letra pulsada por teclado*/
		// TODO Auto-generated method stub
		
		char letra=e.getKeyChar();
		System.out.println(letra);
	}


}
