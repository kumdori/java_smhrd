
public class Jf_Bonus2_getMiddle2 {

	public static void main(String[] args) {
		
		/* 가운데 글자 구하기
		 * getMiddle() 메소드 
		 * input:banana   output:na
		 * input:apple    output:p
		 * 
		*/
		String[] words = {"banana", "apple", "한글단어로", "한글단어로해봐요"};
		                  //8, 짝수   //5, 홀수     //5, 홀수      //8, 짝수 
		
		for (int i=0; i<words.length; i++) {
			System.out.println(getMiddle(words[i]));	
		}
		
	}
	
	public static String getMiddle(String word) {
		
		int wordLength = word.length();
		int middleIndex = wordLength/2;
		if (wordLength%2==1) {
			return ""+word.charAt(middleIndex);
		} else {
			return word.charAt(middleIndex-1)+""+word.charAt(middleIndex);
		}

	}

}
