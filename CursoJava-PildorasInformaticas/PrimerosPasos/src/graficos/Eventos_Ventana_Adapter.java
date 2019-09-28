package graficos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


/**
 * @author freyder
 * ejemplo
 *
 */
public class Eventos_Ventana_Adapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoVentana2 mimarco=new MarcoVentana2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*JFrame.EXIT_ON_CLOSE por defecto cuando se cierra frame finaliza el programa*/
		
		MarcoVentana2 mimarco2= new MarcoVentana2();/*creando otra instancia, es decir creando otra ventana*/
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);/*DISPOSE_ON_CLOSE cierra dicho frame y no cierra el programa*/
		
		mimarco.setTitle("Ventana1");
		mimarco.setBounds(300, 300, 500, 350);
		
		mimarco2.setTitle("Ventana2");
		mimarco2.setBounds(900, 300, 500, 350);

	}

}

class MarcoVentana2 extends JFrame{
	
	public MarcoVentana2() {
		// TODO Auto-generated constructor stub
		/*setTitle("Respondiendo");
		setBounds(300, 300, 500, 350);*/
		setVisible(true);
		
		/*M_Ventana2 oyente_ventana= new M_Ventana2(); /*instancia creada*/
		/*tenemos que decirle a nuestro marco que este preparado para llamar a la clase oyente*/
		/*addWindowListener(oyente_ventana);/*podiendo la ventana a la escucha*/
		addWindowListener(new M_Ventana2());/*codigo simplificado, que prepara a nuestro marco a la escucha, se instancia invocando al constructor*/
		
	}
}

class M_Ventana2 extends WindowAdapter{ /*clase adaptadora Listener*/
	 
		
	
	public void windowIconified(WindowEvent e) {
		
		System.out.println("Ventana minimizada");
	}
	
	
}