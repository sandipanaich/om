package com.sandipan.algorithms.hackerrank.search.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MissingNumbers {

	static int[] missingNumbers(int[] arr, int[] brr) {

		Map<Integer, int[]> map = new HashMap<>();
		List<Integer> missingNumbers = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int[] countArr = map.get(arr[i]);
			if (countArr == null) {
				countArr = new int[2];
				map.put(arr[i], countArr);
			}
			countArr[0]++;
		}

		for (int i = 0; i < brr.length; i++) {
			int[] countArr = map.get(brr[i]);
			if (countArr == null) {
				countArr = new int[2];
				map.put(brr[i], countArr);
			}
			countArr[1]++;
		}

		for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
			int[] counts = entry.getValue();
			if (counts[0] != counts[1])
				missingNumbers.add(entry.getKey());
		}

		int[] missingNumberArr = new int[missingNumbers.size()];
		int index = 0;
		for (int num : missingNumbers)
			missingNumberArr[index++] = num;

		return missingNumberArr;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		int m = in.nextInt();
		int[] brr = new int[m];
		for (int brr_i = 0; brr_i < m; brr_i++) {
			brr[brr_i] = in.nextInt();
		}
		int[] result = missingNumbers(arr, brr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");

		in.close();
	}
}
