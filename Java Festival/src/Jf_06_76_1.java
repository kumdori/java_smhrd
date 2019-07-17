
public class Jf_06_76_1 {

	public static void main(String[] args) {
		// 77*1 + 76*2 + 75*3 + .... + 1*77 = ?
		// 총합 : 
		
		int total = 0;
		int maxNum = 77;
		int minNum = 1;
		
		for (int i=minNum, j=maxNum; i<=maxNum; i++, j--) {
			total += j*i;
			System.out.print(j+"x"+i+"+");
		}
		System.out.println();
		System.out.println("합계 : "+total);

	}

}
