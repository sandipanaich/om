package com.sandipan.algorithms.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PoisonousPlants {

	public static void main(String[] args) {

		// Scanner in = new Scanner(System.in);
		// int[] arr = new int[in.nextInt()];
		// for(int i = 0 ; i < arr.length ; i++)
		// arr[i] = in.nextInt();

		int[][] arr2D = { new int[]{6, 5, 8, 4, 7, 10, 9},
						new int[] { 6, 5, 8, 7, 4, 7, 3, 1, 1, 10 },
						new int[]{1, 3, 5, 2, 7, 6, 4, 2, 1}
		};

		for(int[] arr : arr2D)
			System.out.println(poisonousPlants(arr));

		// in.close();
	}


	private static int poisonousPlants(int[] arr) {
		//List<Integer> arr = new ArrayList<>(arrs);
		Stack<Integer> stack = new Stack<>();
		int days = 0;
		
		while (!allAlive(arr)) {
			stack.push(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				if (arr[i - 1] >= arr[i])
					stack.push(arr[i]);
			}
			
			arr = new int[stack.size()];
			int i = stack.size()-1;

			while(!stack.isEmpty())
				arr[i--] = stack.pop();
			
			
			days++;
		}
		return days;
	}
	
	private static boolean allAlive(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < arr[i])
				return false;
		}
		return true;
	}

}
