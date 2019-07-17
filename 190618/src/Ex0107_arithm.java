import java.util.Scanner;

public class Ex0107_arithm {

	public static void main(String[] args) {
		/* 1-7.산술연산자 예제
		 * 제주도에 다녀온 김모 씨는 n개의 귤을 샀다.
		 * 김모씨는 주위 사람들에게 귤을 나눠주려고 하는데 너무 많아서 문제가 생겼다.
		 * 김모씨는 귤을 한 사람당 50개씩 박스에 담아서 나눠주려고 합니다.
		 * 김모씨가 사온 귤의 수를 입력받아 사람들에게 줄 수 있는 박스의 수를 구해보세요.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("귤의 수 : ");
		int tanger = scan.nextInt();
		int box = tanger/50;
		System.out.println("사람들에게 나눠줄 수 있는 박스의 수는: "+ box);
		scan.close();
	}

}
