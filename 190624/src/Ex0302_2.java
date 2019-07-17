import java.util.Random;

public class Ex0302_2 {

	public static void main(String[] args) {
		// 정수형 데이터를 담을 수 있는 배열 array를 선언하세요.
		// 정수형 데이터 10개를 담을 수 있도록 array 배열을 생성하세요.
		// 각각의 인덱스에 1~20까지의 랜덤수를 초기화하세요.

		Random rand = new Random();

		int[] array = new int[10];
		int i;
		int count = 0;

		// 랜덤 번호 10개 뽑기
		for (i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(20) + 1;

			// 중복확인하기
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					i--; // 중복일 경우, 어레이 전 칸으로 돌리기
					break;
				}
			}

		}
		// 중복 제외된 랜덤번호 10개 출력하기
		System.out.print("랜덤번호 10개: ");
		for (int k = 0; k < array.length; k++) {
			System.out.print(array[k] + " ");
		}
		System.out.println();

		// 랜덤번호 10개 중 짝수면 출력하기
		System.out.print("짝수: ");
		for (int k = 0; k < array.length; k++) {
			if (array[k] % 2 == 0) {
				System.out.print(array[k] + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println("짝수 개수 : " + count);
	}

}
