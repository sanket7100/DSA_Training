package com.sanket;

import java.util.Scanner;

public class FirstProgram {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		FirstProgram f = new FirstProgram();
		f.calculate();
		f.calculateByFormula();
		sc.close();
	}
	
	private void calculate() {
		
		long num = 0;
		long ans = 0;
		System.out.println("Enter number : ");
		num = sc.nextLong();
		long startTime = System.nanoTime();
		for(int i=0;i<=num;i++) {
			ans+=i;
		}
		
		System.out.println("sum is "+ ans);
		long endTime = System.nanoTime();
		
		System.out.println("time taken O(N) "+ (endTime - startTime) / 1000000);
	}
	
	private void calculateByFormula() {
		
		long num = 0;
		System.out.println("Enter number : ");
		num = sc.nextLong();
		long startTime = System.nanoTime();
		System.out.println("sum is " + num * (num+1)/2);
		long endTime = System.nanoTime();
		System.out.println("time taken by O(1) "+ (endTime - startTime) / 1000000);
	}
}
