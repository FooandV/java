package ficheros_directorios;
import java.io.*;

public class Pruebas_rutas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		File archivo=new File("bin");
		
		System.out.println(archivo.getAbsolutePath());//con esto imprime la ruta absoluta del archivo, teniendo
		//como ruta por defaul la carpeta donde se encuentra alojado el proyecto donde se este laborando
		
		System.out.println(archivo.exists());//verifica si existe el archivo en la ruta especificada
	}

}
