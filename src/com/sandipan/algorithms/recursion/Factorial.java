package com.sandipan.algorithms.recursion;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Factorial().factorial(10));
	}
	
	
	long factorial(long n)
	{
		if(n <= 1)
			return 1;
		return factorial(n-1) * n;
	}
	

}
