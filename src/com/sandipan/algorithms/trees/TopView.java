package com.sandipan.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class TopView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void traverse(Node root)
	{
		if(root == null)
			return;
		
		Set<Node> set = new TreeSet<>();
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
//		while()
	}

}
