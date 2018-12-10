package com.sandipan.algorithms.sort;

public class HeapSort {

	public static void main(String[] args) {
		int[] array = new int[]{10, 20, 18, 25, 30, 2, 10, 9, 6, 35, -4};
		HeapSort hs = new HeapSort();
		hs.sort(array);
		print(array);
	}

	private static void print(int[] array)
	{
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
	}

	private int left(int[] array, int i)
	{
		int left = 2 * i + 1;
		if(left <= array[0])
			return left;
		return i;
	}

	private int right(int[] array, int i)
	{
		int right = 2 * i + 2;
		if(right <= array[0])
			return right;
		return i;
	}
	
	private void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private void maxHeapify(int[] array, int i)
	{
		int left = left(array, i);
		int right = right(array, i);
		
		int largest = (array[left] > array[right]) ? left : right;
		
		if(largest != i)
		{
			swap(array, i, largest);
			maxHeapify(array, largest);
		}
	}
	
	private void buildHeap(int[] array)
	{
		int count = array[0]/2;
		while(count > 0)
		{
			maxHeapify(array, count);
			count--;
		}
	}
	
	public void sort(int[] array) 
	{
		buildHeap(array);
		print(array);
		while(array[0] > 0)
		{
			swap(array, 1, array[0]);
			array[0]--;
			maxHeapify(array, 1);
		}
	}
}
