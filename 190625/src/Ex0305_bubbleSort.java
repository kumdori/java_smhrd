
public class Ex0305_bubbleSort {

	public static void main(String[] args) {
		// Bubble Sort
		// 가장 큰 값이 오른쪽으로

		int[] numList = { 11, 100, 17, 5, 50, 30, 20, 90, 80, 0 };

		int temp = 0;
		int count = 1;

		for (int j = 1; j < numList.length; j++) {
			for (int i = 0; i < numList.length - j; i++) {

				if (numList[i] > numList[i + 1]) {
					temp = numList[i + 1];
					numList[i + 1] = numList[i];
					numList[i] = temp;
				}
			}
			count++;
		}

		for (int k = 0; k < numList.length; k++) {
			System.out.print(numList[k] + " ");
		}
		System.out.println();
		System.out.println(count);

	}

}
