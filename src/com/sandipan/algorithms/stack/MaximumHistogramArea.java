package com.sandipan.algorithms.stack;

import java.util.Stack;

public class MaximumHistogramArea {

	public static void main(String[] args) {
		int hist[] = { 6/*, 2, 5, 4, 5, 1, 6 */};
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}

	public static int getMaxArea(int[] hist, int n) {
		Stack<Integer> stack = new Stack<>();
		int index= 0;
		int maxArea = hist[0];
		
		while(index < n)
		{
			if(stack.isEmpty() || hist[index] > hist[stack.peek()] )
			{
				stack.push(index);
				index++;
			}
			else{
				if(!stack.isEmpty() && hist[stack.peek()] >= hist[index])
				{
					int prevIndex = stack.pop();
					int area = hist[index] * (index - prevIndex + 1);
					if(area > maxArea)
						maxArea = area;
				}
				
			}
			index++;
		}
		
		return maxArea;
	}

}
