package com.sandipan.algorithms.trees.views;

import com.sandipan.algorithms.trees.Node;
import com.sandipan.algorithms.trees.Tree;

public class LeftView {

	public static void main(String[] args) {		
		new LeftView().traverse(Tree.root(), 0);
	}
	
	int max = -1;
	public void traverse(Node node, int level)
	{
		if(node == null)
			return;
		
		
		if(max < level)
		{
			max++;
			System.out.println(node.data());
		}
		traverse(node.left(), level+1);
		traverse(node.right(), level+1);
	}
}
