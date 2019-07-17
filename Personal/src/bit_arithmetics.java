
public class bit_arithmetics {
	public static String binCalc (int a) {
		String strBinary = "";
		a /= 2;
		System.out.println("나누기");
		if (a>=2) {
			strBinary += binCalc(a);
			System.out.println("함수 부르기");
		} else if (a==1) {
			strBinary += "1";
			System.out.println("1더하기");
		} else {
			strBinary += "0";
			System.out.println("0더하기");
		}
		return strBinary;
	}

	public static void main(String[] args) {
		int a = 10;
		System.out.println(binCalc(a));
		
	}

}

// 비트연산 (Bit operation) 제2장. 87p.


// 비트 개념
//   byte a = 10; // 십진수
//   System.out.println(a);
// bit : 00001010  // 2진수

// 비트 논리 연산
// 1.AND '&'
   
// 2.OR '|'

// 3.XOR '^'

// 4.NOT '!'

// 10진수를 2진수로 표현하기
