package com.sandipan.algorithms.recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TowerOfHanoi().calculate(2, 'A', 'B', 'C');
	}

	private void calculate(int n, char a, char b, char c)
	{
		if(n == 1)
		{
			System.out.println("Move from rod " + a + " to " + c);
			return;
		}

		calculate(n-1, a, c, b);
		System.out.println("Move from rod " + a + " to " + c);
		calculate(n-1, b, a, c);
	}
}
