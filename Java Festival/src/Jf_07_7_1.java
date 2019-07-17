import java.util.Scanner;

public class Jf_07_7_1 {

	public static void main(String[] args) {
		// 행 개수를 입력 받아 다음과 같이 삼각형을 출력하시오.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("행 개수 : ");
		int row = scan.nextInt();
		
		for (int i=row; i>0; i--) {
			for (int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scan.close();

	}

}
