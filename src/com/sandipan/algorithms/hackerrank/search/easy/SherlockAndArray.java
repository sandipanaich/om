package com.sandipan.algorithms.hackerrank.search.easy;

import java.util.Scanner;

public class SherlockAndArray {

	static String solve(int[] a) {

		if(a == null)
			return "NO";
			if(a.length == 1)
				return "YES";
		
		long leftSum = 0;
		long totalSum = 0;
		for (int i : a)
			totalSum += i;
		long rightSum = totalSum - a[0];

		for(int i = 1 ; i <  a.length ; i++)
		{
			leftSum += a[i-1];
			rightSum -= a[i];
			
			if(leftSum == rightSum)
				return "YES";
		}	
		return "NO";
	}

	public static void main(String[] args) {
		System.out.println(solve(new int[]{10,40,10,20,30}));
		System.out.println(solve(null));
	}
	
	public static void main2(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a0 = 0; a0 < T; a0++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			String result = solve(a);
			System.out.println(result);
		}
		in.close();
	}
}
