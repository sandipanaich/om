package com.sandipan.algorithms.recursion;

public class KAryStrings {

	public static void main(String[] args) {
		new KAryStrings().find(new char[]{'a', 'b','c','d'}, 2, new char[2]);
	}
	
	public void find(char[] chars, int k, char[] arr)
	{
		if(k <= 0)
		{
			System.out.println(new String(arr));
			return;
		}

		for(char c : chars)
		{
			arr[k-1] = c;
			find(chars, k-1, arr);
		}
	}

}
