package com.sandipan.algorithms.sort;

public class Bubble {

	public static void main(String[] args) {
		print(new Bubble().sort(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }));
		print(new Bubble().sort(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
		print(new Bubble().sort(new int[] { 20 }));
		print(new Bubble().sort(new int[] { 2, 6, 4, 1, 3 }));
		print(new Bubble().sort(new int[] {}));
		print(new Bubble().sort(null));
	}

	private int[] sort(int[] array) {

		if (array == null || array.length <= 1)
			return array;

		for (int i = 0; i < array.length; i++) {

			for (int j = (array.length - 1); j > i; j--) {

				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}

		return array;
	}

	private static void print(int[] array) {
		if (array == null)
			return;
		for (int a : array)
			System.out.print(a + " ");
		System.out.println();
	}
}
