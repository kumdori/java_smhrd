
import java.util.Scanner;

public class f5 {

	public static void main(String[] args) {
		// 별 사다리 1-n까지
		
		Scanner scan = new Scanner(System.in);
		System.out.println("번호 : ");
		int n = scan.nextInt();
		
		for (int i=0; i<=n; i++) {
			
			for (int j=0; j<i; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}

	}

}
