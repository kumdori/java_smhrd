
public class Ex0108_var {

	public static void main(String[] args) {
		// 변수 종류
		
		// 변수 사용법
		// 1. 선언 시에만 자료형을 붙인다.
		// 2. 같은 이름의 변수명 2개 이상 사용 X
		// 3. 대소문자를 구분한다.
		// 4. 변수에 값을 다시 넣으면 갱신
		
		int num = 3;
		num = 5;
		System.out.println(num);
		
		/* 책을 가지고 배운 것 체크하고 빠진 것 설명:
		 * Identifier 규칙
		 * 64쪽까지.
		 */
		
		// Boolean
		boolean isRunning = true;
		isRunning = false;
		System.out.println(isRunning);
		
		// Character
		char character = 'a';             // character -> 97
		System.out.println(character + 1);// character+1 -> 98
		character = (char)(character + 1);// 'casting' -> (char)(...)
		System.out.println(character);
		
		// Strings
		String hello = "안녕하세요";  // 책 65쪽. String == Reference Type
		System.out.println(hello);
		
		// Double
		double pi = 3.14;
		int pi2 = (int)pi;
		System.out.println(pi2);
		
		int fruit = 250;
		System.out.println(fruit/50); // 정수/정수=정수
		System.out.println(fruit/50.0); // 정수/실수=실수

	}

}
