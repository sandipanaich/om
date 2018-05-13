
package com.sandipan.algorithms.sort;

public class Insertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		print(new Insertion().sort(new int[] { 2, 6, 4, 1, 3 }));
		print(new Insertion().sort(new int[] { }));
		print(new Insertion().sort(null));
	}

	private int[] sort(int[] array) {

		if (array != null && array.length > 1) {

			for (int i = 1; i < array.length; i++) {
				int key = array[i];
				int j = i - 1;
				
				while (j >= 0 && array[j] > key) {
					array[j + 1] = array[j];
					j--;
				}
				array[j+1] = key;
			}
		}
		return array;
	}

	private static void print(int[] array) {
		if(array == null)
			return;
		for (int a : array)
			System.out.print(a + " ");
	}
}
