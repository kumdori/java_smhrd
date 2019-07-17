package javaFestival;

public class Matriz {

	public static void main(String args[]) {
		int[][] matrix = new int[6][6];
		rotar(matrix, 6);
		System.out.println("Input: ");
		imprimir(matrix, 6);
		rotar(matrix, 6);
		imprimir(matrix, 6);
	}

	public static void rotar(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			//--------------Starting an iteration of OUTER FOR LOOP------------------

			int last = n - 1 - layer;
			for (int i = layer; i < last; ++i) {
				int offset = i - layer;
				int buffer = matrix[layer][i]; // save top

				//--------------Starting an iteration of inner for loop------------------
				
				matrix[layer][i] = matrix[last - offset][layer];            // left -> top
				matrix[last - offset][layer] = matrix[last][last - offset]; // bottom -> left
				matrix[last][last - offset] = matrix[i][last];              // right -> bottom
				matrix[i][last] = buffer;             // right <- saved top // top -> right

			//--------------Finished an iteration of inner for loop------------------
			}
			
			//--------------Finished an iteration of OUTER FOR LOOP------------------

		}
	}

	public static void imprimir(int[][] matrix, int n) {
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static void iniciarAzar(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = (int) (Math.random() * 1000);
			}
		}
	}
	
	public static void iniciarCero(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	
	 public static int[][] rcolumna(int[][] matriz, int j){
	      int i2=matriz.length-1;
//	      System.out.println("j2:"+j2);
	      
	      for (int i1=0; i1<matriz.length/2; i1++, i2--) {
//	         System.out.println("j1:"+j1+",j2:"+j2+",l:"+matriz.length/2);
//	         System.out.println("Matriz:"+matriz[i][j1]+" "+matriz[i][j2]);
//	         System.out.println();
	         int temp = matriz[i1][j];
	         matriz[i1][j]=matriz[i2][j];
	         matriz[i2][j]=temp;
//	         System.out.println("Matriz:"+matriz[i][j1]+" "+matriz[i][j2]);
//	         System.out.println();
	      }
	      
	      return matriz;
	   }
	 
	 
	 public static int[][] rlinea(int[][] matriz, int i){
	      int j2=matriz.length-1;
//	      System.out.println("j2:"+j2);
	      
	      for (int j1=0; j1<matriz.length/2; j1++, j2--) {
//	         System.out.println("j1:"+j1+",j2:"+j2+",l:"+matriz.length/2);
//	         System.out.println("Matriz:"+matriz[i][j1]+" "+matriz[i][j2]);
//	         System.out.println();
	         int temp = matriz[i][j1];
	         matriz[i][j1]=matriz[i][j2];
	         matriz[i][j2]=temp;
//	         System.out.println("Matriz:"+matriz[i][j1]+" "+matriz[i][j2]);
//	         System.out.println();
	      }
	      
	      return matriz;
	   }

	 


}
