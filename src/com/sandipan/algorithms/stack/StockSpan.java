/**********************************************************************************************************
 * Copyright 2019, Sandipan Aich <sandipanaich@gmail.com>
 * 
 * This file is a part of project Om.
 * Om CAN be copied/and or distributed only for FREE, without any express permission of Sandipan Aich.
 * Unauthorized copying of this file, via any medium is highly encouraged.
**********************************************************************************************************/
package com.sandipan.algorithms.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * StockSpan implementation using Stack and simple arrays
 * 
 * @author Sandipan Aich
 *
 */

//{ 100, 80, 60, 70, 60, 75, 85, 110 }
//{   1   1   1   2   1   4   6    8 }

public class StockSpan {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new StockSpan().spans(new int[] { 100, 80, 60, 70, 60, 75, 85, 110 })));
		System.out.println(Arrays.toString(new StockSpan().spansWithStack(new int[] { 100, 80, 60, 70, 60, 75, 85, 110 })));
	}

	/**
	 * A Simple Stock Span implementation using arrays with time complexity for
	 * O(n^2)
	 * 
	 * @param stocks
	 * @return
	 */
	private int[] spans(int[] stocks) {
		int[] S = new int[stocks.length];

		for (int i = 0; i < stocks.length; i++) {
			int j = i;

			while (j >= 0 && stocks[i] >= stocks[j]) {
				S[i]++;
				j--;
			}
		}
		return S;
	}

	/**
	 * A Stock Span implementation using stack with time complexity for O(n)
	 * 
	 * @param stocks
	 * @return
	 */
	private int[] spansWithStack(int stocks[])
    {
        Stack<Integer> stack= new Stack<>();
        int[] S = new int[stocks.length];

        stack.push(0); 
        S[0] = 1;
         
        for (int i = 1; i < stocks.length; i++)
        {
            while (!stack.empty() && stocks[stack.peek()] <= stocks[i])
                stack.pop();
     
            S[i] = (stack.empty())? (i + 1) : (i - stack.peek());
     
            stack.push(i);
        }
		return S;
    }
}
