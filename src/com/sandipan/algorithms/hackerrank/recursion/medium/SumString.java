package com.sandipan.algorithms.hackerrank.recursion.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int start = 6;
		// int mid = 7;
		// int end = 7;
		// int[] array = new int[] { 1, 2, 3, 4, 5, 1, 1, 7, 45 };
		// int[] array = new int[] { 1, 2, 3, 4, 5, 1, 1, 7, 45 };

/*		String number = "12243660";
		String[] numArrStr = number.split("");
		int[] array = new int[number.length()];
		int index = 0;
		for (String s : numArrStr)
			array[index++] = Integer.parseInt(s);*/

		// int[] array = new int[] { 1,2,2,4,3,6,6,0};
		// int[][] array2 = new int[array.length][array.length];
/*		int start = array.length - 2;
		int mid = array.length - 1;
		int end = array.length - 1;

		System.out.println(new SumString().findNum(array, start, mid - 1));
		System.out.println(new SumString().findNum(array, mid, end));
		System.out.println(new SumString().findNum(array, end + 1, array.length - 1));*/

		
		
		System.out.println("12243660 --> " + new SumString().isSumString("12243660"));
		System.out.println("1111112223 --> " + new SumString().isSumString("1111112223"));
		System.out.println("2368 --> " + new SumString().isSumString("2368"));
		System.out.println("123 --> " + new SumString().isSumString("123"));
		
/*		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i = 0; i < t ; i++)
			System.out.println(new SumString().isSumString(in.next()));
				
		in.close();*/
		
	}

	private int isSumString(String number) {
		String[] numArrStr = number.split("");
		int[] array = new int[number.length()];
		int index = 0;
		for (String s : numArrStr)
			array[index++] = Integer.parseInt(s);

/*		int start = array.length - 2;
		int mid = array.length - 1;
		int end = array.length - 1;*/
		
		int start = array.length - 3;
		int mid = array.length - 2;
		int end = array.length - 2;
		
//		int[][][] array2 = new int[array.length][array.length][array.length];
//		return new SumString().isSumString(array, start, mid, end, new HashMap<Index, Boolean>()) ? 1 : 0;
		
		return isSumString(array, start, mid, end) ? 1 : 0;
	}
	
	private boolean isSumString(int[] array, int start, int mid, int end, int[][][] array2) {

		if (start >= end || start < 0 || end <= 0 || start >= array.length || end >= array.length || mid <= start)
			return false;

		if(array2[start][mid][end] != 0)
		{
			return (array2[start][mid][end] == -1) ? false: true;
		}
		
		
		int a = findNum(array, start, mid - 1);
		int b = findNum(array, mid, end);
		int c = findNum(array, end + 1, array.length - 1);
		
/*		if (findNum(array, start, mid - 1) + findNum(array, mid, end) == findNum(array, end + 1, array.length - 1))
		{
			System.out.println("start: " + start + " :: mid: " + mid + " :: end: " + end);
			array2[start][mid][end] = 1;
			return true;
		}*/
		//if (findNum(array, start, mid - 1) + findNum(array, mid, end) == findNum(array, end + 1, array.length - 1))
		if((a + b ) == c)
		{
			System.out.println("start: " + start + " :: mid: " + mid + " :: end: " + end);
			array2[start][mid][end] = 1;
			return true;
		}
		else if((a + b ) > c)
		{
			System.out.println("start: " + start + " :: mid: " + mid + " :: end: " + end);
			array2[start][mid][end] = 1;
			return true;
		}
		else 
		{
			array2[start][mid][end] = -1;
			return isSumString(array, start - 1, mid, end, array2) || isSumString(array, start, mid - 1, end, array2)
					|| isSumString(array, end - 2, end - 1, end - 1, array2);
		}
	}

	private boolean isSumString(int[] array, int start, int mid, int end) {

		if (start >= end || start < 0 || end <= 0 || start >= array.length || end >= array.length || mid <= start)
			return false;

		if (findNum(array, start, mid - 1) + findNum(array, mid, end) == findNum(array, end + 1, array.length - 1))
		{
			//System.out.println("start: " + start + " :: mid: " + mid + " :: end: " + end);
			return true;
		}
		else if(findNum(array, start, mid - 1) + findNum(array, mid, end) > findNum(array, end + 1, array.length - 1))
		{
			return isSumString(array, end - 2, end - 1, end - 1);
		}
		else
			return isSumString(array, start - 1, mid, end) || isSumString(array, start, mid - 1, end)
					|| isSumString(array, end - 2, end - 1, end - 1);
	}

	
	private boolean isSumString2(int[] array, int start, int mid, int end) {

		if (start >= end || start < 0 || end <= 0 || start >= array.length || end >= array.length || mid <= start)
			return false;
		
		int a = findNum(array, start, mid - 1);
		int b = findNum(array, mid, end);
		int c = findNum(array, end + 1, array.length - 1);
		
		
//		if (findNum(array, start, mid - 1) + findNum(array, mid, end) == findNum(array, end + 1, array.length - 1))
		if((a + b ) == c)
		{
			//System.out.println("start: " + start + " :: mid: " + mid + " :: end: " + end);
			return true;
		}
		else if((a + b ) > c)
//		else if(findNum(array, start, mid - 1) + findNum(array, mid, end) > findNum(array, end + 1, array.length - 1))
		{
			return isSumString(array, end - 2, end - 1, end - 1);
		}
		else
			return isSumString(array, start - 1, mid, end) || isSumString(array, start, mid - 1, end);
					//|| isSumString(array, end - 2, end - 1, end - 1);
	}
	
	private int findNum(int[] array, int start, int end) {

		if (start > end || start < 0)
			return 0;

		int num = 0;
		for (int index = start; index <= end; index++) {
			num += array[index] * Math.pow(10, end -index);
		}
		return (num);
	}

	private static void print(String string) {

		System.out.println(string);
	}	
}
