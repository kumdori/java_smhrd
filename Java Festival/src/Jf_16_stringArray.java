import java.util.Scanner;

public class Jf_16_stringArray {

	public static void main(String[] args) {
		System.out.println(reverseStr());
		
	}

	private static String reverseStr() {
		/*
		 * Selection sort
		 * 문자열을 입력받아 알파벳순서대로 정렬하여 반환하는
		 * 메소드를 구현하시오. 단, 대소문자는 구분한다.
		 * reverseStr( )
		 * "ZAbcdVefEg" -> "AEVZbcdefg"
		 */

//		String a = "ZAbcdVefEg";
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열을 입력하세요 : ");
		String inputStr = scan.next();
		
		char[] numList = inputStr.toCharArray();

		char temp = 'A';
		int count = 1;
		char minNum='A';
		int minId=0;
		int i;
		int j;
		String result = "";

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
//			System.out.print(numList[k] + "");
			result += numList[k];
		}
		System.out.println();
		System.out.println(count);
		scan.close();
		return result;
		
	}

}
