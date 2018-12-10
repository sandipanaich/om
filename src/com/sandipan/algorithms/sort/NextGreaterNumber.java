package com.sandipan.algorithms.sort;

import java.util.Arrays;
import java.util.Scanner;

import com.sandipan.algorithms.search.RepeatingNumberInSortedArray;

public class NextGreaterNumber {

	public static void main(String[] args) {
//		System.out.println(new NextGreaterNumber().find("218765"));
//		System.out.println(new NextGreaterNumber().find("287615"));
//		System.out.println(new NextGreaterNumber().find("287165"));
//		System.out.println(new NextGreaterNumber().find("281765"));
//		System.out.println(new NextGreaterNumber().find("128765"));
//		System.out.println(new NextGreaterNumber().find("1234"));
//		System.out.println(new NextGreaterNumber().find("1243"));
//		System.out.println(new NextGreaterNumber().find("1423"));
//		System.out.println(new NextGreaterNumber().find("4321"));
//		System.out.println(new NextGreaterNumber().find("12"));
//		System.out.println(new NextGreaterNumber().find("1"));
//		System.out.println(new NextGreaterNumber().find(""));
//		System.out.println(new NextGreaterNumber().find(null));

		print(new NextGreaterNumber().find2(new int[] { 2, 1, 8, 7, 6, 5 }));
		print(new NextGreaterNumber().find2(new int[] { 2, 8, 7, 6, 1, 5 }));
		print(new NextGreaterNumber().find2(new int[] { 2, 8, 7, 1, 6, 5 }));
		print(new NextGreaterNumber().find2(new int[] { 2, 8, 1, 7, 6, 5 }));
		print(new NextGreaterNumber().find2(new int[] { 1, 2, 8, 7, 6, 5 }));
		print(new NextGreaterNumber().find2(new int[] { 1, 2, 3, 4 }));
		print(new NextGreaterNumber().find2(new int[] { 1, 2, 4, 3 }));
		print(new NextGreaterNumber().find2(new int[] { 1, 4, 2, 3 }));
		print(new NextGreaterNumber().find2(new int[] { 4, 3, 2, 1 }));
		print(new NextGreaterNumber().find2(new int[] { 1, 2 }));
		print(new NextGreaterNumber().find2(new int[] { 1 }));
		print(new NextGreaterNumber().find2(new int[] {}));
		print(new NextGreaterNumber().find2(null));

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		for (int k = 0; k < t; k++) {
			int n = scanner.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
			}
			long start = System.currentTimeMillis();
			print(new NextGreaterNumber().find2(array));
			System.out.println( (System.currentTimeMillis() - start)/1000 + " sec");

		}
		scanner.close();
	}

	private String find(String numStr) {
		if (numStr == null || numStr.length() <= 1)
			return null;

		char[] number = numStr.toCharArray();
		for (int i = number.length - 1; i > 0; i--) {

			if (number[i] > number[i - 1]) // compare the adjacent numbers from
											// the end and look for the pair
											// when the first one is lesser than
											// the second.
			{
				int diff = number[i] - number[i - 1];
				int leastGreaterIndex = i;
				for (int j = i; j < number.length; j++) {
					if (number[j] > number[i - 1] && (diff > (number[j] - number[i - 1]))) { // look
																								// for
																								// the
																								// least
																								// digit
																								// in
																								// the
																								// second
																								// half
																								// which
																								// is
																								// greater
																								// that
																								// the
																								// first
																								// number
																								// of
																								// the
																								// pair.
						diff = (number[j] - number[i - 1]);
						leastGreaterIndex = j;
					}
				}

				char t = number[i - 1]; // swap the first number of the pair
										// with the least greater digit in the
										// rest of the array.
				number[i - 1] = number[leastGreaterIndex];
				number[leastGreaterIndex] = t;
				return new String(number);
			}
		}
		return null;
	}

	// private int[] find2(int[] number)//
	private int[] find2(int[] number) {
		if (number == null || number.length <= 1)
			return null;

		for (int i = number.length - 1; i > 0; i--) {

			if (number[i] > number[i - 1]) // compare the adjacent numbers from
											// the end and look for the pair
											// when the first one is lesser than
											// the second.
			{
				int diff = number[i] - number[i - 1];
				int leastGreaterIndex = i;
				for (int j = i; j < number.length; j++) {
					if (number[j] > number[i - 1] && (diff > (number[j] - number[i - 1]))) { 
						diff = (number[j] - number[i - 1]);
						leastGreaterIndex = j;
					}
				}

				int t = number[i - 1]; // swap the first number of the pair with
										// the least greater digit in the rest
										// of the array.
				number[i - 1] = number[leastGreaterIndex];
				number[leastGreaterIndex] = t;
				
				Arrays.sort(number, i, number.length);
				return number;
			}
		}
		return null;
	}

	
	private static void print(int[] array) {
		if (array == null)
			return;

		for (int a : array)
			System.out.print(a + " ");
		System.out.println();
	}
}
