package com.sandipan.algorithms.hackerrank.linkedlist.easy;

public class GetNode {

	int bacPos = -1;

	public static void main(String[] args) {
		Node head = new Node(1, new Node(3, new Node(5, new Node(7, new Node(9, new Node(11, new Node(13, null)))))));

		System.out.println(new GetNode().getNode2(head, 0));
		System.out.println(new GetNode().getNode2(head, 1));
		System.out.println(new GetNode().getNode2(head, 2));
		System.out.println(new GetNode().getNode2(head, 3));
		System.out.println(new GetNode().getNode2(head, 4));
		System.out.println(new GetNode().getNode2(head, 5));
		System.out.println(new GetNode().getNode2(head, 6));
		System.out.println(new GetNode().getNode2(head, 7));
	}

	private int getNode2(Node node, int position) {
		if (node == null) {
			bacPos = 0;
			return -1;
		} else {
			int val = getNode(node.next(), position);
			if(bacPos == position)
			{
				bacPos=-1;
				return node.data();
			}
			else if(val != -1)
				return val;
			else{
				bacPos++;
				return -1;
			}
		}
	}	
	
	private int getNode(Node node, int position) {
		if (node == null) {
			bacPos = 0;
			return -1;
		} else {
			int val = getNode(node.next(), position);
			if(bacPos == position)
			{
				bacPos=-1;
				return node.data();
			}
			else if(val != -1)
				return val;
			else{
				bacPos++;
				return -1;
			}
		}
	}
}
