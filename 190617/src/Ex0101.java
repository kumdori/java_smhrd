
public class Ex0101 {
    // 출력연습
	public static void main(String[] args) {
		// main Method는 Compiler가 실행하기 위한 시작점이다.
		
		//숫자 출력
		System.out.println(100);
		System.out.println(200);
		
		//숫자 연산 출력
		System.out.println(10 + 10);
		System.out.println(10 * 10);
		
		//문자열 출력
		System.out.println("안녕하세요");
		System.out.println("100");
		
		//문자열 연산
		System.out.println("100" + "100"); // 문자열 덧셈 연산: 문자열 잇기
	//  System.out.println("안녕하세요" - "안"); 문자열 뺄셈 연산: 안됨
		System.out.println("핫도그" + 3 + "개"); // 문자열 덧셈 연산: 문자열 + 숫자
		System.out.println("핫도그" + 5 + 3); // 문자열 덧셈 연산: 문자열 + 숫자 + 숫자
		System.out.println("핫도그" + (5 + 3));



	}

}
