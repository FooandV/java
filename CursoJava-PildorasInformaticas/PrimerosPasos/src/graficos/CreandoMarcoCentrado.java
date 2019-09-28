package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCentrado mimarco=new MarcoCentrado();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoCentrado extends JFrame{
	
	public MarcoCentrado() {		
		Toolkit mipantalla=Toolkit.getDefaultToolkit();/*Esta clase delega el comportamiento a la
		interfaz del sistema operativo, el metodo es estatico por lo que hay q acceder a el atravez
		de la clase y devuelve un objeto de tivo Toolkit segun la api.
		con esto se obtiene que en mipantalla se aloje el sistema nativo de ventanas de windows*/
		
		Dimension tamanoPantalla= mipantalla.getScreenSize();/*con esto es almacenar
		dentro de tamanoPantalla la resolución de mi pantalla, entonces en esta variable quedo alojado
		2560*1080 */
		
		/*De la clase Dimension puedo obtener el alto y ancho almacenado en tamanoPantalla*/
		int alturaPantalla= tamanoPantalla.height;
		int anchoPantalla= tamanoPantalla.width;
		
		setSize(alturaPantalla/2, anchoPantalla/2);/*este metodo establece el tamaño de los objetos
		tipo Dimension es decir setea el ancho y el alto para nuestro marco, como ya se tiene la 
		resolusión completa el proposito es que se presente el marco a la mitad por ello se utiliza 
		el metodo*/
		
		setLocation(anchoPantalla/4, alturaPantalla/4);/*con este metodo centro el marco*/
		//setBounds(800,300,alturaPantalla/2,anchoPantalla/2);
		setTitle("MarcoCentrado");
		
		setLocationRelativeTo(null);
		
		Image miIcono= mipantalla.getImage("coche-en-el-garaje.png");
		
		setIconImage(miIcono);/*metodo para establecer el icono en el marco o frame*/
			
	}
}
