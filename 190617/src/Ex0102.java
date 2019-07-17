import java.util.Scanner;

public class Ex0102 {
    // 클래스 이름은 파일명과 동일하게 해줘야 한다
	// 입력해 보기
	public static void main(String[] args) {
		
		// Scanner를 쓰기 위해서는 import 해야 함.
		// Scanner에 빨간 줄 쳐지면 Cntr+Shift+O하면 자동으로 import 명령 추가됨.
		Scanner scan = new Scanner(System.in);
		
		//프린트하고 바로 입력 받기 위해 println을 쓰지 않음.
		System.out.print("숫쟈를 입력하세요 >>");
		
		//변수에 입력 값을 할당하기
		int num = scan.nextInt(); // 정수를 입력하겠다.
		System.out.println(num + "의 두배는 "+ num*2+"입니다.");
		
		//scan 닫아주기
		scan.close();

	}

}
