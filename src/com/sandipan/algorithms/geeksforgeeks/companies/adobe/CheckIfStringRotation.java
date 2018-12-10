package com.sandipan.algorithms.geeksforgeeks.companies.adobe;

import java.util.Scanner;

public class CheckIfStringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0 ; i < n; i ++)
			System.out.println(new CheckIfStringRotation().find(in.next(), in.next()));

		in.close();
	}
	
	private int find(String str1, String str2)
	{
		
		if(str1 == null || str2 == null || str1.length() != str2.length())
			return 0;
				
		for(int i = 0 ; i < str1.length(); i++)
		{
			if(str1.equals(str2))
				return 1;	
			str2 = rotate(str2);
		}
		return 0;
	}
	
	private String rotate(String str)
	{
		char[] arr = str.toCharArray();
		char temp = arr[0];
		for(int i = 1 ; i < arr.length; i++)
			arr[i-1] = arr[i];
		arr[arr.length - 1] = temp;
		return new String(arr);
	}
}
