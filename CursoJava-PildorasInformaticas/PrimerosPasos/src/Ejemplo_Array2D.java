
public class Ejemplo_Array2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double interes=0.10;
		
		double acomulado;
		
		double[][]saldo=new double[6][5];
		
		for(int i=0; i<6; i++){
			
			acomulado=10000;
			saldo[i][0]=10000;
			
			for(int j=1; j<5; j++){
				
				acomulado= acomulado+ (acomulado*interes);
				saldo[i][j]=acomulado;
			}
			
			interes= interes + 0.01;
		}
		
		for(int z=0; z<6; z++) {
			System.out.println();
			
			for(int h=0; h<5; h++){
				System.out.printf("%1.2f",saldo[z][h]);
				
				System.out.println(" ");
			}
		}
	}

}
