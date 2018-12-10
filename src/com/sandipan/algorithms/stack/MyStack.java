package com.sandipan.algorithms.stack;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class MyStack {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		System.out.println("Please enter the the size of the stack you would like to maintain: ");
		Scanner in = new Scanner(System.in);
		MyStack stack = new MyStack(in.nextInt());
		in.close();

		// stack.pop();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		// stack.push(6);
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());

		System.out.println("-----------------");
		stack.printStack();
	}

	private int top;
	private Object[] stack;

	public MyStack(int stackSize) {
		this.top = -1;
		stack = new Object[stackSize];
	}

	public Object pop(){
		if (isEmpty())
			throw new RuntimeException("Cannot pop: The Stack is Empty.");
		else
			return stack[top--];
	}

	public void push(Object obj) {
		if (isFull())
			throw new RuntimeException("Cannot push: The Stack is Full.");
		else
			stack[++top] = obj;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == (stack.length - 1));
	}

	public int size() {
		return top + 1;
	}

	public void printStack() {
		for (Object obj : stack)
			System.out.print(obj + " ");
		System.out.println();
	}
	
	public Object peek()
	{
		if(isEmpty())
			throw new RuntimeException("Cannot peek: The Stack is Empty.");
		return stack[top];
	}

}
