import java.util.Scanner;

// import javaFestival.

public class Jf_30_array_numdia {

	public static void main(String[] args) {
		// 정방형 배열에 내용 채우기.

		Scanner scan = new Scanner(System.in);

		String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		System.out.print("행 개수 : ");
		int row = (scan.nextInt() + 1) / 2;
		int star = 4;
		int count = 0;
		char[][] matrix = new char[7][7];
		iniciarAzar(matrix, 7);

		System.out.println("Row : " + row + "," + star);

		for (int i = 0, j = 0; i < star * 2 - 1; i++) {
			for (int k = 0; k < j + star; k++) {
				if (k < (star - 1 - j)) {
					matrix[i][k]='0';
				} else {
					matrix[i][k]=alphabet.charAt(count++);
				}
			}
			if (i < star - 1) {
				j++;
			} else {
				j--;
			}
			System.out.println();
		}
		imprimir(matrix, 7);
		scan.close();

	}
	
	public static void rotar(char[][] matrix) {
		int n = matrix.length/2;
		int half = n/2;
		for (int layer = 0; layer < half / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int j = last - offset;
				char top = matrix[first][i]; // save top

				matrix[first][i] = matrix[j][layer];            // left -> top
				matrix[j][first] = matrix[last][j]; // bottom -> left
				matrix[last][j] = matrix[i][last];              // right -> bottom
				matrix[i][last] = top;             // right <- saved top // top -> right

			}
		}
	}
	
	public static void imprimir(char[][] matrix, int n) {
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public static void iniciarAzar(char[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = '0';  // matrix[i][j]=(int) (Math.random() * 1000);
				
			}
		}
	}

}
