package graficos;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.plaf.synth.SynthSeparatorUI;


/**
 * @author freyder
 * este ejercicio permite validar el foco de un componente JTextField en un marco, donde
 * se valida cuando gana o pierde el foco, cuando lo pierde se verifica una cadena de texto
 * que contenga un @
 */
public class FocoEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoFoco mimarco= new MarcoFoco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class MarcoFoco extends JFrame{
	public MarcoFoco() {//costructor
		// TODO Auto-generated constructor stub
		setVisible(true);
		setBounds(300, 300, 600, 450);
		/*instanciando la lamina dentro del  marco:*/
		add(new LaminaFoco());
		//setVisible(true);
	}
	
}

class LaminaFoco extends JPanel{
	
	//variables objeto de clase:
		JTextField cuadro1;
		JTextField cuadro2;
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		setLayout(null);//invalida la posicion de los componentes por defecto q se presentan en el marco
		
		/*instanciando los objetos que crearan los cuadros texto con su respectivo constructor:*/
		cuadro1=new JTextField(); 
		cuadro2=new JTextField();
		/*se da tamaño y posicion a los componentes cuadro te texto*/
		cuadro1.setBounds(120, 10, 150, 20);
		cuadro2.setBounds(300, 10, 150, 20);
		
		/*se agregan los cuadreos te texto a la lamina*/
		add(cuadro1);
		add(cuadro2);
		
		/*creando una instancia de la clase oyente:*/
		LanzaFocos elfoco=new LanzaFocos();
		cuadro1.addFocusListener(elfoco);/*se pone el objeto cuadro1 a la escucha*/
	}
	
	/*clase interna:*/
	private class LanzaFocos implements FocusListener{//clase oyente

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {/*metodo de perdida de foco*/
			// TODO Auto-generated method stub
		
			String email=cuadro1.getText();//con esta variable almacenamos el texto que se encuentra en el cuadro1
			
			boolean	comprobacion=false;
			
			
			for(int i=0; i<email.length(); i++){/*for para recorrer la lingitud del email */
			
				if(email.charAt(i)=='@'){	//if para evaluar caracter a caracter que tenga una @
					comprobacion=true;
					
				}
			
			}
			if(comprobacion){
				System.out.println("correcto");
			}else{
				System.out.println("incorrecto");
			}
		}

	}
}
