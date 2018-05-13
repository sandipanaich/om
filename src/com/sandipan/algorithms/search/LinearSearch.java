package com.sandipan.algorithms.search;

public class LinearSearch {

	public static void main(String[] args) {
		
		System.out.println(new LinearSearch().find(new int[] { 6, 5, 4, 3, 7, 3, 2 }, 1));
		System.out.println(new LinearSearch().find(new int[] { 6, 5, 4, 3, 7, 3, 2, 1 }, 1));
		
	}

	private boolean find(int[] array, int n) {

		if(array == null)
			return false;
		
		for (int index = 0; index < array.length; index++) {
			if (array[index] == n)
				return true;
		}
		
		return false;
	}

}
