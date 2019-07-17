
public class fb3 {

	public static void main(String[] args) {
		// isHarshad()
		
		System.out.println(isHarshad(154));

	}

	private static boolean isHarshad(int n) {
		// TODO Auto-generated method stub
		int sum=0;
		int total=n;
		while(n!=0) {
			sum+=n%10;
//			System.out.println(sum+","+n);
			n=n/10;
		}
		if (total%sum==0) {
			return true;
		} else {
			return false;
		}
		
		
	}

}
