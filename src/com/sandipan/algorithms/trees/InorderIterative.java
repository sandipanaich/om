package com.sandipan.algorithms.trees;

import java.util.Stack;

public class InorderIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InorderIterative().traverse(Tree.root());
		new Inorder().traverse(Tree.root());
	}

	public void traverse(Node root)
	{
		if(root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		
		Node node = root;
		stack.push(node);
		
		while(!stack.isEmpty())
		{
			while(node.left() != null)
			{
				stack.push(node.left());
				node = node.left();
			}
			
			node = stack.pop();
			System.out.print(node.data() + " ");
			
			if(node.right() != null)
			{
				node = node.right();
				//System.out.print(node.data() + " ");
				stack.push(node);
			}
		}
		System.out.println();
	}	
}
