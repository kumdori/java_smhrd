import java.util.Scanner;

public class Ex0215 {

	public static void main(String[] args) {
		// 3-4 for문 예제
		//원하는 단을 입력 받아 구구단을 출력하세요
		Scanner scan = new Scanner(System.in);
		
		System.out.print("단수를 입력해 주세요 : ");
		int dansu = scan.nextInt();
		for (int i=1; i<10; i++) {
			System.out.println(dansu+"*"+i+"="+dansu*i);
		}
		scan.close();

	}

}
