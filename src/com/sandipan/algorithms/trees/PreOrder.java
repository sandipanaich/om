package com.sandipan.algorithms.trees;

public class PreOrder {

	public static void main(String[] args) {
		new PreOrder().traverse(Tree.root());
	}
	
	public void traverse(Node root)
	{
		if(root == null)
			return;
		
		System.out.print(root.data() + " ");
		traverse(root.left());
		traverse(root.right());
	}

}
