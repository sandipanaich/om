package com.sandipan.algorithms.hackerrank.array.easy;

import java.util.ArrayList;
import java.util.List;

public class Array2D {

	List<Integer>[] l = new ArrayList[2];
	
	public static void main(String[] args) {

		int[][] array = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };

		System.out.println(new Array2D().array2D(array));

	}

	private int array2D(int[][] arr) {
		int sum = Integer.MIN_VALUE;
		int max = 0;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1]
						+ arr[i + 2][j + 2];
				max = (sum > max) ? sum : max;
			}
		}
		return max;
	}

}
