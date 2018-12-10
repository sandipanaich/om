package com.sandipan.algorithms.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		int[]  max = new SlidingWindowMax().find(arr , 3);
		
		for(int a : max)
			System.out.print(a + ":" + arr[a] + "....");
	}

	private int[] find(int[] arr, int k) {
		int[] max = new int[arr.length - k + 1];
		Deque<Integer> queue = new ArrayDeque<>();
		queue.addLast(0);

		int i = 1;
		for (; i < k; i++) {
			while (!queue.isEmpty() && arr[i] > arr[queue.peekLast()])
				queue.removeFirst();
			queue.addLast(i);
		}

		for (; i < arr.length; i++) {
			max[i - k] = queue.peekFirst();

			if (queue.peekFirst() < (i - k))
				queue.removeFirst();
			while (!queue.isEmpty() && arr[i] > arr[queue.peekFirst()])
				queue.removeFirst();
			
			queue.addLast(i);
		}
		System.out.println(queue.peekFirst() + "..." + arr[queue.peekFirst()]);
		max[i - k] = queue.peekFirst();
		return max;
	}

}
