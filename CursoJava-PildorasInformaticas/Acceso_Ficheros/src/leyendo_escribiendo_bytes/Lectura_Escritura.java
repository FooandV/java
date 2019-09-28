package leyendo_escribiendo_bytes;
import java.io.*;

public class Lectura_Escritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador=0;
		
		try{
			FileInputStream archivo_lectura= new FileInputStream("C:/Users/freyder/Desktop/Leyendo_Creando/imagen.jpeg");
			
			boolean final_ar= false;
			
			while(!final_ar){
				int byte_entrada= archivo_lectura.read();
				
				if(byte_entrada==-1){
					final_ar=true;
				}
			
				System.out.println(byte_entrada);
				contador++;
			}
			
			archivo_lectura.close();
		}catch(IOException e){
			System.out.println(contador);
			
		}
		
			
	}

}


