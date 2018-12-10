package com.sandipan.algorithms.recursion;

public class Palindrome {

	public static void main(String[] args) {
		
		System.out.println(isPalindrome("MALAYALAM"));
		System.out.println(isPalindrome("MALAALAM"));
		System.out.println(isPalindrome("HINDI"));
		System.out.println(isPalindrome("HINDII"));
	}

	
	private static boolean isPalindrome(String str)
	{
		return isPalindrome(str.toCharArray(), 0) > 0;
	}
	
	
	private static int isPalindrome(char[] str, int index)
	{
		if(str.length%2 == 0 && index == str.length/2)
			return index;

		if(str.length%2 != 0 && index == str.length/2)
			return index + 1;
		
		int nextIndex = isPalindrome(str, index+1);

		if(nextIndex == -1 || str[index] != str[nextIndex])
			return -1;
		else
			return nextIndex +1;
	}
	
}
