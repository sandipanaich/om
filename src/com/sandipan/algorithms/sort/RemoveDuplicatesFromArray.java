package com.sandipan.algorithms.sort;

public class RemoveDuplicatesFromArray {

	public static void main(String[] args) 
	{
		System.out.println(find(new int[]{1,1,1,1,1,2,3,3,4,4}));
	}
	
	private static int find(int[] array)
	{
		int len = array.length;
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] == array[i-1])
				len--;
		}
		
		for(int i = 1; i < len; i++)
		{
			int j = i + 1;
			while(array[i] == array[i-1])
			{
				
			}
		}
		return len;
	}
}
