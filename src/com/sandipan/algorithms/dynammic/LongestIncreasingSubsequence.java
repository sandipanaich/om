/**********************************************************************************************************
 * Copyright 2019, Sandipan Aich <sandipanaich@gmail.com>
 * 
 * This file is a part of project Om.
 * Om CAN be copied/and or distributed only for FREE, without any express permission of Sandipan Aich.
 * Unauthorized copying of this file, via any medium is highly encouraged.
**********************************************************************************************************/

package com.sandipan.algorithms.dynammic;

import java.util.Arrays;
import java.util.Collections;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

/**
 * Implementation for the problem of Longest Increasing Subsequence.
 * @author Sandipan Aich
 * @since 19 Feb 2019
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) 
	{
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		
		int[][] array2D = new int[][]
				{
					 { 1 },
					 { 1, 2 },
					 { 1, 2, 5 },
					 { 1, 2, 5, 3 },
					 { 1, 2, 5, 3, 4 },
					 { 1, 2, 5, 3, 4, 29 },
					 { 1, 2, 5, 3, 4, 29, 30 },
					 { 1, 2, 5, 3, 4, 29, 30, 16 },
					 { 1, 2, 5, 3, 4, 29, 30, 16, 17 },
					 { 1, 2, 5, 3, 4, 29, 30, 16, 17, 18 },
					 { 1, 2, 5, 3, 4, 29, 30, 16, 17, 18, 6 },
					 { 1, 2, 5, 3, 4, 29, 30, 16, 17, 18, 6, 7 },
					 { 1, 2, 5, 3, 4, 29, 30, 16, 17, 18, 6, 7, 8 },
					 { 1, 2, 5, 3, 4, 29, 30, 16, 17, 18, 6, 7, 8, 9 },
				};
				
		for(int[] array : array2D)
			System.out.println("LIS for {" + Joiner.on(",").join(Ints.asList(array)) + "} :: " + lis.lis(array));		
	}
	
	/**
	 * Implementation of the solution for longest increasing subsequence using the 
	 * Dynamic Programming Approach.
	 * @param array
	 * @return Returns the size of the longest increasing subsequence.
	 */
	public int lis(int[] array)
	{
		if(array.length <= 1)
			return 1;
		
		int lis[] = new int[array.length];
		Arrays.fill(lis, 1);
		
		for(int i = 1; i < array.length; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if((array[i] > array[j]) && (lis[i] < lis[j]+1))
					lis[i] = lis[j] + 1;
			}
		}

		return Collections.max(Ints.asList(lis));
	}

}
