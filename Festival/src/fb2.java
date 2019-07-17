
public class fb2 {

	public static void main(String[] args) {
		// bonus 2
		
		System.out.println(getMiddle("powered"));
		

	}

	private static String getMiddle(String s) {
		// TODO Auto-generated method stub
		String w="";
		int len = s.length();
		int mid = len/2;
		
		if (len%2==0) {
			w = ""+s.charAt(mid-1)+s.charAt(mid);
			return w;
		} else {
			
			w= ""+s.charAt(mid);
			return w;
		}

		
		
	}

}
