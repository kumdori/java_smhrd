
public class bit_arithmetics_m {

	public static void main(String[] args) {
		// 10진수->2진수 변환기
		int num = 150;
		System.out.println(reverse(binCalc(num)));

	}
	public static String binCalc (int arg) {
		String result = "";
		while (arg>=2) {
			if (arg%2==0) {
				result += "0";
			} else {
				result += "1";
			}
			arg = arg/2;
		}
		result +=arg%2==1?"1":"0";
		return result;
	}
	
	public static String reverse(String arg) {
		String result="";
		char[] argChar = arg.toCharArray();
		char[] revChar = new char[argChar.length];
			
		for (int i=0, j=revChar.length-1; i<argChar.length; i++, j--) {
			revChar[j]=argChar[i];
		}
		
		result=new String(revChar);
		return result;
	}

}
