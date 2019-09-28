package graficos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Eventos_Raton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoRaton mimarco=new MarcoRaton();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoRaton extends JFrame{
	public MarcoRaton() {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setBounds(700, 300, 600, 450);
		
		/*poniendo el marco a la escucha*/
		EventosDeRaton EventoRaton=new EventosDeRaton();
		addMouseListener(EventoRaton);/*asi se pone a la escucha a nuestro marco*/
	
	}
}

/*clase que implementa la interface MouseListener:*/
class EventosDeRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {//evento que desencadena la accion cuando hemos hecho click
		// TODO Auto-generated method stub
		System.out.println("Haz hecho click");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("acabas de entrar");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("acabas de salir");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("acabas de presionar");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("acabas de levantar");
	}
	
}