import java.util.Scanner;

public class Ex0111 {

	public static void main(String[] args) {
		// 1. 시, 분, 초
		// 2. 잔돈 계산기 (36500)
		//     만원 3장, 오천원 1장, 천원 1장, 오백원 1개

		// 잔돈 계산기
		Scanner scan = new Scanner(System.in);
		System.out.print("잔돈 입력 (5만원 이하): ");
		int change = scan.nextInt();
		int manwon = change/10000;
		change = change-manwon*10000;
		int ochonwon = change/5000;
		change = change - ochonwon*5000;
		int chonwon = change/1000;
		change = change - chonwon*1000;
		int obekwon = change/500;
		change = change - obekwon*500;
		int bekwon = change/100;
		System.out.println("만원 " + manwon + "개, " + "오천원 " + ochonwon + "개, " + "천원 " + chonwon + "개, " + "오백원 " + obekwon + "개, " + "백원 " + bekwon + "개");
		scan.close();
	}

}
