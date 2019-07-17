import java.util.Scanner;

public class Ex0202_minus {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = scan.nextInt();
		int diff = num1-num2;
		int result = diff>0?diff:-diff;
		System.out.print("두 수의 차 : " + result);
		scan.close();

	}

}
