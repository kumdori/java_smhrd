
public class Ex0307_method {

	public static void main(String[] args) {
		/*
		 * Method
		 */
		int a = 7;
		int b = 15;

		System.out.println(makeDouble(a));
		System.out.println(biggerNum(a, b));

	}

	public static int makeDouble(int arg) {
		// 숫자를 입력하면 2배로 만들어 주는 Method를 만들어보자!
		int result = 0;
		result=arg*2;
		return result;
	}
	
	public static int biggerNum (int arg1, int arg2) {
		// 인자로 받은 2 숫자 중 큰 숫자를 돌려준다.
		if (arg1>arg2) {
			return arg1;
		} else if (arg2>arg1) {
			return arg2;
		} else {
		
		return -1;
		}

	}

}
