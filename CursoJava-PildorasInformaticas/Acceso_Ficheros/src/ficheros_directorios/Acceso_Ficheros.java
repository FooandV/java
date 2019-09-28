package ficheros_directorios;
import java.io.*;

public class Acceso_Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File ruta=new File("C:/Users/Freyder/Desktop/TATA");/*constructor de la clase File y pide como arg un String*/
		
		System.out.println(ruta.getAbsolutePath());
		
		String[]nombres_archivos= ruta.list();/*almacenamos en un array todo lo que hay en la ruta, hay q 
		tener en cuenta que el metodo list() retorna un array por ello la creacion del array*/
		
		/*se recorre el array con un bucle for*/
		for(int i=0; i<nombres_archivos.length; i++){
			System.out.println(nombres_archivos[i]);/*imprime lo que esta almacenado en el array, por ende
			se presenta un listado de los archivos o directorios que estan alojados en la ruta que se solicito
			analizar*/
		
			File f=new File(ruta.getAbsolutePath(), nombres_archivos[i]);/*constructor de la 
			clase File(String parent, String child), este pide el path o ruta padre y una hija, la hija es el nombre
			de cada elemento alojado en el array con su extension, esto sirve para luego validar con este ultimo
			parametro si es un directorio o un archivo de modo q si es un directorio o carpeta se ingresa a listar
			lo elementos internos*/
		
			if(f.isDirectory()){/*el metodo isDirectory() valida si la ruta es un directorio*/
				String[]archivos_subcarpeta=f.list();/*se crea un array para almacenar los archivos de las subcarpetas que existan*/
				
				for(int j=0; j<archivos_subcarpeta.length; j++){
					System.out.println(archivos_subcarpeta[j]);
				}
				
			}
		
		}
	}

}
