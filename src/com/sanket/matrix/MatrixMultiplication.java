package com.sanket.matrix;

import java.util.Scanner;

public class MatrixMultiplication {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
   
		int a[][];
		int b[][];
		int c[][];
  
		System.out.println("Enter rows and columns for 1st matrix");
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println("Enter rows and columns for 2st matrix");
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		if(n!=x) {
			System.out.println("Matrix Multiplication not possible");
			return;
		}
		
		a = new int[m][n];
		b = new int[x][y];
		c = new int[m][y];

//		1st matrix input
		System.out.println("Enter Elements of 1st Matrix : ");
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		
//		2nd matrix input
		System.out.println("Enter Elements of 2nd Matrix : ");
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[0].length;j++) {
				b[i][j]=sc.nextInt();
			}
		}
   
		//multiplication
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j] = 0;
				for (int k = 0; k < a[0].length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		
		System.out.println("Multiplication matrix is : ");
		
//		Answer Matrix
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
}
