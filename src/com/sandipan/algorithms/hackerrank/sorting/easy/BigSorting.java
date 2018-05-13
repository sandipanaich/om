package com.sandipan.algorithms.hackerrank.sorting.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BigSorting {

	/*
	 * Complete the bigSorting function below.
	 */
	static String[] bigSorting(String[] unsorted) {

		for (int i = 0; i < unsorted.length; i++) {
			for (int j = i + 1; j < unsorted.length; j++) {

				if (unsorted[i].length() > unsorted[j].length()) {
					String temp = unsorted[i];
					unsorted[i] = unsorted[j];
					unsorted[j] = temp;
				} else if (unsorted[i].length() == unsorted[j].length()) {
					char[] str1 = unsorted[i].toCharArray();
					char[] str2 = unsorted[j].toCharArray();
					int index = 0;

					while ((index < str1.length) && str1[index] <= str2[index])
						index++;

					if(index < unsorted[i].length() && (str1[index] > str2[index])){
						String temp = unsorted[i];
						unsorted[i] = unsorted[j];
						unsorted[j] = temp;
					}
				}

			}
		}
		return unsorted;
	}

	public static void main(String[] args) {
		String[] a = new String[]{
				"31415926535897932384626433832795",
				"1",
				"3",
				"10",
				"3",
				"5"};
		String[] arr = bigSorting(a);
		
		for(String s : arr)
		System.out.println(s);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main2(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		String[] unsorted = new String[n];

		for (int unsortedItr = 0; unsortedItr < n; unsortedItr++) {
			String unsortedItem = scanner.nextLine();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
			unsorted[unsortedItr] = unsortedItem;
		}

		String[] result = bigSorting(unsorted);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(result[resultItr]);

			if (resultItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
