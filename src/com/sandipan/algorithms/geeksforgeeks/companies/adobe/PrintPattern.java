package com.sandipan.algorithms.geeksforgeeks.companies.adobe;

import java.util.Scanner;
import java.util.Stack;

public class PrintPattern {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner in = new Scanner(System.in);
		
		 int n = in.nextInt();
		
		 for(int i = 0 ; i < n; i++)
		 new PrintPattern().print(in.nextInt());
		 in.close();
	}

	private void printn(int x, int m) {
		boolean forward = true;
		int c = 2 * x - 1;
		int n = x;
		for (int i = 0; i < c; i++) {
			if (forward) {
				System.out.print(n);
				if (n > m)
					n--;
			} else {
				if (i >= c - (x - m))
					n++;
				System.out.print(n);
			}
			if (n <= m) {
				forward = false;
				n = m;
			}
		}
		System.out.println();
	}

	private void print(int n, int m) {
		
		if(m <= 0)
			return;
		if(m == 1)
		{
			printn(n, 1);
			return;
		}		
		printn(n, m);
		print(n, m - 1);
		printn(n, m);
	}
	
	private void print(int n) {
		print(n,n);
	}
		
}
