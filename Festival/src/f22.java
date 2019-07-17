import java.util.Arrays;
import java.util.Scanner;

public class f22 {

	public static void main(String[] args) {
		// 5개 정수 입력, 오름차순 정렬하여 출력하는 프로그램
		
		Scanner scan = new Scanner(System.in);
		int[] n = new int[5];
		int count=0;
		for (int i=0; i<5; i++) {
			count++;
			System.out.print(count+"번 입력: ");
			n[i]=scan.nextInt();
		}
		Arrays.sort(n);
		
		for (int j=0; j<5; j++) {
			System.out.print(n[j]+" ");
		}

	}

}
