package sorting;

import java.util.Scanner;

public class SelectionSort {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("enter no. of size of array");
		int n = sc.nextInt();
		int [] a = new int [n];
		for(int i=0;i<n;i++) {
			a[i] = (int) (Math.random()*100);
		}
		
//		printUnsortedArray(a);
		long start = System.currentTimeMillis();
		selectionSort(a);
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("time taken by Selection sort " + (System.currentTimeMillis()-start)+"ms");
		System.out.println("-------------------------------------------------------------------------------------------");
//		printSortedArray(a);
	}
	
	private static void printSortedArray(int[] a) {
		System.out.print("Sorted array : ");
		for(int i:a) {
			System.out.print(i+ " ");
		}
	}
	
	private static void printUnsortedArray(int[] a) {
		System.out.print("Sorted array : ");
		for(int i:a) {
			System.out.print(i+ " ");
		}
		System.out.println();
	}
	
	private static void selectionSort(int[] a) {
		
		for(int i = 0;i<a.length-1;i++) {
			int min = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[min]>a[j]) min = j;
			}
			
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
		
	}
}
