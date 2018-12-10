package com.sandipan.algorithms.recursion;

public class MaxInArray {

	public static void main(String[] args) {
		System.out.println(new MaxInArray().find(new int[]{12,1234,45,67,1}, 0));
	}
	
	private int find(int[] arr, int index)
	{
		if(index >= arr.length)
			return Integer.MIN_VALUE;
		
		int nextMax = find(arr, index+1);
		if(arr[index] > nextMax)
			return arr[index];
		else
			return nextMax;
	}
}
