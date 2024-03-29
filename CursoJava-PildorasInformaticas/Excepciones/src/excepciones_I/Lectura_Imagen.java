package excepciones_I;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.*;

public class Lectura_Imagen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoImagen2 mimarco = new MarcoImagen2();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoImagen2 extends JFrame {

	public MarcoImagen2() {/* metodo constructor */
		// TODO Auto-generated constructor stub
		setTitle("Marco con imagen");
		setBounds(500, 300, 650, 500);
		LaminaConImagen2 milamina = new LaminaConImagen2();
		add(milamina);
	}

}

class LaminaConImagen2 extends JPanel {

	public LaminaConImagen2() {

		try {/*
				 * esta excepsion se pone con objeto de capturar el error cuando
				 * se ejecute la instruccion:imagen =ImageIO.read(miimagen);
				 * entonces se le dice a Java que intente reaimagen=
				 * ImageIO.read
				 */

			imagen = ImageIO.read(new File(
					"src/excepciones_I/bola_azul.gif"));/*
														 * para esta instruccion
														 * debemos crear una
														 * excepsion para que de
														 * soluci�n cuando no se
														 * encuentre el archivo
														 * en la ruta o otra
														 * cosa
														 */
		} catch (IOException e) {/*
									 * en caso de que sea cierto el error lo
									 * capture y diga:
									 */
			System.out.println("La imagen no se encuentra");
		}

	}

	@Override
	protected void paintComponent(Graphics g) throws NullPointerException {

		super.paintComponent(g);

		try {

			/*
			 * en el caso de que no sepa las medidas de la imagen se puede obtar
			 * de la siguiente manera:
			 */
			int anchuraImagen = imagen.getWidth(this);
			int alturaImagen = imagen.getHeight(this);

			g.drawImage(imagen, 0, 0, null);
			for (int i = 0; i < 300; i++) {
				for (int j = 0; j < 200; j++) {
					g.copyArea(0, 0, 15, 15, 15 * i, 15 * j);
				}
			}
		} catch (NullPointerException e) {
			g.drawString("No se ha podido cargar la imagen en las coordenadas:", 10, 10);
		}
	}

	private Image imagen;/*
							 * creando una variable de tipo Image, para almacenar
							 * la imagen que tenemos guardada en la carpeta
							 */

}
