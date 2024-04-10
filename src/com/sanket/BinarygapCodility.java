package com.sanket;

public class BinarygapCodility {

	public static void main(String[] args) {
		int n = 247543670;
		int count = 0;
		int ans = 0;
		String binaryN = Integer.toBinaryString(n);
		System.out.println(binaryN);
		long startTime = System.nanoTime();
		for(int i=0;i<binaryN.length();i++) {
			if(binaryN.charAt(i)=='0') count++;
			else {
				ans = Math.max(ans,count);
				count = 0;
			}
		}
		
		long endTime = System.nanoTime();
		System.out.println("Total time taken by code "+ (endTime - startTime) / 1000000);
		
		System.out.println(ans);
		
	}
}
