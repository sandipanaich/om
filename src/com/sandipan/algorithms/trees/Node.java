package com.sandipan.algorithms.trees;

public class Node {

	private int data;
	private Node left;
	private Node right;
	private int direction;

	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
		this.direction = 0;		
	}

	public int data() {
		return data;
	}

	public void data(int data) {
		this.data = data;
	}

	public Node left() {
		return left;
	}

	public void left(Node left) {
		this.left = left;
	}

	public Node right() {
		return right;
	}

	public void right(Node right) {
		this.right = right;
	}

	public int direction() {
		return direction;
	}

	public void direction(int direction) {
		this.direction = direction;
	}

	
}
