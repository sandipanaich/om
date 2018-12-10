package com.sandipan.algorithms.stack;

import java.util.Stack;

public class StackSort {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-3);
		stack.push(14);
		stack.push(18);
		stack.push(-5);
		stack.push(30);
//		printStack(new StackSort().sort(stack));
//		printStack(new StackSort().sortAgain(stack));
		new StackSort().sort2(stack);
		printStack(stack);
	}

	
	
	private Stack<Integer> sortAgain(Stack<Integer> stack)
	{
		return sortAgain(stack, stack.pop());
	}
	
	private Stack<Integer>  sortAgain(Stack<Integer> stack, int x)
	{
		if(stack.isEmpty() || stack.peek() < x)
			stack.push(x);
		else
		{
			int y = stack.pop();
			sortAgain(stack, y);
			stack.push(y);
		}
		return stack;
	}
	
	
	private void sort2(Stack<Integer> stack)
	{
		if(stack.empty())
			return;
		
		int x = stack.pop();
		sort2(stack);
		
		if(stack.empty())
			return;
		
		if(x > stack.peek())
			stack.push(x);
		else
			sort22(stack, x);
		
	}
	
	private void sort22(Stack<Integer> stack, int num)
	{
		if(stack.isEmpty())
			return;
		if(stack.peek() < num)
			stack.push(num);
		else
		{
			int x = stack.pop();
			sort22(stack, num);
		}
		
	}
	
	private Stack<Integer> sort(Stack<Integer> stack)
	{
		Stack<Integer> stack1 = new Stack<>();
		stack1.push(stack.pop());
		Stack<Integer> stack2 = new Stack<>();

		while(!stack.empty())
		{
			int num = stack.pop();
			
			if(!stack1.isEmpty() && stack1.peek() < num)
				stack1.push(num);
			else
			{
				while(!stack1.isEmpty() && stack1.peek() > num)
					stack2.push(stack1.pop());
				stack1.push(num);
				while(!stack2.empty())
					stack1.push(stack2.pop());
			}
		}
		return stack1;
	}
	
	private static void printStack(Stack<Integer> s)
	{
		while(!s.isEmpty())
			System.out.println(s.pop() + " ");
	}

}
