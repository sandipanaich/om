package com.sandipan.algorithms.trees;

public class PostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PostOrder().traverse(Tree.root());
	}
	
	public void traverse(Node root)
	{
		if(root == null)
			return;
		traverse(root.left());
		traverse(root.right());
		System.out.print(root.data() + " ");
	}
}
