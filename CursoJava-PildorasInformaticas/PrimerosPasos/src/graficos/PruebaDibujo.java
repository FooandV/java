package graficos;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class PruebaDibujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConDibujos mimarco= new MarcoConDibujos();
		
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*con este metodo cierro la operacion que
		se este ejecutando, envio como parametro la constante de la clase JFrame q hace el ejercicio*/
	

	}

}

class MarcoConDibujos extends JFrame{
	
	public MarcoConDibujos(){
		// TODO Auto-generated constructor stub
		setTitle("prueba de Dibujo");
		setSize(400,400);
		LaminaConFiguras milamina= new LaminaConFiguras();
		add(milamina);
	}
}
class LaminaConFiguras extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);/*llamando al metodo constructor de JComponent*/
		/*escribiendo en la lamina:*/
		//g.drawRect(50, 50, 200, 200);/*con esto dibujo un cuadrado*/
		//g.drawLine(100, 100, 300, 200);/*dibujo una linea */
		
		/*para dibujar un Rectangle2D tenemos que instanciar esa clase y luego necesitamos un  objeto de tipo Graphics2D
		 * para despues utilizar el metodo draw(Shape s) */
		/*para trabajar con la clase Graphics2D es necesario hacer una refundicion:*/
		Graphics2D g2=(Graphics2D) g;/*refundicion: convertimos nuestro objeto (g) de tipo Graphics  en un objeto de tipo Graphics2D 
		y queda representado con la variable objeto (g2) */
		
		/*lo siguiente es instanciar la clase Rectangle2D, esta no se puede instanciar porque es abstracta segun la API, sin embargo
		 * tenemos la clase Rectangle2D.Double es interna dentro de Rectangle2D*/
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);/*utilizando principio de sustitucion, la clase Rectangle2D.Double es un
		Rectangle2D*/
		
		g2.draw(rectangulo); /*dibujando utilizando el metodo draw*/
		
		/*para dibujar una elipse:*/
		
		Ellipse2D elipse= new Ellipse2D.Double();/*instanciando la clase hija (Ellipse2D.Double) de la clase padre (Ellipse2D)q es abstracta */
		elipse.setFrame(rectangulo);/*dandole las dimensiones donde se pondra la elipse, se manda el argumento (rectangulo) ya que es el
		parametro que pide el metodo pues pide un objeto rectangle2d para q se defina como un rectangulo imaginario y este sea los limites de la elipse*/
		
		g2.draw(elipse);/*dibujando la elipse con el metodo draw*/
		
		/*SI queremos dibujar un circulo que englobe  por fuera de los bordes del rectangulo y de la elipse ya dibujada sobre la lamina:
		 * para ello hay que utilizar los metodos getCenterx y getCentery, lo que se consigue con estos metodos aplicandolo al  rectangulo que nos diga
		 * el punto intermedio en el eje de las x y getcentery lo mismo, luego se utiliza un metodo de la elipse que es setframefromcenter dibuja la 
		 * circunferencia fuera*/
		
		double CentroenX= rectangulo.getCenterX();/*lo que se almacena en esta variable es donde se encuentra el centro del rectangulo en el ejex*/
		double Centroeny= rectangulo.getCenterY();/*lo que se almacena en esta variable es donde se encuentra el centro del rectangulo en el ejey*/
		
		/*luego se establece el radio del circulo:Para hacer la circunferencia circunscrita al rect�ngulo hay que aplicar el teorema de Pit�goras para 
		 * calcular la diagonal del rect�ngulo, la mitad de dicha diagonal es el radio de la circunferencia,*/
		double radio = Math.hypot(rectangulo.getWidth(), rectangulo.getHeight()) / 2.;/*hypot es una funci�n de Math que calcula la hipotenusa dados 
		los dos catetos de un tri�ngulo rect�ngulo.*/

		
		Ellipse2D circulo= new Ellipse2D.Double();
		circulo.setFrameFromCenter(CentroenX, Centroeny, CentroenX+radio, Centroeny+radio);/*seteando las coordeadas sobre el frame*/
		g2.draw(circulo);/*dibujando el circulo*/
	}
	
}