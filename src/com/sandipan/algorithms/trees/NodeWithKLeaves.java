package com.sandipan.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class NodeWithKLeaves {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println(new NodeWithKLeaves().getLeaveCount(6, Tree.root()));
		System.out.println(new NodeWithKLeaves().getLeaveCount(5, Tree.root()));
		System.out.println(new NodeWithKLeaves().getLeaveCount(4, Tree.root()));
		System.out.println(new NodeWithKLeaves().getLeaveCount(3, Tree.root()));
		System.out.println(new NodeWithKLeaves().getLeaveCount(2, Tree.root()));
		System.out.println(new NodeWithKLeaves().getLeaveCount(1, Tree.root()));
	}

	int leafCount = 0;
	List<Node> list = new ArrayList<>();
	private int getLeaveCount(int count, Node root) {
		
		if (root.left() == null && root.right() == null)
			return 0;
		
		if (count == getLeaveCount(root))
		{
			leafCount++;
			list.add(root);
		}

		if (root.left() != null)
			getLeaveCount(count, root.left());
		if (root.right() != null)
			getLeaveCount(count, root.right());
		return leafCount;
	}

	private int getLeaveCount(Node node) {
		if (node == null)
			return 0;
		if (node.left() == null && node.right() == null)
			return 1;
		return getLeaveCount(node.left()) + getLeaveCount(node.right());
	}
	
	
}
