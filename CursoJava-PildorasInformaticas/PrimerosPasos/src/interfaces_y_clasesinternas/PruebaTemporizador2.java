package interfaces_y_clasesinternas;


import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author freyder
 * este es un ejemplo de como clases internas y la sintaxis y la utilidad que puedan tener
 *
 */
public class PruebaTemporizador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reloj mireloj = new Reloj(3000, true);
		mireloj.setenMarcha();

		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");

		System.exit(0);

	}

}

class Reloj {

	private int intervalo; // campo de clase encapsulado
	private boolean sonido;

	/* metodos */
	public Reloj(int intervalo, boolean sonido) {// constructor

		this.intervalo = intervalo;
		this.sonido = sonido;

	}

	public void setenMarcha() {

		ActionListener oyente = new DameLahora2();

		Timer mitemporizador = new Timer(intervalo, oyente);

		mitemporizador.start();
	}
	
	private class DameLahora2 implements ActionListener{ /*clase interna*/
		
		@Override
		public void actionPerformed(ActionEvent evento) {
			
			Date ahora= new Date();
			System.out.println("te pongo la hora cada 3 segundos: "+ ahora);
			
			if (sonido){ /*esta utilizando un campo de ejemplar de una clase externa*/
				
				Toolkit.getDefaultToolkit().beep();
			}
				
			
		}
		
	}

}
