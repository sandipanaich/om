package com.sandipan.algorithms.recursion;

public class SameFirstLastSubstring {

	public static void main(String[] args) {
		System.out.println(new SameFirstLastSubstring().count("aba".toCharArray(), 0));
		System.out.println(new SameFirstLastSubstring().count("abcab".toCharArray(), 0));
	}

	private int count(char[] arr, int index)
	{
		if(arr == null || arr.length == 0 || index >= arr.length)
			return 0;
		
		int count = 0;
		
		for(int i = index; i < arr.length;i++)
			count += (arr[index] == arr[i]) ? 1 : 0;
		
		return count + count(arr, index+1);
	}
}
