package com.sandipan.algorithms.trees;

public class Inorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Inorder().traverse(Tree.root());
	}

	public void traverse(Node root)
	{
		if(root == null)
			return;
		traverse(root.left());
		System.out.print(root.data() + " ");
		traverse(root.right());
	}	
}
