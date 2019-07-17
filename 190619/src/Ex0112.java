import java.util.Scanner;

public class Ex0112 {

	public static void main(String[] args) {
		// 
		Scanner scan = new Scanner(System.in);
		System.out.print("금액>> ");
		int money =scan.nextInt(); // 전체 금액

		int cnt = money / 100000; // 10만원 수표 개수
		System.out.println(50000 + "원 개수 >> " + cnt);
		money = money % 50000;
		
		cnt = money / 50000; // 5만원 지폐 개수
		System.out.println(50000 + "원 개수 >> " + cnt);
		money = money % 50000;

		cnt = money / 10000; // 1만원 지폐 개수
		System.out.println(10000 + "원 개수 >> " + cnt);
		money = money % 10000;
		
		cnt = money / 5000; // 5천원 지폐 개수
		System.out.println(5000 + "원 개수 >> " + cnt);
		money = money % 5000;
		
		cnt = money / 1000; // 1천원 지폐 개수
		System.out.println(1000 + "원 개수 >> " + cnt);
		money = money % 1000;
		
		cnt = money / 500; // 5백원 동전 개수
		System.out.println(500 + "원 동전 개수>> " + cnt);
		money = money % 500;
		
		cnt = money / 100; // 1백원 동전 개수
		System.out.println(100 + "원 동전 개수>> " + cnt);
		money = money % 100;
		
		cnt = money / 50; // 50원 동전 개수
		System.out.println(50 + "원 동전 개수>> " + cnt);
		money = money % 50;
		
		cnt = money / 10; // 10원 동전 개수
		System.out.println(10 + "원 동전 개수>> " + cnt);
		
		scan.close();
	}

}
