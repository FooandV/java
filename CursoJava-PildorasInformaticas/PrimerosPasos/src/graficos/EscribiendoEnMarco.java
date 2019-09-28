package graficos;

import javax.swing.*;
import java.awt.*;
public class EscribiendoEnMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoconTexto mimarco = new MarcoconTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoconTexto extends JFrame{
	
	public MarcoconTexto() {/*constructor*/
		
		setVisible(true);
		setSize(600,450);
		setLocation(400, 200);
		setTitle("primer texto");
		Lamina milamina=new Lamina();/*instanciando una lamina cuando se llame este constructor*/
		add(milamina);/*agregar la lamina al marco, este metodo es de JComponent*/
		
	}
}

class Lamina extends JPanel{
	
	public void paintComponent(Graphics g){/*este metodo esta implementando una clase abstracta
	que es Graphics, por lo cual es obligatorio su implementaci�n en las clases hijas, entonces
	lo estamos sobreescribiendo y tendra su funcionalidad mas la q se le de.*/
		
		super.paintComponent(g);/*llamando las funcionalidades propias definidas en la super JComponent*/
		g.drawString("estamos aprendiendo Swing", 100, 100);/*escribiendo texto*/
	}
}