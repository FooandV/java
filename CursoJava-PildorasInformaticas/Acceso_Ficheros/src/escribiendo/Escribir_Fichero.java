package escribiendo;

import java.io.*;


/**
 * @author freyder: este ejemplo permite escribir sobre un archivo externo
 *
 */
public class Escribir_Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escribiendo accede_es=new  Escribiendo();
		accede_es.escribir();
	}

}

class Escribiendo{
	
	public void escribir(){
		
		String frase="Esto es una prueba de escritura en un archivo externo";	
		
		try {
			FileWriter escritura=new FileWriter("C:/Users/freyder/Desktop/texto_nuevo.txt");/*se crea el archivo*/
			
			for(int i=0; i<frase.length(); i++){
				escritura.write(frase.charAt(i));
			}
			escritura.close();
			System.out.println(escritura);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
} 