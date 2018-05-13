package com.sandipan.algorithms.hackerrank.search.easy;

import java.util.Scanner;

public class IceCreamParlour {

	static int[] icecreamParlor(int m, int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if ((arr[i] + arr[j]) == m)
					return new int[] { i+1, j+1 };
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int a0 = 0; a0 < t; a0++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			int[] result = icecreamParlor(m, arr);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
			}
			System.out.println("");

		}
		in.close();
	}
}
