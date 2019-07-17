
public class f23 {

	public static void main(String[] args) {
		// 2차원 배열 왼쪽으로 90도 회전하여 출력
		
		int[][] n = new int[5][5];
		int num = 1;
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				n[i][j] = num++; 
				
			}
		}
		
		for (int i=5-1; i>=0; i--) {
			for (int j=0; j<5; j++) {
				System.out.print(n[j][i]+"\t");
			}
			System.out.println();
		}
		
		

	}
}
	
//	public static int[][] rotate(int[][] a) {
//		int n=a.length;
//		int half = n/2;
//		for (int layer=0; layer<half; layer++) {
//			int first =  
//			int last = 
//		}
//			for (int j=0; j<5; j++) {
//	}

//}
