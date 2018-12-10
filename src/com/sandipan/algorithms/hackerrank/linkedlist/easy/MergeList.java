package com.sandipan.algorithms.hackerrank.linkedlist.easy;

public class MergeList {

	public static void main(String[] args) {

		Node headA = new Node(1, new Node(3, new Node(5, new Node(7, new Node(9, new Node(11, new Node(13, null)))))));
		Node headB = new Node(2, new Node(4, new Node(6, new Node(8, new Node(10, new Node(12, null))))));

		print(headA);
		print(headB);
		
		print(mergeListss(headA, headB));
		
		print(headA);
		print(headB);
	}

	
	private static Node mergeListss(Node headA, Node headB) {

		if (headA == null && headB == null)
			return null;
		if ((headA != null && headB != null && headA.data() > headB.data()) || (headA == null && headB != null))
		{
			return new Node(headB.data(), mergeLists(headA, headB.next()));
		} 
		else if ((headA != null && headB != null && headA.data() <= headB.data()) ||  (headA != null && headB == null)) 
		{
			return new Node(headA.data(), mergeLists(headA.next(), headB));
		}
		return null;
	}
	
	
	private static Node mergeLists(Node headA, Node headB) {
		Node tail = null;
		int info = -1;

		if (headA == null && headB == null)
			return null;
		if ((headA != null && headB != null && headA.data() > headB.data()) || (headA == null && headB != null))
		{
			tail = mergeLists(headA, headB.next());
			info = headB.data();
			return new Node(info, tail);
		} 
		else if ((headA != null && headB != null && headA.data() <= headB.data()) ||  (headA != null && headB == null)) {
			tail = mergeLists(headA.next(), headB);
			info = headA.data();
			return new Node(info, tail);
		}

		return null;
//		return new Node(info, tail);

	}

	private static void print(Node head) {
		Node node = head;
		while (node != null) {
			System.out.print(node.data() + " ");
			node = node.next();
		}
		System.out.println();
	}
}

class Node {
	private int data;
	private Node next;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public int data() {
		return data;
	}

	public void data(int data) {
		this.data = data;
	}

	public Node next() {
		return next;
	}

	public void next(Node next) {
		this.next = next;
	}

}