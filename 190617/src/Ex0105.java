import java.util.Scanner;

public class Ex0105 {

	public static void main(String[] args) {
		// 섭씨, 화씨 변환 프로그램
		Scanner scan = new Scanner(System.in);
		System.out.println("1.섭씨->화씨  2.화씨 섭씨");
		System.out.print("원하는 변화 방식을 알려주세요: ");
		int option = scan.nextInt();
		if (option==1)  {
			System.out.println("**************");
			System.out.println("섭씨에서 화씨로 변환합니다.");
			System.out.println("**************");
			System.out.print("섭씨 온도를 입력하세요 : ");
			float celcius = scan.nextInt();
			double farenh = Math.round((celcius*9/5+32)*100)/100.0;
			System.out.println("화씨 온도는 " + farenh + "입니다.");
		}
		else {

			System.out.println("**************");
			System.out.println("화씨에서 섭씨로 변환합니다.");
			System.out.println("**************");
			System.out.print("화씨 온도를 입력하세요 : ");
			float farenh = scan.nextInt();
			double celcius = Math.round(((farenh - 32)*5/9)*100)/100.0;
			System.out.println("섭씨 온도는 " + celcius + "입니다.");

		}

	}
}