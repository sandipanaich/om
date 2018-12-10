package com.sandipan.algorithms.trees;

import java.util.Stack;

public class PreOrderIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PreOrderIterative().traverse(Tree.root());
	}
	
	public void traverse(Node root)
	{
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.isEmpty())
		{
			Node node = stack.pop();
			System.out.print(node.data() + " ");
			if(node.right() != null)
				stack.push(node.right());
			if(node.left() != null)
				stack.push(node.left());
		}
	}
}
