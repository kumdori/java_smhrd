import java.util.Scanner;

public class Ex0103 {

	public static void main(String[] args) {
		// 사각형 넓이 계산하는 프로그램
		// 가로, 세로 입력해서 넓이를 계산해주세요.
		
		System.out.print("사각형의 가로를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int high = scan.nextInt();
		System.out.print("사각형의 세로를 입력하세요: ");
		int width = scan.nextInt(); 
		System.out.println("**********************************");
		System.err.println("사각형의 넓이는 " + high*width + "입니다.");
		System.out.println("**********************************");
		scan.close();


	}

}
