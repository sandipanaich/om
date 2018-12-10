package com.sandipan.algorithms.trees;

public class Mirror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Inorder().traverse(Tree.root());
		System.out.println();
		new Inorder().traverse(Tree.mirror(Tree.root()));
	}

}
