import javax.swing.JOptionPane;

public class Uso_Arrays_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] paises=new String[8];
		
		for (int i = 0; i < 8; i++) {
			
			paises[i]= JOptionPane.showInputDialog("Introduce el pa�s" + (i+1));
			
			
		}
		
		/*Bucle For each*/
		
		for(String elemento:paises){
			
			System.out.println("pais: " + " " + elemento);
			
		}
		

	}

}