package com.sandipan.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]{
									{1,1,0,0,0},
									{0,1,0,0,1},
									{1,0,0,1,1},
									{0,0,0,0,0},
									{1,0,1,0,1}
			};
			
			System.out.println("Number of Islands :: " + new Islands().count(matrix));
	}

	private int count(int[][] matrix) {
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int count = 0;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if (!visited[i][j]) {
					if(matrix[i][j] == 0)
						visited[i][j] = true;
					
					spreadIsland(visited, matrix, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void spreadIsland(boolean[][] visited, int[][] matrix, int i, int j) {
				
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j));
		
		while(!queue.isEmpty())
		{
			Point point = queue.poll();
			addToQueue(point, queue, matrix, visited);
		}
	}
	
	private void addToQueue(Point point, Queue<Point> queue, int[][] matrix, boolean[][] visited)
	{
		int x = point.getX();
		int y = point.getY();
		visited[x][y] = true;
		
		Point[] points = new Point[]{
				new Point(x-1, y-1),
				new Point(x, y-1),
				new Point(x+1, y-1),
				new Point(x-1, y),
				new Point(x+1, y),
				new Point(x-1, y+1),
				new Point(x, y+1),
				new Point(x+1, y+1)
			};
		
		for(Point newPoint : points)
			validateAndAdd(newPoint, visited, matrix, queue);
			
	}
	
	private void validateAndAdd(Point point, boolean[][] visited, int[][] matrix, Queue<Point> queue)
	{
		int x = point.getX();
		int y = point.getY();

		if(x < 0 || x >= visited.length)
			return;

		if(y < 0 || y >= visited[0].length)
			return;
		
		if(!visited[x][y])
		{
			visited[x][y] = true;
			if(matrix[x][y] == 1)
				queue.add(point);
		}	
	}
		
	private class Point {

		private int x;
		private int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

	}
}
