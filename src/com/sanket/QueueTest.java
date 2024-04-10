package com.sanket;

import java.util.ArrayList;

public class QueueTest {

	public static void main(String[] args) {
		
	}
}

class MyQueue{
	ArrayList<Integer> a;
	int start = -1;
	int end = -1;
	int size;
	
	public MyQueue(int capacity) {
		a = new ArrayList<>(size);
		size = capacity;
	}
	
	public void add(int x) {
		if(start==-1 && end==-1) {
			start = 0;
			end = 0;
			a.add(end, x);
		}
//		else if() {
//			
//		}
	}
}
