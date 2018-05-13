package com.sandipan.algorithms.search;

import java.util.Scanner;

public class RepeatingNumberInSortedArray {

	public static void main(String[] args) {
		System.out.println(
				new RepeatingNumberInSortedArray().find(new int[] { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 11, 12 }, 0, 12));
		System.out.println(
				new RepeatingNumberInSortedArray().find(new int[] { 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }, 0, 12));
		System.out.println(new RepeatingNumberInSortedArray()
				.find(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12 }, 0, 12));
		System.out.println(
				new RepeatingNumberInSortedArray().find(new int[] { 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }, 0, 12));
		System.out.println(new RepeatingNumberInSortedArray()
				.find(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 12 }, 0, 12));
		System.out.println(new RepeatingNumberInSortedArray()
				.find(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }, 0, 12));
		System.out.println(new RepeatingNumberInSortedArray()
				.find(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }, 0, 12));
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int a0 = 0; a0 < t; a0++) {
			int m = in.nextInt();
			int[] arr = new int[m];
			for (int arr_i = 0; arr_i < m; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			System.out.println(new RepeatingNumberInSortedArray().find(arr, 0 , arr.length));
		}
		in.close();
	}

	private int find(int[] array, int start, int end) {

		if (array == null || start > end)
			return -1;

		int pivot = (start + end) / 2;

		// -----------------------
		if (pivot == 0 && array[0] != array[1])
			return -1;
		else if (pivot == 0)
			return array[0];

		if (pivot == (array.length - 1) && array[array.length - 1] != array[array.length - 2])
			return -1;
		else if (pivot == (array.length - 1))
			return array[array.length - 1];
		// -----------------------

		if ((array[pivot - 1] == array[pivot]) || (array[pivot] == array[pivot + 1]))
			return array[pivot];
		else {
			if (array[pivot] == pivot + 1)
				return find(array, pivot + 1, end);
			else
				return find(array, start, pivot - 1);
		}
	}
}
