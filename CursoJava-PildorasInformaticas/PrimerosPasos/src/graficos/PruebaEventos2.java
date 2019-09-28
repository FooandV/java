package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEventos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBotones2 mimarco=new MarcoBotones2();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotones2 extends JFrame{
	public MarcoBotones2() {
		setTitle("Botones y Eventos");
		setBounds(700, 300, 500, 300);
		LaminaBotones2 milamina=new LaminaBotones2();
		add(milamina);
		
		
	}
	
}
class LaminaBotones2 extends JPanel{
	
	JButton botonAzul=new JButton("azul");/*construyendo el boton*/
	/*construir el constructor para agregarlo a la lamina:*/
	/*otros botones:*/
	JButton botonAmarillo=new JButton("Amarillo");
	JButton botonRojo=new JButton("Rojo");
	
	
	public LaminaBotones2(){
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		
		/*objetos instanciados pertenecientes a la clase ColorFondo:*/
		ColorFondo Amarillo=new ColorFondo(Color.yellow);
		ColorFondo Azul=new ColorFondo(Color.blue);
		ColorFondo Rojo=new ColorFondo(Color.red);
		
		botonAzul.addActionListener(Azul);/* metodo: addActionListener(ObjetoListener)*/
		botonAmarillo.addActionListener(Amarillo);
		botonRojo.addActionListener(Rojo);
		
	}
	private class  ColorFondo implements ActionListener{ /*la clase interna ColorFondo sera el objeto listener*/
		
		private Color colorDeFondo;/*variable encapsulada de tipo Color*/
		
		public ColorFondo(Color c) {/*constructor*/
		
			colorDeFondo=c;
		}
		public void actionPerformed(ActionEvent e){/*metodo sobre escrito, encargado de poner la lamina de un color de fondo diferente*/
			
			setBackground(colorDeFondo);
		}
		
	}
}


	

