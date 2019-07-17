
public class Ex0303 {

	public static void main(String[] args) {
		//숫자의 개수를 세어서 개수만큼 ☆찍어봅시다!
		// 1 (3개) : ☆☆☆
		// 2 (5개) : ☆☆☆☆☆
		// 3 (3개) : ☆☆☆
		// 4 (4개) : ☆☆☆☆
		// 5 (5개) : ☆☆☆☆☆
		
		int[] array = {3,3,3,5,5,5,1,1,2,2,2,2,2,4,4,4,4,5,5,1};
		int[] qty = new int[5];
		int count;
		
		//개수 세기
		for (int i=0; i<5; i++) {
			count=0;
			for (int j=0; j<array.length; j++) {
				if (array[j]==i+1) {       // array[num-1]++
					count++;               // 위처럼 하면 if문 쓸 필요 없음
				}
			}
			qty[i]=count;
	
		}
		for (int k=0; k<qty.length; k++) {
			System.out.print(k+1+" ("+qty[k]+"개) : ");
			for (int l=0; l<qty[k]; l++) {
				System.out.print("☆");
			}
			System.out.println();
		}
	}

}
