import java.util.Scanner;

public class Ex0207 {

	public static void main(String[] args) {
		// int 타입의 변수 score를 선언하고 키보드로 값을 입력받으세요.
		// score가 90이상이면 "A학점입니다.",
		// 80점 이상 90점 미만일 경우  "B학점입니다",
		// 70점 이상 80점 미만일 경우  "C학점입니다"를 출력하세요.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력해 주세요 : ");
		int score = scan.nextInt();
		String alpha = "";
		
		if (score >= 90) {
			alpha = "A";
		} else if (score >= 80) {
			alpha = "B";
		} else if (score >= 70) {
			alpha = "C";
		} else {             // 초기값으로 DF를 설정하면 else가 없어도 됨.
			alpha = "DF";    // 1개 글자로 해결되면 alpha를 char 타입으로 지정.
		}
		System.out.println(alpha + "학점입니다.");
		scan.close();
	}

}
