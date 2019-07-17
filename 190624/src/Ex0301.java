
public class Ex0301 {

	public static void main(String[] args) {
		// 배열
		int[] array = new int[5];
		System.out.println(array);
		array[0]=85;
		array[1]=70;
		array[2]=75;
		array[3]=80;
		array[4]=92;
		
		// 5명 점수의 합
		int totalScore = array[0]+array[1]+array[2]+array[3]+array[4];
		System.out.println(totalScore);
		
		// 5명의 점수 출력
		for (int i=0; i<array.length; i++) {
			System.out.println(i+"번 점수: "+array[i]);
		}

	}

}
