
public class fibonacci {

	public static void main(String[] args) {
		// Fibonacci
		// n번째 항 값을 구하는 fibo() 메소드
		
		System.out.println(fibo(3));  //2
		System.out.println(fibo(5));  //5
		System.out.println(fibo(7));  //13
		System.out.println(fibo(50)); //??
		
		

	}

	private static long fibo(int num) {
		// n번째 항 값을 구하는 fibo() 메소드
		
		if (num==1 || num==2) {
			return 1;
		} else {
			return fibo(num-2)+fibo(num-1);
		}

	}

}
