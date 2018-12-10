package com.sandipan.algorithms.recursion;

public class MinInArray {

	public static void main(String[] args) {
		System.out.println(new MinInArray().find(new int[] { 12, 1234, 45, 56, 1 }, 0));
	}

	private int find(int[] arr, int index) {
		if (index >= arr.length)
			return Integer.MAX_VALUE;

		int nextMin = find(arr, index + 1);
		if (arr[index] < nextMin)
			return arr[index];
		else
			return nextMin;
	}
}
