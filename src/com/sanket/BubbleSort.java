package com.sanket;

import java.util.Scanner;

public class BubbleSort {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		bubbleSort();
		long endTime = System.nanoTime();
		System.out.println("Total time taken by Bubble Sort "+ (endTime - startTime) / 1000000);
	}
	
	public static void bubbleSort() {
		int arr[] = new int[100000];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int) (Math.random()*1000);
		}
		
		long startTime = System.nanoTime();
		for(int i=0;i<arr.length;i++) {
			for(int j = 0;j<arr.length-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		long endTime = System.nanoTime();
		System.out.println("time taken by Bubble Sort "+ (endTime - startTime) / 1000000);
	}
}
