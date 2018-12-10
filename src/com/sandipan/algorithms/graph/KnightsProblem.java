package com.sandipan.algorithms.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightsProblem {

	public static void main(String[] args) {
		int fromX = 7;
		int fromY = 7;
		int toX = 0;
		int toY = 0;
//		int toX = 0;
//		int toY = 0;
		System.out.println("Move Counts :: from: (" + fromX + "," + fromY + ") to: (" + toX + "," + toY + ") :: " + new KnightsProblem().numberOfMoves(fromX, fromY, toX, toY));
	}

	private int numberOfMoves(int fromX, int fromY, int toX, int toY)
	{
		Move from = new Move(fromX, fromY);
		Move to = new Move(toX, toY);
		
		return numberOfMoves(from, to);
	}
	
	private int numberOfMoves(Move from, Move to)
	{
		Queue<Move> queue = new LinkedList<Move>();
		queue.add(from);
		
		while(!queue.isEmpty())
		{
			Move move = queue.poll();
			if(move.equals(to))
				return move.moveCount();
			
			for(Move possibleMove : possibleValidMoves(move))
				queue.add(possibleMove);
		}
		return -1;
	}
	
	private Move[] possibleValidMoves(Move move) {
		return validate(possibleMoves(move));
	}

	private Move[] possibleMoves(Move move) {
		int x = move.x();
		int y = move.y();
		int d = move.moveCount() + 1;

		return new Move[] { 
				new Move(x + 1, y + 2, d), 
				new Move(x + 1, y - 2, d),
				
				new Move(x + 2, y + 1, d),
				new Move(x + 2, y - 1, d),
				
				new Move(x - 2, y + 1, d), 
				new Move(x - 2, y - 1, d),
				
				new Move(x - 1, y + 2, d), 
				new Move(x - 1, y - 2, d) };

	}

	private Move[] validate(Move[] moves) {
		Move[] validMoves = new Move[moves.length];
		int index = 0;
		for (Move move : moves) {
			if (validate(move))
				validMoves[index++] = move;
		}

		return Arrays.copyOf(validMoves, index);
	}

	private boolean validate(Move move) {
		if (move.x() < 0 || move.y() < 0)
			return false;
		if (move.x() >= 8 || move.y() >= 8)
			return false;
		return true;
	}

	private class Move {
		private int x;
		private int y;
		private int moveCount;

		public Move(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Move(int x, int y, int moveCount) {
			super();
			this.x = x;
			this.y = y;
			this.moveCount = moveCount;
		}

		public int x() {
			return x;
		}

		public int y() {
			return y;
		}

		public int moveCount() {
			return moveCount;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			Move other = (Move) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Move [x=" + x + ", y=" + y + ", moveCount=" + moveCount + "]";
		}

		private KnightsProblem getOuterType() {
			return KnightsProblem.this;
		}

	}

}