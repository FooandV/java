package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaVariosOyentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Principal mimarco=new Marco_Principal();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class Marco_Principal extends JFrame{
	
	public Marco_Principal() {

		setTitle("Prueva varios");
		setBounds(1300, 100, 300, 200);
		Lamina_Principal lamina= new Lamina_Principal();
		add(lamina);
	
	}
}


class Lamina_Principal extends JPanel{
	
	public Lamina_Principal(){/*constructor*/
		
		JButton boton_nuevo=new JButton("nuevo");
		add(boton_nuevo);
		boton_cerrar=new JButton("Cerrar todo");
		add(boton_cerrar);
		OyenteNuevo miOyente=new OyenteNuevo();/*se crea una instancia correspondiente a la clase interna*/
		boton_nuevo.addActionListener(miOyente);/*se toma el boton para que desencadene el evento y sea recibido por la clase oyente:OyenteNuevo */
		
	}
	/*clase interna:*/
	private class OyenteNuevo implements ActionListener{/*clase Oyente que  va recibir el evento del boton_nuevo va ser la que llame
	a la clase Marco_Emergente para crear la ventana correspondiente*/
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Marco_Emergente marco= new Marco_Emergente(boton_cerrar);
			marco.setVisible(true);
		}
	}
	
	
	JButton boton_cerrar; /*esta variable se declara fuera del constructor porque sera utilizada luego*/
}

class Marco_Emergente extends JFrame{/*esta clase es la que se encarga de crear los marcos o ventanas nuevoas, darles un title y posicion,
al igual q ponerle un nombre diferente con un id diferente q se va incrementando*/
	
	public Marco_Emergente(JButton boton_de_principal) {/*a este constructor se le pasa por parametro el boton_cerrar ya que esta instanciado en otra clase "Lamina_Principal"
	y el cual va ser la fuente(desencadenante del evento) y sea la clase interna CierraTodos quien lo reciba*/
		// TODO Auto-generated constructor stub
		contador++;
		setTitle("Ventana " + contador);
		setBounds(40*contador, 40*contador, 300, 150);/*la posicion no puede ser fija,por eso se le pone 40*contador para variar las posiciones en los ejes x y*/
		CierraTodos oyenteCerrar=new CierraTodos();/*instancia de la clase oyente*/
		boton_de_principal.addActionListener(oyenteCerrar);/*aca se le dice que el parametro que ha recibido el constructor tiene que ser la fuente*/
		
	
	
	}
	/*clase interna que se encarga de cerrar los marcos o ventanas:*/
	private class CierraTodos implements ActionListener{/*clase oyente que  va recibir el evento del boton_cerrar va ser la que llame
	al metodo dispose() para crear la ventana correspondiente*/

		@Override
		public void actionPerformed(ActionEvent e) {/*lo que tiene que hacer este metodo es cerrar el objeto oyente o varios oyentes*/
			// TODO Auto-generated method stub
			dispose();/*metodo que cierra los objetos, este pertenece a la clase JFrame y es heredado de la clase Window*/
			contador=0;/*se resetea el contador de instancias de creación de marcos*/
		}
		
	}
	
	
	private static int contador=0;/*variable static, es compartida por todas las instancias que se creen en un futuro*/
}