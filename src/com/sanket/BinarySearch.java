package com.sanket;

import java.util.Scanner;

public class BinarySearch {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(findTargetWithBinary());
	}

	private static int findTargetWithBinary() {
		int arr[] = new int[1000];
		int target;
		for(int i=0;i<arr.length;i++) {
			arr[i] = i+1;
		}
		System.out.println("Enter value to find : ");
		target = sc.nextInt();
		long startTime = System.nanoTime();
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < target) low = mid + 1;
			else if (arr[mid] > target) high = mid-1;
			else {
				long endTime = System.nanoTime();
				System.out.println("time taken by O(1) "+ (endTime - startTime) / 1000000);
				return mid;
			}
		}
		return -1;
		
	}
}
