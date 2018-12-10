package com.sandipan.algorithms.trees.views;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sandipan.algorithms.trees.Node;
import com.sandipan.algorithms.trees.Tree;

public class TopView {

	Set<Integer> set = new HashSet<Integer>();
	List<Node> list = new ArrayList<Node>();
	
	public static void main(String[] args) {		
		new TopView().printTopView(Tree.root());
	}
	
	
	public void printTopView(Node root)
	{
		traverse(Tree.root(), 0);
		for(Node a : list)
			System.out.print(a.data() + " ");
	}
	
	public void traverse(Node node, int level)
	{
		if(node == null)
			return;
		
		if(!set.contains(level))
		{
			set.add(level);
			if(level < 0)
				list.add(0, node);
			else
				list.add(node);
		}
		traverse(node.left(), level-1);
		traverse(node.right(), level+1);
	}
}
