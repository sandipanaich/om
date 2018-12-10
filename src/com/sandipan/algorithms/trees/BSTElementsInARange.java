package com.sandipan.algorithms.trees;

public class BSTElementsInARange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub=
	}
	
	Integer[] elementsInRange(int low, int high, Node root)
	{
		if(root.data() < low)
			return elementsInRange(low, high, root.right());
		
		if(root.data() > high)
			return elementsInRange(low, high, root.left());
		
		
		return null;
	}

}
