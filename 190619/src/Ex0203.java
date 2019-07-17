import java.util.Scanner;

public class Ex0203 {

	public static void main(String[] args) {
		// 농구공을 담기 위해 필요한 상자의 개수를 구하세요.
		// 상자 하나에는 농구공이 5개 들어갈 수 있습니다.
		// 만일 농구공이 23개라면 필요한 상자의 개수는 5개 입니다.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("몇 개의 농구공이 있습니까? ");
		int balls = scan.nextInt();
		int boxQ = 5;
		int boxNeed = balls%boxQ==0?balls/boxQ:(balls/boxQ)+1;
		System.out.println("공을 담기 위해 "+boxNeed+"개의 박스가 필요합니다.");
		scan.close();

	}

}
