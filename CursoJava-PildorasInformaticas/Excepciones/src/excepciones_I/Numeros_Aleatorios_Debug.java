package excepciones_I;

import javax.swing.JOptionPane;



/**
 * @author freyder: este ejemplo se aprende a realizar Debugging
 *
 */
public class Numeros_Aleatorios_Debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int elementos=Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos en esta matriz"));
		int num_aleat[]= new int [elementos];
		
		for (int i=0; i<num_aleat.length; i++){
			num_aleat[i]=(int)(Math.random()*100);
		}
		for(int elem: num_aleat){
			System.out.println(elem);
		}

	}

}
