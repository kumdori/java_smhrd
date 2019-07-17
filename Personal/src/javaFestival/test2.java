package javaFestival;

import java.util.Scanner;

// import javaFestival.
// 

public class test2 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	      System.out.print("정수 입력 : ");
	      int n = sc.nextInt();
	      int[][] array = new int[n][n];

	      for (int i = 0; i < n; i++) {
	         int sum = 1+i;
	         for (int j = 0; j < n; j++) {
	            array[i][j] = sum;
	            sum = sum+5;
	         }
	      }
	      for (int i = 0; i < n; i++) {
	         System.out.print("\n");
	         for (int j = 0; j < n; j++) {
	            System.out.print(array[i][j]+"\t");
	         }
	      }
	      sc.close();
	}

}
