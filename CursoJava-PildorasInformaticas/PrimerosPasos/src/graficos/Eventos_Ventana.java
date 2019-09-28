package graficos;

import javax.swing.JFrame;
import javax.swing.plaf.synth.SynthSeparatorUI;

import java.awt.event.*;/*paquete que tiene clases e interfaces que responden a eventos*/

public class Eventos_Ventana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoVentana mimarco=new MarcoVentana();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*JFrame.EXIT_ON_CLOSE por defecto cuando se cierra frame finaliza el programa*/
		
		MarcoVentana mimarco2= new MarcoVentana();/*creando otra instancia, es decir creando otra ventana*/
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);/*DISPOSE_ON_CLOSE cierra dicho frame y no cierra el programa*/
		
		mimarco.setTitle("Ventana1");
		mimarco.setBounds(300, 300, 500, 350);
		
		mimarco2.setTitle("Ventana2");
		mimarco2.setBounds(900, 300, 500, 350);
		
	}

}

class MarcoVentana extends JFrame{
	public MarcoVentana() {
		// TODO Auto-generated constructor stub
		/*setTitle("Respondiendo");
		setBounds(300, 300, 500, 350);*/
		setVisible(true);
		
		M_Ventana oyente_ventana= new M_Ventana(); /*instancia creada*/
		
		/*tenemos que decirle a nuestro marco que este preparado para llamar a la clase oyente*/
		addWindowListener(oyente_ventana);/*podiendo la ventana a la escucha*/
	}
}

class M_Ventana implements WindowListener{ /*clase Listener*/
	
	
	public void windowActivated(WindowEvent e) {
		System.out.println("Ventana activada");
		
	}
	
	public void windowClosed(WindowEvent e) {/*este metodo lo toma cuando ha sido cerrada una segunda ventana*/
		
		System.out.println("La ventana ha sido cerrada");
		
	}
	
	public void windowClosing(WindowEvent e) {
		
		System.out.println("Cerrando Ventana");
		
	}
	
	public void windowDeactivated(WindowEvent e) {
		
		System.out.println("Ventana desactivada");
		
	}
	
	public void windowDeiconified(WindowEvent e) {
		
		System.out.println("Ventana Restaurada");
	
	}
	
	public void windowIconified(WindowEvent e) {
		
		System.out.println("Ventana minimizada");
	}
	
	public void windowOpened(WindowEvent e) {
		
		System.out.println("Ventana abierta");
	
	}
}