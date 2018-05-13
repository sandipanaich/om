package com.sandipan.algorithms.search;

public class NonRepeatingNumberInSortedArrayOfRepeatingNumbers {

	public static void main(String[] args) {
		System.out.println(new NonRepeatingNumberInSortedArrayOfRepeatingNumbers()
				.find(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 }, 0, 12));
		System.out.println(new NonRepeatingNumberInSortedArrayOfRepeatingNumbers()
				.find(new int[] { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 }, 0, 11));
		System.out.println(new NonRepeatingNumberInSortedArrayOfRepeatingNumbers()
				.find(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6 }, 0, 11));
		System.out.println(new NonRepeatingNumberInSortedArrayOfRepeatingNumbers()
				.find(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6 }, 0, 11));
		System.out.println(new NonRepeatingNumberInSortedArrayOfRepeatingNumbers()
				.find(new int[] { 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6 }, 0, 11));
		System.out.println(new NonRepeatingNumberInSortedArrayOfRepeatingNumbers()
				.find(new int[] { 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 }, 0, 11));
		System.out.println(new NonRepeatingNumberInSortedArrayOfRepeatingNumbers()
				.find(new int[] { 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6 }, 0, 11));
		System.out.println(new NonRepeatingNumberInSortedArrayOfRepeatingNumbers()
				.find(new int[] { 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6 }, 0, 11));
	}

	private int find(int[] array, int start, int end) {

		if (array == null || start > end)
			return -1;

		int pivot = (start + end) / 2;

		if (pivot == 0 && array[0] != array[1])
			return array[0];
		else if (pivot == 0)
			return -1;

		if (pivot == (array.length - 1) && array[array.length - 1] != array[array.length - 2])
			return array[(array.length - 1)];
		else if (pivot == (array.length - 1))
			return -1;

		if ((array[pivot] != array[pivot - 1]) && (array[pivot] != array[pivot + 1]))
			return array[pivot];
		else {
			if (pivot % 2 == 0 && array[pivot] == array[pivot + 1])
				return find(array, pivot + 1, end);
			else if (pivot % 2 == 0)
				return find(array, start, pivot - 1);
			else if (pivot % 2 != 0 && array[pivot] == array[pivot - 1])
				return find(array, pivot + 1, end);
			else// if (pivot % 2 != 0)
				return find(array, start, pivot - 1);
		}
	}
}
