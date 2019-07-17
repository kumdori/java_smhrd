import java.util.Random;

public class Ex0211_baseball {

	public static void main(String[] args) {
		// Step 1. 중복없이 숫자 3개 뽑기 (1~5)
		// Step 2. strike와 ball 개수 세기
		
		Random rand = new Random();
		
		// 변수 초기화
		int count = 0;
		int r = 5;
		int q = 3;
		int count2 = 0;
		String numlist = "";
		
		//랜덤 수 구하기
		while (count<q) {
			int number = rand.nextInt(r);
			
			//중복 체크하기
			while (count2<numlist.length()) {
				
			}
			 = number;
			count++;
		}
		
		System.out.println(numlist);
		
		

	}

}
