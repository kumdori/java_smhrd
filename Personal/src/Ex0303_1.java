
public class Ex0303_1 {

	public static void main(String[] args) {
		// 숫자의 개수를 세어서 개수만큼 ☆찍어봅시다!
		// 1 (3개) : ☆☆☆
		// 2 (5개) : ☆☆☆☆☆
		// 3 (3개) : ☆☆☆
		// 4 (4개) : ☆☆☆☆
		// 5 (5개) : ☆☆☆☆☆

		int[] array = { 3, 3, 3, 5, 5, 5, 1, 1, 2, 2, 2, 2, 2, 4, 4, 4, 4, 5, 5, 1 };
		int[] cnt = new int[5];
		
		for (int i=0; i<array.length; i++) {
			cnt[array[i]-1]++;
			
		}
		for (int j=0; j<cnt.length; j++) {
			for(int k=0; k<cnt[j]; k++) {
			System.out.print("■");	
			}
		    System.out.println();
		}

	}

}
