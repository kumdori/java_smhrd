import java.util.Random;

public class Ex0302 {

	public static void main(String[] args) {
		// 정수형 데이터를 담을 수 있는 배열 array를 선언하세요.
		// 정수형 데이터 10개를 담을 수 있도록 array 배열을 생성하세요.
		// 각각의 인덱스에 1~20까지의 랜덤수를 초기화하세요.
		
		Random rand = new Random();
		
		int[] array = new int[10];
		int temp = 0;
		boolean repeated = false;
		int j;
		array[0]=rand.nextInt(20)+1;
		for (int i=1; i<array.length; i++) {
			temp = rand.nextInt(20)+1;
			System.out.println(temp+","+i+","+array[i]);
			for (j=0; j<i; j++) {
				if (temp==array[j]) {
					repeated=true;
					System.out.println(temp+","+array[j]+","+repeated);
					break;
				}
			}
			if (repeated=false) {
				array[i]=temp;
			} else {
				repeated=false;
			}
			
			System.out.print(array[i]+" ");
			
		}
		

	}

}
