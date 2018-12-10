package com.sandipan.algorithms.backtracking;

public class TowerOfHanoi {

	public static void main(String[] args) {
		int n =4;
		char source = 'A'; 
		char auxillary =  'B';
		char destination = 'C';
		
		compute(n, source, auxillary, destination);
	}
	
	private static void compute(int n, char source, char auxillary, char destination)
	{
		if(n == 1)
		{
			System.out.println("Move from rod " + source + " to " + destination);
			return;
		}
		
		compute(n-1, source, destination, auxillary);
		System.out.println("Move from rod " + source + " to " + destination);		
		compute(n-1, auxillary, source, destination);		
	}

}
