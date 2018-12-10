package com.sandipan.algorithms.just.screwing.with.ya;

public class ReverseAnArrayWithoutUsingLoop {

	public static void main(String[] args) 
	{
		System.out.println(new String(reverse("sandipan".toCharArray(), 0 , 7)));
	}

	private static char[] reverse(char[] array, int start, int end)
	{
		if(start >= end)
			return array;
		
		reverse(array, start+1, end-1);

		char temp = array[start];
		array[start] = array[end];
		array[end] = temp;

		return array;
	}
}
