package interfaces_y_clasesinternas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 * @author freyder
 * En este ejemplo se utilizará una clase interna Local es decir dentro de un metodo para que sea mas encapsulada
 */
public class PruebaTemporizador3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reloj2 mireloj = new Reloj2();
		
		mireloj.setenMarcha(3000,true);

		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");

		System.exit(0);

	}

}

class Reloj2 {
	
	// campo de clase encapsulado, estos se pueden prescindir y declararse como parametros en el metodo setenMarcha()
	/*private int intervalo; 
	private boolean sonido;*/

	/* metodos */
	/*este constructor se puede obviar con el codigo planteado en el metodo void setenMarcha()
	public Reloj2(int intervalo, boolean sonido) {// constructor, este 

		this.intervalo = intervalo;
		this.sonido = sonido;

	}*/

	public void setenMarcha( int intervalo, final boolean sonido) {
		
		 class DameLahora2 implements ActionListener{ /*clase interna local dentro de un metodo*/
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				
				Date ahora= new Date();
				System.out.println("te pongo la hora cada 3 segundos: "+ ahora);
				
				if (sonido){ /*esta utilizando una variable local del metodo que esta implementando la clase
				 			  esto implica esa variable definida como parametro en el metodo debe definirse como final*/
					
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}

		ActionListener oyente = new DameLahora2();

		Timer mitemporizador = new Timer(intervalo, oyente);

		mitemporizador.start();
	}
}


