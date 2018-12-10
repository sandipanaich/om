package com.sandipan.algorithms.dynammic;

import java.util.Arrays;

public class BinaryCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] dynamicResults = new int[n][];
///		binaryCombinationsDynamic(0, n, arr, new int[50][]);
		binaryCombinations(0, n, new int[n]);

	}
	
	private static void binaryCombinationsDynamic(int i, int n, int[] arr, int[][] dynamicResults)
	{
		
		if(i >= n)
		{
			System.out.println(Arrays.toString(arr));
			return;
		}
		
//		dynamicResults[] = binaryCombinations(i+1, n, arr, dynamicResults);
		arr[i] = 1;
		binaryCombinations(i+1, n, arr);
		arr[i] = 0;
	}
	
	private static void binaryCombinations(int i, int n, int[] arr)
	{
		
		if(i >= n)
		{
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		binaryCombinations(i+1, n, arr);
		arr[i] = 1;
		binaryCombinations(i+1, n, arr);
		arr[i] = 0;
	}
}
