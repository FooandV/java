

public class Arrays_Matrix_Bidimencionales {

	public static void main(String[] args) {
		
		int[][] matrix={
				{10,5,85,54,2,4},
				{5,20,30,40,5,59},
				{35,3,23,99,33,6},
				{12,5,9,15,28,14},
		};
		/*
		matrix[0][0]=15;
		matrix[0][1]=21;
		matrix[0][2]=18;
		matrix[0][3]=9;
		matrix[0][4]=15;
		
		matrix[1][0]=10;
		matrix[1][1]=52;
		matrix[1][2]=17;
		matrix[1][3]=19;
		matrix[1][4]=7;

		matrix[2][0]=20;
		matrix[2][1]=30;
		matrix[2][2]=15;
		matrix[2][3]=56;
		matrix[2][4]=44;

		matrix[3][0]=11;
		matrix[3][1]=54;
		matrix[3][2]=03;
		matrix[3][3]=5;
		matrix[3][4]=35;
		*/
		for(int i=0; i<4; i++){
			
			System.out.println();
			
			for(int j=0; j<5; j++){
				
				System.out.print(matrix[i][j]+ " ");
				
			}
			
		}
  		
	}

}
