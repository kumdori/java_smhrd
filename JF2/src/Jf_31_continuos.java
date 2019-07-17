import java.util.Scanner;

public class Jf_31_continuos {

	public static void main(String[] args) {
		// 입력받은 n을 연속 자연수로 표현할 수 있는 방법의 수를 알아내기.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("n 입력 : ");
		int n = scan.nextInt();
		int start = n/2+1;
		int total=0;
		int count=1;
		String cases="";
		
		for (int i=start; i>0; i--) {
			total=0;

			for (int j=i; j>0; j--) {
				total += j;
				System.out.println(total);
				if (total==n) {
					count++;
//					for 
//					cases=
					break;
				} else if (total>n) {
					break;
				}
			
			
			}
		 
		}
		System.out.println(count+"가지 방법.");
		scan.close();

	}

}
