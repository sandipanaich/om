package com.sandipan.algorithms.queue;

public class MyQueue{

	int rear;
	int front;
	int[] array;
	int size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue queue = new MyQueue(2);
		queue.printQueue();
		System.out.println("Size()" + queue.size);
		queue.enqueue(1);
		queue.printQueue();
		System.out.println("Size(1)" + queue.size);
		queue.enqueue(2);
		queue.printQueue();
		System.out.println("Size(1,2)" + queue.size);
		//queue.enqueue(3);
		System.out.println(queue.deque());
		System.out.println("Size(1)" + queue.size);
		queue.printQueue();
		System.out.println(queue.deque());
		System.out.println("Size()" + queue.size);
		//System.out.println(queue.deque());
		queue.printQueue();
	}

	public MyQueue() {
		this(5);
	}
	
	public MyQueue(int size) {
		this.array = new int[size];
		this.size = 0;
		this.rear = -1;
		this.front = -1;
	}

	public boolean isFull() {
		if ((rear + 1) % array.length == front)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if (front == -1)
			return true;
		return false;
	}

	public void enqueue(int val) {
		if (isFull())
			throw new RuntimeException("The Queue is Full.");
		size++;
		if(front == -1)
			front = 0;
		rear = (rear + 1) % array.length;
		array[rear] = val;
	}
	
	public int deque()
	{
		if(isEmpty())
			throw new RuntimeException("The Queue is Empty.");
		size--;
		int temp = front;
		if(front == rear)
		{
			front = -1;
			rear = -1;
		}
		else
			front = (front+1)%array.length;

		return array[temp];
	}
	
	public int size()
	{
		if(front < rear)
			return rear - front + 1;
		else
			return (array.length - front) + (rear + 1);
	}
	
	public void printQueue()
	{
		if(isEmpty())
			return;
		int front = this.front;
		for(; front !=rear+1; front = (front +1)%array.length)
			System.out.println(array[front] + " ");
		System.out.println();
	}

}
