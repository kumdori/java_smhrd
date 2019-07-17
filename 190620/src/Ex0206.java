import java.util.Scanner;

public class Ex0206 {

	public static void main(String[] args) {
		// int 타입의 변수 num을 선언하고 키보드로 값을 입력받으세요.
		// 만약 num이 3의 배수이면서 5의 배수라면 "3과 5의 배수입니다"라고
		// 출력하는 프로그램을 만들어 보세요.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력해 주세요 : ");
		int num = scan.nextInt();
		if (num%3==0 && num%5==0) {
			System.out.println("3과 5의 배수입니다.");
		} else if (num%3==0) {
			System.out.println("3의 배수입니다.");
		} else if (num%5==0) {
			System.out.println("5의 배수입니다.");
		} else {
			System.out.println("3의 배수도 5의 배수도 아닙니다.");
		}
		scan.close();

	}

}
