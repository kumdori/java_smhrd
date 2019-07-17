import java.util.Scanner;

public class Ex0110 {

	public static void main(String[] args) {
		// 산술연산자
		// 예제 1-5
		System.out.println("예제 1-5");
		System.out.println(10 + 7 + "");
		System.out.println(3 + "" + 5);
		System.out.println("" + 5 + 2);
		System.out.println("");
		
		//예제 1-8
		// 변수 num을 입력 받아 백의 자리 이하를 버리는 프로그램을 작성하시오.
		// 만일 변수 num의 값이 456이라면 400이 되고, 111이라면 100이 된다.
		System.out.println("예제 1-8");
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		int result = (num/100)*100;
		System.out.println("100 이하 수를 버리면 : " + result);
		scan.close();

	}

}
