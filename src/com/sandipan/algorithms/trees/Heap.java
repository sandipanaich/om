package com.sandipan.algorithms.trees;

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{10, 20, 18, 25, 30, 2, 10, 9, 6, 35, -4};
		new Heap().sort(array);
	}

	int[] array;

	private int left(int[] array, int i) 
	{
		int left = 2 * i;
		if (left > array[0])
			return i;
		return left;
	}

	private int right(int[] array, int i) 
	{
		int right = 2 * i + 1;
		if (right > array[0])
			return i;
		return right;
	}

	private void maxHeapify(int[] array, int i) 
	{
		int left = left(array, i);
		int right = right(array, i);

		int largest = (array[left] > array[right]) ? left : right;

		if (largest != i) {
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			maxHeapify(array, largest);
		}
	}

	private void buildHeap(int[] array, int n) 
	{
		for (int i = n / 2; i >= 1; i--) 
			maxHeapify(array, i);
	}

	public void sort(int[] array) 
	{
		buildHeap(array, array[0]);
		print(array);
		int size = array[0];
		
		while(size >= 1)
		{
			int temp = array[1];
			array[1] = array[size];
			array[size] = temp;
			maxHeapify(array, 1);
			print(array);
			size--;
		}
		
	}
	
	private void print(int[] array)
	{
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
	}
}
