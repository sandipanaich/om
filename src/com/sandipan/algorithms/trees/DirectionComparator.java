package com.sandipan.algorithms.trees;

import java.util.Comparator;

public class DirectionComparator implements Comparator<Node> {
	
	@Override
	public int compare(Node node1, Node node2) {
		return node1.data() - node2.data();
	}
}
