package com.sandipan.algorithms.search;

public class PointOfMaxima {

	public static void main(String[] args) {
		System.out.println(new PointOfMaxima().find(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 0, 10));
		System.out.println(new PointOfMaxima().find(new int[] { 11, 9, 8, 7, 6, 5, 4, 3, 2, 1 }, 0, 10));
		System.out.println(new PointOfMaxima().find(new int[] { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0  }, 0, 10));
		System.out.println(new PointOfMaxima().find(new int[] { 1, 2, 12, 9, 8, 7, 6, 5, 4, 3 }, 0, 10));
		System.out.println(new PointOfMaxima().find(new int[] { 1, 2, 3, 4, 5, 13, 9, 8, 7, 0 }, 0, 10));
	}

	private int find(int[] array, int start, int end) {

		int pivot = (start + end) / 2;
		int lastArrayIndex = array.length - 1;

		if (pivot == 0 && array[0] > array[1])
			return array[0];
		else if (pivot == lastArrayIndex && array[lastArrayIndex] > array[lastArrayIndex - 1])
			return array[lastArrayIndex];

		if (array[pivot] > array[pivot - 1] && array[pivot] > array[pivot + 1])
			return array[pivot];
		else {
			if (array[pivot] > array[pivot - 1])
				return find(array, pivot + 1, end);
			else
				return find(array, start, pivot - 1);
		}
	}

}
