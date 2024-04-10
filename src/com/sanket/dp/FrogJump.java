package com.sanket.dp;

import java.util.ArrayList;

public class FrogJump {

	public static void main(String[] args) {

		int arr[] = { 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0 };

		Solution s1 = new Solution();

		System.out.println(s1.solution(arr));
	}

}

class Solution {
	public int solution(int[] A) {
		if (A.length == 0)
			return 1;
		// Implement your solution here
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(1);
		int idx = 1;
		while (a.get(idx) <= A.length) {
			idx++;
			a.add(a.get(idx - 1) + a.get(idx - 2));
			// System.out.println(a.get(idx));
		}
		
		int[] arr = new int[A.length + 1];
		arr[arr.length - 1] = 1;
		
		for (int i = arr.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			boolean check = false;
			if (A[i] == 1) {
				int jmp = 0;
				for (int j = 0; j < a.size(); j++) {
					if (i + a.get(j) < arr.length && arr[i + a.get(j)] > 0) {
						jmp = arr[i + a.get(j)] + 1;
						min = Math.min(min, jmp);
						check = true;
					}
				}
				if (check) {
					arr[i] = min;
				} else {
					arr[i] = 0;
				}

			} else {
				arr[i] = 0;
			}
		}

		// for(int i = 0 ; i < arr.length ; i++){
		// System.out.println(arr[i]);
		// }

		int ans = Integer.MAX_VALUE;
		int idx2 = -1;
		boolean check = false;
		for (int i = 2; i < a.size(); i++) {
			int jmp = 0;
			if (idx2 + a.get(i) < arr.length && arr[idx2 + a.get(i)] > 0) {
				jmp = arr[idx2 + a.get(i)];
				ans = Math.min(ans, jmp);
				check = true;

			}
		}
		if (check) {
			return ans;
		}

		return -1;
	}
}
