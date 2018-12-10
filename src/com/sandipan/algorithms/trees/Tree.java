package com.sandipan.algorithms.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Tree {
	public static Node root() {
		Node root = new Node(1);

		root.left(new Node(2));
		root.right(new Node(3));

		root.left().left(new Node(4));
		root.left().right(new Node(5));
		root.left().right().left(new Node(10));

		root.right().left(new Node(6));
		root.right().right(new Node(7));

		root.right().right().left(new Node(8));
		root.right().right().right(new Node(9));

		return root;
	}
	
	public static Node bstRoot()
	{
		Node root = new Node(100);

		root.left(new Node(50));
		root.right(new Node(150));

		root.left().left(new Node(25));
		root.left().right(new Node(75));
		
		root.right().left(new Node(125));
		root.right().right(new Node(175));
		
		root.right().left().left(new Node(115));
		root.right().left().right(new Node(135));
		
		return root;
	}
	
	
	public static void main(String[] args) {
		System.out.println(isBST(bstRoot()));
	}
	
	public static int height(Node root) {
		if(root == null)
			return 0;
		
		return Math.max(height(root.left()), height(root.right())) + 1;
	}

	public static int level(Node root, int data, int level) {
		if (root == null)
			return 0;

		if (root.data() == data)
			return level;

		int left = level(root.left(), data, level + 1);
		if (left == 0)
			return level(root.right(), data, level + 1);
		return left;
	}

	public static List<String> printPaths(Node root) {
		int[] nodes = new int[Tree.height(root) + 1];
		Arrays.fill(nodes, Integer.MIN_VALUE);
		List<String> list = new ArrayList<String>();
		printPaths(root, nodes, 0, list);
		return list;
	}

	private static void printPaths(Node root, int[] nodes, int index, List<String> list) {
		
		if(root == null)
			return;
		
		nodes[index] = root.data();
		if (root.left() == null && root.right() == null) {
			printPaths(nodes, index+1, list);
			return;
		}

		printPaths(root.left(), nodes, index + 1, list);
		printPaths(root.right(), nodes, index + 1, list);

	}

	private static void printPaths(int[] nodes, int index, List<String> list) {
		String str = nodes[0] + "";
		for (int i = 1; i < index && nodes[i] != Integer.MIN_VALUE; i++)
			str += ("->" + nodes[i]);
		list.add(str);
		//System.out.println(str);
	}
	
	public static Node mirror(Node root)
	{
		Node newRoot  = new Node(root.data());
		mirror(root, newRoot);
		return newRoot;
	}
	private static void mirror(Node root, Node newRoot)
	{
		if(root == null)
			return;
		
		if(root.left() != null)
		{
			newRoot.right(new Node(root.left().data()));
			mirror(root.left(), newRoot.right());
		}
		if(root.right() !=null)
		{
			newRoot.left(new Node(root.right().data()));
			mirror(root.right(), newRoot.left());
		}
	}
	
	public static boolean isSymmetric(Node root)
	{
		if(root == null)
			return true;
		return isSymmetric(root.left(), root.right());
	}

	private static boolean isSymmetric(Node node1, Node node2)
	{
		if(node1 == null && node2 == null)
			return true;
		if((node1 == null && node2 != null) || (node1 != null && node2 == null) || (node1.data() != node2.data()))
			return false;
		return isSymmetric(node1.left(), node2.right()) && isSymmetric(node1.left(), node2.right());
	}
	
	public static boolean isSymmetricIterative(Node root)
	{
		if(root == null)
			return true;
		
		Node node1 = root.left();
		Node node2 = root.right();
	
		if((node1 == null && node2 != null) || (node1 != null && node2 == null) || (node1.data() != node2.data()))
			return false;

		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		
		stack1.push(node1);
		stack2.push(node2);
		return false;
	}
	
	public static boolean isBST(Node root)
	{
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBST(Node root, int min, int max)
	{
		if(root == null)
			return true;
		
		int value = root.data();
		
		if(min > value || value > max)
			return false;
		
		return isBST(root.left(), min, value) && isBST(root.right(), value, max);
	}
}
