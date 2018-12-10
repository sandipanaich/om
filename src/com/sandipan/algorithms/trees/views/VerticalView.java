package com.sandipan.algorithms.trees.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sandipan.algorithms.trees.Node;
import com.sandipan.algorithms.trees.Tree;

public class VerticalView {

	Map<Integer, List<Node>> map = new TreeMap<Integer, List<Node>>();
	
	public static void main(String[] args) {		
		new VerticalView().printVerticalView(Tree.root());
	}
	
	
	public void printVerticalView(Node root)
	{
		traverse(Tree.root(), 0);
		for(Map.Entry<Integer, List<Node>> entry : map.entrySet())
		{
			for(Node node : entry.getValue())
				System.out.print(node.data() + " ");
			System.out.println();
		}
	}
	
	public void traverse(Node node, int level)
	{
		if(node == null)
			return;
		
		List<Node> list = map.get(level);
		if(list == null)
		{
			list =  new ArrayList<Node>();
			map.put(level,list);
		}
		list.add(node);
		traverse(node.left(), level-1);
		traverse(node.right(), level+1);
	}
}
