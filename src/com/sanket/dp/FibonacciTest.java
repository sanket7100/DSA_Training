package com.sanket.dp;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTest {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean f = true;
		System.out.println("Enter -1 to terminate the program.....");
		while(f) {
			System.out.println("Enter Number : ");
			int n = sc.nextInt();
			if(n<0) return;
			int[] arr = new int[n+1];
			Arrays.fill(arr, -1);
			System.out.println("fibonacci of "+n+" is "+fib(n,arr));
		}
		
	}
	
	//memoization
	public static int fib(int n, int[] arr) {
		
		if(n==1) return 1;
		if(n==0) return 0;
		
		if(arr[n]!=-1) return arr[n];
		
		arr[n] = fib(n-1,arr)+fib(n-2,arr);
		
		return arr[n];
	}
	
	
}
