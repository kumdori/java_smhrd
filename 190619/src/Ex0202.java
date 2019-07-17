import java.util.Scanner;

public class Ex0202 {

	public static void main(String[] args) {
		// 2 개의 정수를 입력 받아 큰 수에서 작은 수를 뺀 결과값을 출력하세요.
		// 첫 번째 정수 입력 : 10
		// 두 번째 정수 입력 : 45
		// 두 수의 차 : 35
		
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = scan.nextInt();
		
		int result = num1>num2?num1-num2:num2-num1;
		System.out.print("두 수의 차 : " + result);
		scan.close();

	}

}
