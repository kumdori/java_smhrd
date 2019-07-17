import java.util.Scanner;

public class f12 {

	public static void main(String[] args) {
		// 1~5 11~6
		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int n = scan.nextInt();
		
		int[][] matriz = new int[n][n];
		int sum = 0;
		

		for (int i=0; i<n; i++) {
			sum=i+1;
			for (int j=0; j<n; j++) {
				matriz[i][j]=sum;
				sum+=n;
				
			}
		}
		for (int k=0; k<n; k++) {
			for (int l=0; l<n; l++) {
				System.out.print(matriz[k][l]+"\t");
			}
			System.out.println();
			
		}

	}

}
