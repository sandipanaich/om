package com.sandipan.algorithms.search;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new BinarySearch().find(new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10 }, 5, 0, 8));
		System.out.println(new BinarySearch().find(new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10 }, 6, 0, 8));
		System.out.println(new BinarySearch().find(new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10 }, 2, 0, 8));
		System.out.println(new BinarySearch().find(new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10 }, 9, 0, 8));
		System.out.println(new BinarySearch().find(new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10 }, 1, 0, 8));
		System.out.println(new BinarySearch().find(new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10 }, 10, 0, 8));
	}

	private boolean find(int[] array, int n, int start, int last) {

		if (array == null || (start > last))
			return false;

		int pivot = (start + last) / 2; // when the size of the array is 2^128

		if (array[pivot] == n)
			return true;
		else {
			if (array[pivot] > n)
				return find(array, n, start, pivot - 1);
			else
				return find(array, n, pivot + 1, last);
		}
	}

}
