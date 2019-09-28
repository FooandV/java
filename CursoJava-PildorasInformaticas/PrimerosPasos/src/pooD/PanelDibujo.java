package pooD;

import java.awt.Graphics; //clase que proporciona metodos para dibujar texto y figuras
import javax.swing.JPanel; //clase que proporciona un área en la que podemos dibujar

public class PanelDibujo extends JPanel{
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);//llama a paintComponent para asegurar que el panel se muestre correctamente, antes de dibujar en el
		
		
		int anchura= getWidth(); //anchura total
		int altura= getHeight(); //altura total
		
		int anchurausuario= 0;
		int alturausuario= 0;
		
		while (alturausuario <= 50000){
			
			g.drawLine(anchurausuario, alturausuario, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
			
			//g.drawLine(0, alturausuario, anchura, altura); //dibuja una linea de la esquina inferior izquierda a la esquina superior derecha
			
			anchurausuario = anchurausuario +20;
			alturausuario = alturausuario +20;
			//g.drawLine(2, altura, anchura, 1); //dibuja una linea de la esquina inferior izquierda a la esquina superior derecha
						
		}		
		
		
		//g.drawLine(0, 20, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		/*g.drawLine(1, 30, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(2, 40, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(3, 50, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(4, 60, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(5, 70, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(6, 80, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(7, 90, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(8, 100, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		
		g.drawLine(0, 20, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(1, 30, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(2, 40, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(3, 50, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(4, 60, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(5, 70, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(6, 80, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(7, 90, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		g.drawLine(8, 100, anchura, altura); //dibuja una linea de la esquina superior izquierda a la esquina inferior derecha
		*/
		
		

		
		//g.drawLine(2, altura, anchura, 1); //dibuja una linea de la esquina inferior izquierda a la esquina superior derecha
		
		
	}
	

}
