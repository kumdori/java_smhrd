import java.util.Scanner;

public class f15 {

	public static void main(String[] args) {
		// 1, 2, 4, 7, 11
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int n=scan.nextInt();
		int sum=1;
		for (int i=0, j=0; i<n; i++, j++) {
			sum+=j;
			System.out.print(sum+" ");
		}
		

	}

}
