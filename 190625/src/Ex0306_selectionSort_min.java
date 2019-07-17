
public class Ex0306_selectionSort_min {

	public static void main(String[] args) {
		/*
		 * Selection sort 가장 작은 원소 또는 작은 원소를 찾아 주어진 위치(리스트 처음/끝)을 교체해 나가는 정렬 방법
		 * 가장 작은 수를 앞에
		 */

		int[] numList = { 11, 100, 17, 5, 50, 30, 20, 90, 80, 0 };

		int temp = 0;
		int count = 1;
		int minNum=0;
		int minId=0;
		int i;
		int j;

		for (j = 0; j < numList.length; j++) {

			minNum = numList[j];
			minId = j;
			for (i = j; i < numList.length; i++) {
				if (minNum > numList[i]) {
					minNum = numList[i];
					minId = i;
					count++;
				}
			}
//			System.out.println(minNum + "," + minId);
			temp = numList[minId];
			numList[minId] = numList[j];
			numList[j] = temp;

		}
		for (int k = 0; k < numList.length; k++) {
			System.out.print(numList[k] + " ");
		}
		System.out.println();
		System.out.println(count);
	}

}
