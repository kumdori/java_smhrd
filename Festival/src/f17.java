
public class f17 {

	public static void main(String[] args) {
		// fibonacci, input번째 항까지 인쇄.

		int input = 12;
		for (int i=1; i<=input; i++) {
			System.out.print(fibo(i)+" ");	
		}
		

	}
	
	public static int fibo(int n) {
		if (n==1 || n==2) {
			return 1;
		} else {
			return fibo(n-2)+fibo(n-1);
		}
	}

}
