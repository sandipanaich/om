/**********************************************************************************************************
 * Copyright 2019, Sandipan Aich <sandipanaich@gmail.com>
 * 
 * This file is a part of project Om.
 * Om CAN be copied/and or distributed only for FREE, without any express permission of Sandipan Aich.
 * Unauthorized copying of this file, via any medium is highly encouraged.
**********************************************************************************************************/
package com.sandipan.algorithms.dynammic;

/**
 * Fibonacci Series Implementation.
 * @author Sandipan Aich
 * @since 19 Feb 2019
 */
public class Fibonacci {

	public static void main(String[] args) 
	{
		Fibonacci series = new Fibonacci();
		int n = 10;
		System.out.println("Fibonacci :: main :: "+ n +"th value in Fibonacci Series using Bottom Up Dynamic Approach :: "+ series.fibSeriesBottomUp(n));
		System.out.println("Fibonacci :: main :: "+ n +"th value in Fibonacci Series using Top Down  Dynamic Approach :: "+ series.fibSeriesTopDown(n));
		System.out.println("Fibonacci :: main :: "+ n +"th value in Fibonacci Series using Recursive Approach :: "+ series.fibSeriesRecursive(n));
		System.out.println("Fibonacci :: main :: "+ n +"th value in Fibonacci Series using a Simpler Approach :: "+ series.fibSeries(n));
	}
	
	/**
	 * Fibonacci Series using the Bottom Up approach.
	 * @param n
	 * @return returns the value of the nth number in the Fibonacci Series.
	 */
	public long fibSeriesBottomUp(int n)
	{
		long[] series = new long[n];
		series[0]  =  series[1] = 1;
		
		for(int i = 2; i < n; i++)
			series[i] = series[i-2] + series[i-1];
		
		return series[n-1];
	}
	
	
	/**
	 * Fibonacci Series using the Top Down Approach.
	 * @param n
	 * @return the value of the nth number in the Fibonacci Series.
	 */
	public long fibSeriesTopDown(int n)
	{
		long[] series = new long[n];
		series[0]  =  series[1] = 1;
				
		return _fib( n, series);
	}
	
	private long _fib(int n, long[] series)
	{
		if(series[n-1] != 0)
			return series[n-1];
		
		return series[n-1] = _fib(n-1, series) + _fib(n-2, series);
	}
	
	/**
	 * Fibonacci Series using the Recursive Approach.
	 * @param n
	 * @returns the value of the nth number in the Fibonacci Series.
	 */
	public long fibSeriesRecursive(int n)
	{
		if(n <= 2)
			return 1;
		
		return fibSeriesRecursive(n-1) + fibSeriesRecursive(n-2);
	}

	
	/**
	 * Simple implementation Fibonacci Series.
	 * @param n
	 * @returns the value of the nth number in the Fibonacci Series.
	 */
	public long fibSeries(int n)
	{
		if(n <= 1)
			return 1;
		
		long a = 0;
		long b = 1;
		long c = a+b;
		for(int i=2; i<n; i++)
		{
			a = b;
			b = c;
			c = a + b;
		}
		
		return c;
	}

}
