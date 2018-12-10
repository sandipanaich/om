package com.sandipan.algorithms.recursion;

public class StringPermutations {

	public static void main(String[] args) {
		new StringPermutations().find(6, new char[6]);
	}
	
	public void find(int n, char[] arr)
	{
		if(n <= 0)
		{
			System.out.println(new String(arr));
			return;
		}
		arr[n-1] = '0';
		find(n-1, arr);
		arr[n-1] = '1';
		find(n-1, arr);
	}
}
