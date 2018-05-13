package com.sandipan.algorithms.hackerrank.search.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HackerlandRadioTransmitters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] x = new int[n];
		for (int x_i = 0; x_i < n; x_i++) {
			x[x_i] = in.nextInt();
		}
		int result = hackerlandRadioTransmitters(x, k);
		System.out.println(result);
		in.close();
	}

	static int hackerlandRadioTransmitters(int[] x, int k) {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(x);

		for (int i = 0; i < x.length; i++) {
			int j = i;
			
			if(i == x.length-1)
			{
				list.add(x[i]);
				break;
			}
			
			while ((j < x.length-1) && (x[j + 1] - x[i]) <= k)
				j++;
			
			list.add(x[j]);
			i=j;
			while ((j < x.length-1) && (x[j + 1] - x[i]) <= k)
				j++;
			
			i = j;
			
		}
		return list.size();
	}
}
