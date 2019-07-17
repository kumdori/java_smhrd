import java.util.Random;

public class f10 {

	public static void main(String[] args) {
		// 8칸 배열 랜덤 수, 가장 큰 수와 작은 수 출력
		
		Random rand = new Random();
		
		int[] array = new int[8];
		int len = array.length;
		int max = len;
				
		for (int i=0; i<len; i++) {
			array[i] = rand.nextInt(100);
		}
		
		int min = array[0];
		for (int j=0; j<len-1; j++) {
			if (array[j]>max) {
				max=array[j];
			}
			if (array[j]<min) {
				min=array[j];
			}
		}
		for (int k=0; k<len; k++) {
			System.out.print(array[k]+" ");
			
		}
		System.out.println();
		System.out.println("가장 큰 수 : "+max);
		System.out.println("가장 작은 수 : "+min);
		
	}

}
