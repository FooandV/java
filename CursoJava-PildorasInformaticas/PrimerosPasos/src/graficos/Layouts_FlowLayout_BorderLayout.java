package graficos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;


/**
 * @author freyder:En esta clase se trata los Layouts de tipo FlowLayout y BorderLayout
 *
 */
public class Layouts_FlowLayout_BorderLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Layout marco=new Marco_Layout();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}
class Marco_Layout extends JFrame{
	public Marco_Layout(){//constructor
		setTitle("Prueba Acciones");
		setBounds(1000, 200, 600, 300);
		Panel_Layout lamina=new Panel_Layout();
		
//		FlowLayout disposicion= new FlowLayout(FlowLayout.LEFT);/*alineacion de los elementos a la izquierda*/
//		lamina.setLayout(disposicion);/*se utiliza el metodo setLayout para establecer la ubicación en objeto creado "disposición"*/
//		lamina.setLayout(new FlowLayout(FlowLayout.LEFT));/*creando la instancia dentro de los argumentos de setLayout*/
		
		Panel_Layout2 lamina2= new Panel_Layout2();/*se crea instancia perteneciente a la segunda lamina2*/
		add(lamina, BorderLayout.NORTH);
		add(lamina2, BorderLayout.SOUTH);
	}
	
}

class Panel_Layout extends JPanel{/*lamina1*/
	
	public Panel_Layout() {/*constructor*/
		// TODO Auto-generated constructor stub
		/*posicionamiento de los elementos en la lamina:*/
//		setLayout(new FlowLayout(FlowLayout.CENTER,75,100));/*separacion horizontal:150px, separacion vertical 200px*/
		
		setLayout(new FlowLayout(FlowLayout.LEFT));/*se establece posicion*/
		
		/*elementos de la lamina donde se tiene q ubicar de acuerdo al BorderLayout*/
		/*el metodo add es de la clase Contanier la cual es Heredada de JPanel, este metododo tiene sobrecarga de constructores
		y se utilizara el metodo: 	add(Component comp, int index) */
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
		
	}
}

class Panel_Layout2 extends JPanel{/*lamina2*/
	public Panel_Layout2(){/*constructor de la segunda lamina*/
		
		setLayout(new BorderLayout());/*se establece posicion para la segunda lamina*/
		add(new JButton("Azul"),BorderLayout.WEST);
		add(new JButton("Verde"),BorderLayout.EAST);
		add(new JButton("Negro"),BorderLayout.CENTER);
		
	}
}