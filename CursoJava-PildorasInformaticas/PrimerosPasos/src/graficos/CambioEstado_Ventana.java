package graficos;

import javax.swing.JFrame;

import java.awt.Frame;
import java.awt.event.*;


/**
 * @author freyder
 * este ejemplo muestra una notificación cada vez que realiza alguna accion el marco de la ventana, la notificación sera por pantalla
 */
public class CambioEstado_Ventana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoEstado mimarco=new MarcoEstado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoEstado extends JFrame{
	public MarcoEstado() {/*constructor del frame*/
		setVisible(true);
		setBounds(300, 300, 500, 350);
		
		/*se agrega una instancia de la clase CambiaEstado y se pone a la escucha*/
		CambiaEstado nuevo_estado=new CambiaEstado();
		addWindowStateListener(nuevo_estado);/*metodo para poner  a la escucha la instancia creada "nuevo_estado"*/
		
	}
	
	class CambiaEstado implements WindowStateListener{
		public CambiaEstado() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public void windowStateChanged(WindowEvent e) {/*metodo sobre escrito void windowStateChanged(WindowEvent e): Se invoca cuando se cambia el 
		estado de la ventana.*/
			//System.out.println("La  ventana ha cambiado de estado");
			
			//System.out.println(e.getNewState());
			if (e.getNewState()==Frame.MAXIMIZED_BOTH){
				setTitle("ventana ha pantalla completa");
				//System.out.println("La ventana está a pantalla completa");
				
			}else if(e.getNewState()==Frame.NORMAL){
				setTitle("ventana Normal");
				//System.out.println("La ventana esta Normal");
			}else if(e.getNewState()==Frame.ICONIFIED){
				setTitle("ventana Minimizada");
				//System.out.println("La ventana esta minimizada");
			}
			
		}
		
	}
}

