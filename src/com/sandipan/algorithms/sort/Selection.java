package com.sandipan.algorithms.sort;

/**
 * 
 * @author Sandipan Aich
 * 
 * Any algorithm can be judged based on the number of comparisons and the number of swaps.
 * Bubble sort id probably is the worst sorting algorithm.
 */


public class Selection {

	public static void main(String[] args) {
		print(new Selection().sort(new int[]{4,3,2,1}));
		print(new Selection().sort(new int[] { 2, 6, 4, 1, 3 }));

	}

	private int[] sort(int[] array) {
		
		for(int i = 0 ;i < array.length-1; i++)
		{
			int minIndex = i;
			for(int j = i+1 ; j < array.length;j++)
			{
				if(array[minIndex] > array[j])
					minIndex = j;
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
		return array;
	}
	
	protected static void print(int[] array){
		
		if(array == null)
			return;
		
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
	}

}
