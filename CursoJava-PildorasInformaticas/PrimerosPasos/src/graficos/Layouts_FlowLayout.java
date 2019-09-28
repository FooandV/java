package graficos;
import java.awt.FlowLayout;

import javax.swing.*;


/**
 * @author freyder:En esta clase se trata los Layouts de tipo FlowLayout
 *
 */
public class Layouts_FlowLayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco_Layout_FlowLayout marco=new Marco_Layout_FlowLayout();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}
class Marco_Layout_FlowLayout extends JFrame{
	public Marco_Layout_FlowLayout(){//constructor
		setTitle("Prueba Acciones");
		setBounds(1000, 200, 600, 300);
		Panel_Layout_FlowLayout lamina=new Panel_Layout_FlowLayout();
		
//		FlowLayout disposicion= new FlowLayout(FlowLayout.LEFT);/*alineacion de los elementos a la izquierda*/
//		lamina.setLayout(disposicion);/*se utiliza el metodo setLayout para establecer la ubicación en objeto creado "disposición"*/
//		lamina.setLayout(new FlowLayout(FlowLayout.LEFT));/*creando la instancia dentro de los argumentos de setLayout*/
		
		add(lamina);
	}
	
}

class Panel_Layout_FlowLayout extends JPanel{
	
	public Panel_Layout_FlowLayout() {/*constructor*/
		// TODO Auto-generated constructor stub
		/*posicionamiento de los elementos en la lamina:*/
		setLayout(new FlowLayout(FlowLayout.CENTER,75,100));/*separacion horizontal:150px, separacion vertical 200px*/
		
		
		/*elementos de la lamina*/
		add(new JButton("Amarillo"));
		add(new JButton("Rojo"));
		add(new JButton("Azul"));
	}
}