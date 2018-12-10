package com.sandipan.algorithms.queue;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack = new Stack<>();
	
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	
	public int deque()
	{
		return stack.pop();
	}

	public void enqueue(int a)
	{
		Stack<Integer> s = new Stack<>();
		
		while(stack.isEmpty());
	}
	
}
