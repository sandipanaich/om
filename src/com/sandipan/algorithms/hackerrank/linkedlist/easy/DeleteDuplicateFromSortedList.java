package com.sandipan.algorithms.hackerrank.linkedlist.easy;

public class DeleteDuplicateFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1, new Node(3, new Node(5, new Node(7, new Node(7, new Node(11, new Node(13, null)))))));
		RemoveDuplicates(head);
		print(head);
	}

	static Node RemoveDuplicates(Node head) {
		if (head == null)
			return null;
		
		Node temp = RemoveDuplicates(head.next());
		
		if(temp != null && temp.data() == head.data())
			return temp;
		else
			    head.next(temp);
		return head;
	}
	
	private static void print(Node head) {
		Node node = head;
		while (node != null) {
			System.out.print(node.data() + " ");
			node = node.next();
		}
		System.out.println();
	}
	
/*	static Node RemoveDuplicates2(Node head) {
		if (head == null)
			return null;
		
		Node temp = RemoveDuplicates(head.next);
		
		if(temp != null && temp.data == head.data)
			return temp;
		else
			    head.next = temp;
		return head;
	}*/
}
