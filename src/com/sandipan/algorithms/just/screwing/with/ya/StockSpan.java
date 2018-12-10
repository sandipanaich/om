package com.sandipan.algorithms.just.screwing.with.ya;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		int[] stocks = new int[]{100, 80, 60, 70, 60, 75, 85};

		System.out.println(Arrays.toString(spans(stocks)));
		
	}
	
	private static int[] spans(int[] stocks)
	{
		int[] spans = new int[stocks.length];
		
		Stack<Integer> stack = new Stack<>();
		spans[0] = 1;
		stack.push(0);
		
		for(int i = 1; i < stocks.length; i++)
		{
			while(!stack.isEmpty() && (stocks[stack.peek()] < stocks[i]))
				stack.pop();
			
			spans[i] = (stack.isEmpty()) ? (i+1) : (i - stack.peek());

			stack.push(i);
		}
		
		return spans;
	}
}
