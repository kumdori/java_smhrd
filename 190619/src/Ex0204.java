import java.util.Scanner;

public class Ex0204 {

	public static void main(String[] args) {
		/* 마트 계산대 프로그램입니다.
		   10000원짜리 추석선물세트를 구입했을 때 지불해야 하는 금액을 계산해 보세요.
		      단, 11개 이상 구매시에는 10% 할인이 됩니다.
		      화면예)
		  *********************
		     사려는 상품 갯수를 입력하세요.
		   9
		     가격은 90000원입니다.
		  *********************
		*/
		
		// 변수 할당
		int price = 10000;
		int d_qty = 11;
		double d_perc = 0.9;
		
		// 상품 개수 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("사려는 상품 갯수를 입력하세요 : ");
		int quantity = scan.nextInt();
		
		// 계산 및 출력 (삼항 if문)
		int total = quantity*price;
		double result = quantity>=d_qty?total*d_perc:total;
		System.out.println("가격은 " + result + "입니다.");
		scan.close();
		
		/* if문 구조
		 * double result = 0;
		 * if (quantity>=d_qty) {
		 *     result = total*d_perc;
		 * }
		 */
		
	}

}
