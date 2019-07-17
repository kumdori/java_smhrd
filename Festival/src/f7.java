import java.util.Scanner;

public class f7 {

	public static void main(String[] args) {
		// 별 사다리 n~1
		
		 Scanner scan = new Scanner(System.in);
		 System.out.println("번호 입력 : ");
		 int n = scan.nextInt();
		 
		 for (int i=n; i>0; i--) {
			 
			 for (int j=0; j<i; j++) {
				 System.out.print("*"); 
			 }
			 System.out.println();
			 
		 }

	}

}
