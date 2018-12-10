package com.sandipan.algorithms.recursion;

import java.util.Arrays;

public class VowelCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new VowelCount().vowelCount("Sandipan Aich".toUpperCase().toCharArray(), 0));
	}
	
	private int vowelCount(char[] array, int index)
	{
		if(index >= array.length)
			return 0;
				
		return vowelCount(array, index+1) + (isVowel(array[index]) ? 1 : 0);
	}
	
	private boolean isVowel(char c)
	{
		return (Arrays.binarySearch(new char[]{'A', 'E', 'I', 'O', 'U'}, c) > -1) ? true : false;
	}

}
