package com.sandipan.algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTillNum {

	public static void main(String[] args) {
		new BinaryTillNum().print(100);
	}
	
	void print(int num)
	{
		Queue<String> queue = new LinkedList<>();
		queue.add("1");
		int i = 1;
		while(!queue.isEmpty())
		{
			String s = queue.remove();
			System.out.println(s);
			if(i < num)
			{
				queue.add(s+"0");
				i++;
			}
			if(i < num)
			{
				queue.add(s+"1");
				i++;
			}

		}
	}

}
