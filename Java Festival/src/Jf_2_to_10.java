import java.util.Scanner;

public class Jf_2_to_10 {

	public static void main(String[] args) {
		// 10진수->2진수 변환기
		Scanner scan = new Scanner(System.in);
		String binNum = "10110101";

		System.out.println(binNum+"(2) = "+digCalc(binNum)+"(10)");

		scan.close();

	}

	public static int digCalc(String arg) {
		char[] argChar = arg.toCharArray();
		int sum = 0;
		int count = 0;
		for (int i = argChar.length - 1; i >= 0; i--) {

			if (argChar[i] == '1') {
				sum += Math.pow(2, count);
//				System.out.println(argChar[i] + "," + sum + "," + count);
			}
			count++;

		}
		return sum;
	}

}
