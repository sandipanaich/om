package com.sandipan.algorithms.search;

import java.util.Scanner;

public class ZeroCount {

	public static void main(String[] args) {

		System.out.println(new ZeroCount().find(new int[] { 1, 1, 1, 0, 0 }));
		System.out.println(new ZeroCount().find(new int[] { 1, 0, 0, 0, 0 }));
		System.out.println(new ZeroCount().find(new int[] {}));
		System.out.println(new ZeroCount().find(new int[] { 1, 1, 1, 1, 1 }));
		System.out.println(new ZeroCount().find(new int[] { 0, 0, 0, 0, 0 }));
		System.out.println(new ZeroCount().find(null));
		
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int a0 = 0; a0 < t; a0++) {
			int m = in.nextInt();
			int[] arr = new int[m];
			for (int arr_i = 0; arr_i < m; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			System.out.println(new ZeroCount().find(arr));
		}
		in.close();
	}

	private int find(int[] array) {

		if (array == null)
			return 0;
		int start = 0;
		int end = array.length;

		if (start > end || array.length == 0)
			return 0;
		if (array[0] == 0)
			return array.length;
		else if (array[array.length - 1] == 1)
			return 0;

		return find(array, start, end);
	}

	private int find(int[] array, int start, int end) {

		int pivot = (start + end) / 2;

		if (array[pivot] == 1 && array[pivot + 1] == 0)
			return array.length - (pivot + 1);

		else if (array[pivot - 1] == 1 && array[pivot] == 0)
			return array.length - (pivot);

		else {
			if (array[pivot] == 0)
				return find(array, start, pivot - 1);
			else
				return find(array, pivot + 1, end);
		}
	}

}
