package com.sandipan.algorithms.util;

public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Util().value();
	}
	
	private void value()
	{
		int n = 100;
		int[] arr = new int[n];
		arr[0] = 1;
		for(int i = 1 ; i < n; i++)
			arr[i] = n - i;
		
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void print(int[] array) {
		if (array == null)
			return;

		for (int a : array)
			System.out.print(a + " ");
		System.out.println();
	}
	
	public static void print(int[] array, int n) {
		if (array == null || n <= 0)
			return;

		
		for (int a = 0 ; a < n ; a++)
			System.out.print(array[a] + " ");
		System.out.println();
	}
}
