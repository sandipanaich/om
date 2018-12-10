package com.sandipan.algorithms.sort;

import java.util.Arrays;
import java.util.Scanner;

import com.sandipan.algorithms.search.RepeatingNumberInSortedArray;

/**
 * 
 * @author Sandipan Aich
 *
 *         Given an array with positive and negative number, find a pair of
 *         numbers whose sum is closest to Zero.
 */
public class SumClosestToZero {

	public static void main(String[] args) {

		print(new SumClosestToZero().find(new int[] { 10, 20, 30, 40, 50, 1, 2 }));
		print(new SumClosestToZero().find(new int[] { 1, 60, -10, 70, -80, 85, -100,105 }));

/*		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int a0 = 0; a0 < t; a0++) {
			int m = in.nextInt();

			int[] arr = new int[m];
			for (int arr_i = 0; arr_i < m; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			print(new SumClosestToZero().find(arr));
		}
		in.close();*/
	}

	int[] find(int[] array) {

		if (array == null || array.length <= 1)
			return null;

		int index1 = 0;
		int index2 = 1;
		int diff = Math.abs(array[index1] + array[index2]);

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int newDiff = Math.abs(array[i] + array[j]);
				if (newDiff < diff) {
					diff = newDiff;
					index1 = i;
					index2 = j;
				}
			}
		}
		if (array[index2] < array[index1])
			return new int[] { array[index2], array[index1] };
		else
			return new int[] { array[index1], array[index2] };
	}

	int[] find2(int[] array) {

		if (array == null || array.length <= 1)
			return null;

		Arrays.sort(array);
		int index1 = 0;
		int index2 = 1;
		int diff = Math.abs(array[index1] + array[index2]);

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int newDiff = Math.abs(array[i] + array[j]);
				if (newDiff < diff) {
					diff = newDiff;
					index1 = i;
					index2 = j;
				}
			}
		}
		if (array[index2] < array[index1])
			return new int[] { array[index2], array[index1] };
		else
			return new int[] { array[index1], array[index2] };
	}
	
	private static void print(int[] array) {
		if (array == null)
			return;
		for (int a : array)
			System.out.print(a + " ");
		System.out.println();
	}
}
