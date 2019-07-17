import java.util.Scanner;

public class Ex0112_with_for {

	public static void main(String[] args) {
		// 일정 금액의 지페 동전 개수 구하기
		
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 입력해 주세요 : ");
		int money =scan.nextInt(); // 전체 금액
		int cnt = 0;
		int arrMoney[] = {100000, 50000, 10000, 5000, 1000, 500, 100, 50, 10};
		String strMoney[] = {"1십만", " 5만", " 1만", " 5천", " 1천", " 5백", " 1백", " 5십", " 1십"};

		for (int i=0; i<arrMoney.length; i++) {
			cnt = money / arrMoney[i]; // 지페 동전 개수
			System.out.println(strMoney[i] + "원 개수 : " + cnt);
			money = money % arrMoney[i];
		}
		
		scan.close();

	}

}
