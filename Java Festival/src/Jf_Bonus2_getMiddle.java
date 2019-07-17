import java.util.Scanner;

public class Jf_Bonus2_getMiddle {

	public static void main(String[] args) {
		
		/* 가운데 글자 구하기
		 * getMiddle() 메소드 
		 * input:banana   output:na
		 * input:apple    output:p
		 * 
		*/
		
		System.out.println(getMiddle());
				
	}
	
	public static String getMiddle() {
		Scanner scan = new Scanner(System.in);
		System.out.println("단어를 입력하세요 : ");
		String word = scan.next();
		scan.close();
		int wordLen = word.length();
		int midIndex = wordLen/2;
		if (wordLen%2==1) {
			return ""+word.charAt(midIndex);
		} else {
			return word.charAt(midIndex-1)+""+word.charAt(midIndex);
		}

	}

}
