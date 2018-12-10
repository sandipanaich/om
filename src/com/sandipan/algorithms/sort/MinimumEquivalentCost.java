package com.sandipan.algorithms.sort;

import java.util.Arrays;

public class MinimumEquivalentCost {

	public static void main(String[] args) {
		System.out.println(new MinimumEquivalentCost().find2(new int[] { 1, 2, 9, 7 }));
		System.out.println(new MinimumEquivalentCost().find2(new int[] { -12, 67, 45, 0 }));
		System.out.println(new MinimumEquivalentCost().find(new int[] { 1, 2, 9, 7 }));
		System.out.println(new MinimumEquivalentCost().find(new int[] { -12, 67, 45, 0 }));
	}

	private int find(int[] array) {

		if (array == null || array.length <= 0)
			return 0;

		int minCost = Math.abs(array[0] - array[1]);

		for (int i = 0; i < array.length; i++) {

			for (int j = i + 1; j < array.length; j++) {
				
				int cost = Math.abs(array[i] - array[j]);
				if (cost < minCost)
					minCost = cost;
			}
		}
		return minCost;
	}
	
	private int find2(int array[])
	{
		
		Arrays.sort(array); // sorts the array in nLogn time.
		
		int minCost = Math.abs(array[0] - array[1]);
		
		for(int i = 1 ; i < array.length-1; i++)
		{
			int cost = array[i+1] - array[i];
			if(cost < minCost)
				minCost = cost;
		}
		return minCost;
	}

}
