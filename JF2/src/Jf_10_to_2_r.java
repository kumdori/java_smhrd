import java.util.Scanner;

public class Jf_10_to_2_r {

	public static void main(String[] args) {
		// 10진수->2진수 변환기
				Scanner scan = new Scanner(System.in);
				System.out.print("10진수 입력 : ");
				int num = scan.nextInt();
				System.out.println(binCalc(num));

			}

			public static String binCalc(int arg) {
				String result = "";
				String last="";
				
				while (arg >= 2) {
					if (arg % 2 == 0) {
						result = "0"+result;
					} else {
						result += "1"+result;
					}
					arg = arg / 2;
				}
				last += arg % 2 == 1 ? "1" : "0";
				return last+result;

	}

}
