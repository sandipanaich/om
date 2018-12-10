package com.sandipan.algorithms.geeksforgeeks.arrays.hard;

import static com.sandipan.algorithms.util.Util.print;

import java.util.Scanner;

public class RearrangeArray {

	public static void main(String[] args) {

		/*
		 * Scanner in = new Scanner(System.in); int t = in.nextInt();
		 * 
		 * for (int i = 0; i < t; i++) { int n = in.nextInt(); int[] array = new
		 * int[n]; for (int j = 0; j < n; j++) { array[j] = in.nextInt(); }
		 * rearrange(array, 0, 0); print(array); } in.close();
		 */

		int[] array = new int[] { 5, 0, 3, 7, 1, 4, 6, 2 };
		print(array);
		// rearrange(array, 0, true, 0);
		rearrange(array, 0, true, 0, 0);
		print(array);
		// rearrange(array, 2, true, 2);
//		rearrange(array, 2, true, 2, 0);
//		print(array);
		/*
		 * rearrange(array, 2, true, 2); print(array);
		 */

		/* int[] */
		array = new int[] { 4, 0, 2, 1, 3 };
		rearrange(array, 0, true, 0, 0);
		print(array);

		rearrange(array, 2, true, 2, 2);
		print(array);

		array = new int[] { 1, 0 };
		rearrange(array, 0, true, 0, 0);
		print(array);

		array = new int[] { 3, 2, 0, 1 };
		rearrange(array, 0, true, 0, 0);
		print(array);

	}

	static int rearrange(int[] array, int index, boolean begin, int start, int leastContinuousAccessedValue) {
		if(index == leastContinuousAccessedValue+1)
			leastContinuousAccessedValue++;
		if (!begin && index == start) {
			begin = false;
			int num = array[index];
			array[index] = array[start];
			if(leastContinuousAccessedValue+1 < array.length)
			rearrange(array, leastContinuousAccessedValue+1, true, leastContinuousAccessedValue+1, leastContinuousAccessedValue+1);
			return num;
		} else {
			int num = array[index];
			array[index] = rearrange(array, array[index], false, start, leastContinuousAccessedValue);
			return num;
		}
	}

	/*
	 * static int rearrange(int[] array, int index, boolean begin, int start) {
	 * if (!begin && index == start) { begin = false; int num = array[index];
	 * array[index] = array[start]; return num; } else { //
	 * System.out.println(array[index]); int num = array[index]; array[index] =
	 * rearrange(array, array[index], false, start); return num; } }
	 * 
	 * static int rearrange(int[] array, int index, int count, int start) { if
	 * (count == array.length - 1 || index == start ) { int num = array[index];
	 * array[index] = array[start]; return num; } else {
	 * System.out.println(array[index]); int num = array[index]; array[index] =
	 * rearrange(array, array[index], count + 1, start); return num; }
	 * 
	 * 
	 * System.out.println(array[index]); int num = array[index]; if (count ==
	 * array.length-1) array[index] = array[0]; else array[index] =
	 * rearrange(array, array[index], count + 1); return num;
	 * 
	 * }
	 */

}
