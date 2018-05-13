package com.sandipan.algorithms.search;

public class NonRepeatingInAnyDuplicatedArray {

	public static void main(String[] args) {
		System.out.println(new NonRepeatingInAnyDuplicatedArray().find(new int[]{1,1,2,2,3,3,4,4,5}));
	}
	
	private int find(int[] array)
	{
		int n = array[0];
		for(int i = 1; i <array.length;i++)
			n ^= array[i];
		return n;
	}

}
