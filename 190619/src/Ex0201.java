
public class Ex0201 {

	public static void main(String[] args) {
		/* 2. 대입 연산자
		 * 	대입, 할당 연산자 '=' :  a=b,  a=b+1
		 *  복합 대입 연산자 : +=, -=, *=, /=, %=,    a+=b -> a = a + b  
		 *               &=, ^=, |=, ...         
		 * 
		 * 3. 증감 연산자
		 *  증가 연산자 '++' : ++변수, 변수++ (전위, 후위)
		 *  감소 연산자 '--' : --변수, 변수++ (전위, 후위)
		 *  
		 * 4. 비교 연산자
		 * <, <=, >, >=  :  a>b, a>=b
		 * ==, !=  :  a==b, a!=b   *결과값은 True or False
		 * 
		 * 5. 논리 연산자
		 *  NOT, AND, OR
		 *  !(NOT)                        !(피연산자)
		 *  &&(AND: 논리곱), ||(OR: 논리합)    (피연산자1)||(피연산자2)
		 *  
		 * 6. 삼항 연산자
		 *  간단한 제어 처리
		 *     ?  :        (조건문)?(실행문1):(실행문2)
		 *  
		 *  
		 *  
		*/  
				
		
		// 2-1 a += b
		
		// 2-2
		// int num=29;
		// num -= 2+3*4
		
		/* 3-1 예제 : 선/후 증가/차감
		int a = 5;
		int b = a++;
		int c = ++a;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println(++c); //전위 연산자
		System.out.println(c++); //후위 연산자
		*/


		/* 3-3
		int hap =0, j=0, k=0, L=0;
		hap = ++j + k++ + ++L;
		System.out.println(hap + "," + j + "," + k + "," + L);
		*/
		
		/* 3-4
		int a = 3, b = 4, c = 5, d = 5;
		a += 6 + --b;
		d *= 7 - c++;
		System.out.println(a + "," + b + "," + c + "," + d); // 12, 3, 6, 10 = 31
		*/
		
		/* 5-1
		boolean isRunning = true;
		isRunning = !isRunning;
		System.out.println(isRunning);
		*/
		
		/* 5-2
		boolean isRunning = true;
		System.out.println(isRunning);
		System.out.println(!isRunning);
		*/
		
		/* 6-1
		int i = 3;
		int j = 10;
		System.out.println(i==j?"같다":"다르다");
		*/
		
		// 6-2
		int j, k, l, result;
		j=10;
		k=20;
		l=30;
		result=j<k?k++:--l;
		System.out.println(result + "," + k + "," + l); // 20, 21, 30
		
	}

}
