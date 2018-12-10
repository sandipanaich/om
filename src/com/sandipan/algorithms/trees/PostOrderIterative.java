package com.sandipan.algorithms.trees;

import java.util.Stack;

public class PostOrderIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PostOrder().traverse(Tree.root());
		System.out.println();
		new PostOrderIterative().traverse(Tree.root());
	}
	
	public void traverse(Node root)
	{
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		stack1.push(root);
		
		while(!stack1.isEmpty())
		{
			Node node = stack1.pop();
			stack2.push(node);

			if(node.right() != null)
				stack1.push(node.right());
			if(node.left() != null)
				stack1.push(node.left());
		}
		while(!stack2.isEmpty())
			System.out.print(stack2.pop().data() + " ");
	}
}
