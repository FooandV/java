package ficheros_directorios;
import java.io.*;



/**
 * @author freyder: En este ejercicio se crearan directorios
 *
 */
public class Creando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File ruta=new File("C:/Users/Freyder/Desktop/TATA/nuevo_directorio/pruebatexto.txt");/*constructor de la clase File y pide como arg un String*/
		
//		ruta.mkdir();/*el metodo mkdir() crea un nuevo directorio a partir del path o ruta que se le haya dado*/
		
		String archivo_destino=ruta.getAbsolutePath();
		
		try {
			ruta.createNewFile();/*el metodo createNewFile() crea un nuevo archivo y extiende de una excepcion IOexception*/
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Escribiendo accede_es=new Escribiendo();
		accede_es.escribir(archivo_destino);
		
	}

}
class Escribiendo{
	
	public void escribir(String ruta_archivo){
		
		String frase="Esto es una prueba de escritura";	
		
		try {
			FileWriter escritura=new FileWriter(ruta_archivo);/*se va a escribir en el archivo que esta alojado en archivo_destino */
			
			/*se rrecorre con un bucle for toda la frase e ir escribiendo caracter a caracter dentro del archivo*/
			for(int i=0; i<frase.length(); i++){
				escritura.write(frase.charAt(i));
			}
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
} 