package com.sandipan.algorithms.stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterNumber {

	public static void main(String[] args) {
		
/*		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		
		for(int i = 0 ; i < count; i++)
		{
			int[] array = new int[in.nextInt()];
			for(int j = 0; j < array.length; j++)
				array[j] = in.nextInt();
			printArray(new NextGreaterNumber().find(array));
		}
		in.close();*/

		printArray(new NextGreaterNumber().find(new int[]{4,5,2,25}));
		printArray(new NextGreaterNumber().find(new int[]{13,7,6,12}));
	}

	private int[] find(int[] arr) {

		int[] nge = new int[arr.length];
		Arrays.fill(nge, -1);
		Stack<Integer> s = new Stack<>();
		s.push(0);

		for (int i = 1; i < arr.length; i++) {
				while(!s.isEmpty() && arr[s.peek()] < arr[i])	
					nge[s.pop()] = arr[i];
				s.push(i);
		}
		return nge;
	}
	
	private static void printArray(int[] array)
	{
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
	}

}
