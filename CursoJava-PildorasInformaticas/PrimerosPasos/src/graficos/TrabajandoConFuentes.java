package graficos;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConFuentes mimarcoConFuentes= new MarcoConFuentes();
		mimarcoConFuentes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarcoConFuentes.setVisible(true);

	}

}
/*creando el marco*/
class MarcoConFuentes extends JFrame {

	public MarcoConFuentes() {

		setTitle("Prueba con Fuentes");
		setSize(400, 400);
		LaminaConFuentes milamina = new LaminaConFuentes();
		add(milamina);
		/*si se quiere establecer un solo color en todo lo que se plasme en la lamina se utiliza:*/
		milamina.setForeground(Color.black);
	}

}
/*creando la lamina para dibujar en ella*/
class LaminaConFuentes extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Font mifuente= new Font("Yu Gothic Light", Font.BOLD, 26);/*	se utiliza este constructor: Font(String name, int style, int size)*/
		g2.setFont(mifuente);/*estableciendo el tipo de letra definido en mifuente*/
		
		//g2.setColor(Color.MAGENTA);
		g2.drawString("Violetta", 100, 100);/*Metodo para escribir una cadena de caracteres sobre la lamina, poniendo el string y las coordenas X y Y*/
		
		g2.setFont(new Font("Arial",Font.ITALIC,24));/*instanciando otro tipo de letra, otra manera de hacerlo*/
		//g2.setColor(new Color(128, 90, 50).brighter());/*instanciando sobre SetColor y utilizando el metodo brighter para que de brillo a ese color*/
		g2.drawString("Curso de Java", 100, 200);

	}
}