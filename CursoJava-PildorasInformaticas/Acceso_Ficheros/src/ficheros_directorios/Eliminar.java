package ficheros_directorios;

import java.io.File;


/**
 * @author freyder
 * ejemplo que elimina un directorio o archivo
 *
 */
public class Eliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File ruta=new File("C:/Users/Freyder/Desktop/TATA/nuevo_directorio/pruebatexto.txt");/*constructor de la clase File y pide como arg un String*/
		
		ruta.delete();
	
	
	}

}
