package com.sandipan.algorithms.recursion;

public class ConsonantCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ConsonantCount().find("Sandipan Aich".toCharArray(), 0));
	}

	private int find(char[] arr, int index) {
		if (index >= arr.length)
			return 0;

		int count = 0;
		if (isConsonant(arr[index]))
			count++;

		return count + find(arr, index + 1);
	}

	private boolean isConsonant(char ch) {
		char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

		for (char c : vowels) {
			if (ch == c)
				return false;
		}
		
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			return true;
		return false;
	}
}
