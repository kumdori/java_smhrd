
public class Jf_collatzNumber {

	public static void main(String[] args) {
		/*
		 * 1937년 Collatz란 사람에 의해 제기된 이 추측은
		 * 입력된 수가 짝수라면 2로 나누고, 홀수라면 3을 곱하고 1을 더한 다음
		 * 결과로 나온 수에 같은 작업을 1이 될 때까지 반복할 경우,
		 * 모든 수가 1이 됩니다.
		 * 입력된 수가 6이라면 6→3→10→5→16→8→4→2→1 이 되어
		 * 총 8번 만에 1이 됩니다.
		 * collatzNumber() 메소드를 만들어 입력된 수가
		 * 몇 번 만에 1이 되는지 반환해 주세요.
		 * 단, 500번을 반복해도 1이 되지 않는다면 –1을 반환해 주세요.
		 * 
		 * input:6   output:8
		 * input:9   output:19
		 * input:20   output:7
		 * input:7   output:16
		 */
		
		int number = collatzNumber(7);
		System.out.println(number);

	}

	private static int collatzNumber(int n) {
		// 
		int count=0;
		
		while(n!=1 || count>500) {
			if (n%2==0) {
				n/=2;
			} else {
				n=n*3+1;
			}
			count++;
		}
		if (n==1) {
		return count;
		} else {
			return -1;
		}

	}

}
