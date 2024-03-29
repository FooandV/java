package leyendo;

import java.io.*;


/**
 * @author freyder: ejemplo accediendo a la información almacenada en un fichero de texto, pero leyendo
 * los codigos pertenecientes a cada caracter, luego para pasar dichos codigos leidos el casting
 * los pasa a caracter para que pueda ser leido por humanos
 *
 */
public class Acceso_Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leer_Fichero accediendo=new Leer_Fichero();
		accediendo.lee();
	}

}

class Leer_Fichero{
	
	public void lee(){
		
		try {
			FileReader entrada=new FileReader("C:/Users/freyder/Desktop/ejemplo.txt");
			
			int c=0;/*con esto se consigue que cuando entre al bucle while lee el primer caracter*/
			
			while(c!=-1){//mientras c no haya llegado al final de los datos leidos por entrada.read()
				c=entrada.read();
				
				char letra= (char)c;//esta instruccion realiza el casteo de pasar lo almacenado en c q es la entrada
				//de los codigos de cada caracter a letras
				
				System.out.print(letra);
			}
			
			entrada.close();//se cierra el flujo de datos
			
		} catch (IOException e) {/*se debe capturar la excepcion controlada que se  obliga de la clase FileReader*/
			System.out.println("No se ha encontrado el archivo");
		}
	}
	
	
}