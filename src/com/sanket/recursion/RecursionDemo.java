package com.sanket.recursion;

import java.util.Scanner;

public class RecursionDemo {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter number : ");
		int n = sc.nextInt();
		long factvalue = fact(n);
		System.out.println(n + "! = " + factvalue);
	}
	
	private static long fact(int n) {
		if(n==0 || n==1) return 1;
		return n*fact(n-1);
	}
}