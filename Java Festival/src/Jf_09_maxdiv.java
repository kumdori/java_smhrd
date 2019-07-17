import java.util.Scanner;

public class Jf_09_maxdiv {

	public static void main(String[] args) {
		// 정수 2개를 입력 받아 최대공약수와 최소공배수 찾기

		Scanner scan = new Scanner(System.in);
		System.out.print("n을 입력해 주세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int count = 0;
		int[] arrDiv; //공약수 array

		
		// n을 입력받아서 약수 개수 세기
		
//		System.out.println(n2 + "의 약수 : ");
		for (int i = 1; i <= num1; i++) {
			if (num1 % i == 0) {
				count++;
			}
		}
		
		// 약수 넣을 array 만들기
		arrDiv = new int[count];
		
		// 약수 집어 넣기
		int count1=0;
		for (int i = 1; i <= num1; i++) {
			if (num1 % i == 0) {
				count1++;
				arrDiv[count1]=i;
				System.out.println(arrDiv[count1]);
			}
		}

	}

}
