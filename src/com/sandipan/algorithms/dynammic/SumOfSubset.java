package com.sandipan.algorithms.dynammic;

import java.util.Arrays;

public class SumOfSubset {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 4, 6 };
		int sum = 10;

		//  Sum of subset recursive solution.
		//System.out.println(sumOfSubsets(array, new int[array.length], 0, 4, sum));
		System.out.println(sumOfSubset(array, 0, new int[4], sum));
		System.out.println(sumOfSubset(array, 0, new int[4], 0));
		System.out.println(sumOfSubset(array, 0, new int[4], 1));
		System.out.println(sumOfSubset(array, 0, new int[4], 2));
		System.out.println(sumOfSubset(array, 0, new int[4], 3));
		System.out.println(sumOfSubset(array, 0, new int[4], 4));
		System.out.println(sumOfSubset(array, 0, new int[4], 5));
		System.out.println(sumOfSubset(array, 0, new int[4], 6));
		System.out.println(sumOfSubset(array, 0, new int[4], 7));
		System.out.println(sumOfSubset(array, 0, new int[4], 8));
		System.out.println(sumOfSubset(array, 0, new int[4], 9));
		System.out.println(sumOfSubset(array, 0, new int[4], 10));
		System.out.println(sumOfSubset(array, 0, new int[4], 11));
		System.out.println(sumOfSubset(array, 0, new int[4], 12));
		System.out.println(sumOfSubset(array, 0, new int[4], 13));
		System.out.println(sumOfSubset(array, 0, new int[4], 14));
		System.out.println(sumOfSubset(array, 0, new int[4], 15));
	}
	
	
	private static boolean sumOfSubset(int[] array, int i, int[] newArray, int target)
	{
		
		if(i >= array.length)
		{
			if(findSum(newArray) == target)
			{
				System.out.print(target + " :: " +Arrays.toString(newArray));
				return true;
			}
			else
				return false;
		}
		
/*		sumOfSubsets(array, i+1, Arrays.copyOf(newArray, newArray.length));
		newArray[i] = array[i];
		sumOfSubsets(array, i+1, Arrays.copyOf(newArray, newArray.length));
		newArray[i] = 0;*/
		
		boolean res = sumOfSubset(array, i+1, newArray, target);
		if(res)
			return true;
		newArray[i] = array[i];
		res = sumOfSubset(array, i+1, newArray, target);
		newArray[i] = 0;
		return res;
	}

	
	private static boolean sumOfSubsetTopDown(int[] array, int i, int[] newArray, int target)
	{
		
		if(i >= array.length)
		{
			if(findSum(newArray) == target)
			{
				System.out.print(target + " :: " +Arrays.toString(newArray));
				return true;
			}
			else
				return false;
		}
		
		boolean res = sumOfSubset(array, i+1, newArray, target);
		if(res)
			return true;
		newArray[i] = array[i];
		res = sumOfSubset(array, i+1, newArray, target);
		newArray[i] = 0;
		return res;
	}

	
	private static int findSum(int[] newArray)
	{
		int sum = 0 ; 
		for(int i : newArray)
			sum += i;
		return sum;
	}
}
