package com.sandipan.algorithms.trees;

public class MergeTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Inorder().traverse(new MergeTree().merge(Tree.root(), Tree.mirror(Tree.root())));
	}

	public Node merge(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return null;

		Node mergedTree = null;
		if (node1 != null && node2 != null)
			mergedTree = new Node(node1.data() + node2.data());
		if (node1 != null && node2 == null)
			mergedTree = new Node(node1.data());
		if (node1 == null && node2 != null)
			mergedTree = new Node(node2.data());

		merge(node1, node2, mergedTree);

		return mergedTree;
	}

	private void merge(Node node1, Node node2, Node newNode) {
		if (node1 == null && node2 == null)
			return;

		int sum = Integer.MIN_VALUE;
		if (node1 != null && node1.left() != null)
			sum = node1.left().data();
		if (node2 != null && node2.left() != null)
			sum = (sum == Integer.MIN_VALUE) ? node2.left().data() : (sum + node2.left().data());
		if (sum != Integer.MIN_VALUE)
			newNode.left(new Node(sum));

		sum = Integer.MIN_VALUE;
		if (node1 != null && node1.right() != null)
			sum = node1.right().data();
		if (node2 != null && node2.right() != null)
			sum = (sum == Integer.MIN_VALUE) ? node2.right().data() : (sum + node2.right().data());
		if (sum != Integer.MIN_VALUE)
			newNode.right(new Node(sum));

		if(node1 == null && node2 !=null)
		{
			merge(null, node2.left(), newNode.left());
			merge(null, node2.right(), newNode.right());
		}
		if(node1 != null && node2 ==null)
		{
			merge(node1.left(), null, newNode.left());
			merge(node1.right(), null, newNode.right());
		}
		if(node1 != null && node2 !=null)
		{
			merge(node1.left(), node2.left(), newNode.left());
			merge(node1.right(), node2.right(), newNode.right());
		}
	}
}
