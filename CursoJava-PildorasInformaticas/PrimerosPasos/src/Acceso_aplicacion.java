import javax.swing.*;

public class Acceso_aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String clave="Freyder";
		
		String pass="";
		
		while (clave.equals(pass)==false) {
			
			pass=JOptionPane.showInputDialog("Introduce la contraseña, por favor");
			
			if (clave.equals(pass)==false) {
				
				System.out.println("Clave incorrecta, intentelo de nuevo");
				
			}
			
		}
				System.out.println("la clave es correcta, acceso permitido");
	}

}
