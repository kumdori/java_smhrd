import java.util.Random;

public class Ex0304_maxval {

	public static void main(String[] args) {
		// Max값 찾기
		// int 배열 10칸 만들어 주세요
		// 1~500까지 랜덤수 채워주세요
		
		Random rand=new Random();
		int[] array = new int[10];
		
		//랜덤 번호 대입
		for (int i=0; i<array.length; i++) {
			array[i]=rand.nextInt(500)+1;
		}
		// 랜덤 번호 출력
		for (int j=0; j<array.length; j++) {
			System.out.print(array[j]+" ");
		}
		
		// 큰 값 찾기
		int maxNum=array[0];
		for (int k=0; k<array.length; k++) {
			if (array[k]>maxNum) {
				maxNum=array[k];
			}
		}
		
		// 작은 값 찾기
		int minNum=array[0];
		for (int k=0; k<array.length; k++) {
			if (array[k]<minNum) {
				minNum=array[k];
			}
		}
		System.out.println();
		System.out.println("최대값은 : "+maxNum);
		System.out.println("최소값은 : "+minNum);

	}

}
