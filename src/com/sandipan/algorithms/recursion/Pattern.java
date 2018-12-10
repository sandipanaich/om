package com.sandipan.algorithms.recursion;

public class Pattern {

	public static void main(String[] args) {
		new Pattern().display(10);
	}

	private void display(int n)
	{
		System.out.print(n + " ");

		if(n < 0)
			return;
		display(n-5);
		
		System.out.print(n + " ");
	}
	
}
