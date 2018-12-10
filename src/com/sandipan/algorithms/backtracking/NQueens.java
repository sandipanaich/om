package com.sandipan.algorithms.backtracking;
import java.util.Arrays;

public class NQueens {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int dimension = 10;

				boolean[][] chessBoard = new boolean[dimension][dimension];
				Position[] positions = new Position[dimension];
				
				placeQueen(chessBoard, dimension - 1, 0, dimension, positions);
		}
		
		private static void placeQueen(boolean[][] chessBoard, int row, int column,int dimension, Position[] positions)
		{
			if(row < 0)
				System.out.println(Arrays.toString(positions));
					
			for(; column < dimension; column++)
			{
				if(!isAttacked(row, column, chessBoard, dimension))
				{
					chessBoard[row][column] = true;
					positions[row] = new Position(row, column);
					placeQueen(chessBoard, row-1, 0, dimension, positions);
										
					chessBoard[row][column] = false;
				}
			}
		}
		
		private static boolean isAttacked(int row, int column, boolean[][] chessBoard, int dimension)
		{
			return isAttackedFromLeftDiagonal(row, column, chessBoard, dimension) ||
					isAttackedFromRightDiagonal(row, column, chessBoard, dimension) ||
					isAttackedFromStraightBelow(row, column, chessBoard, dimension) ||
					isAttackedFromLeftDownKnightMove(row, column, chessBoard, dimension) ||
					isAttackedFromDownLeftKnightMove(row, column, chessBoard, dimension) ||
					isAttackedFromRightDownKnightMove(row, column, chessBoard, dimension) ||
					isAttackedFromDownRightKnightMove(row, column, chessBoard, dimension);
		}
		
		private static boolean isAttackedFromLeftDownKnightMove(int row, int column, boolean[][] chessBoard, int dimension)
		{
			row +=1;
			column -= 2;
			
			return (row < dimension && column >=0 && chessBoard[row][column]);
		}

		private static boolean isAttackedFromDownLeftKnightMove(int row, int column, boolean[][] chessBoard, int dimension)
		{
			row +=2;
			column -= 1;
			
			return (row < dimension && column >=0 && chessBoard[row][column]);			
		}		
		
		private static boolean isAttackedFromRightDownKnightMove(int row, int column, boolean[][] chessBoard, int dimension)
		{
			row +=1;
			column += 2;
			
			return (row < dimension && column < dimension && chessBoard[row][column]);
		}
		
		private static boolean isAttackedFromDownRightKnightMove(int row, int column, boolean[][] chessBoard, int dimension)
		{
			row +=2;
			column += 1;
			
			return (row < dimension && column < dimension && chessBoard[row][column]);
		}
		
		private static boolean isAttackedFromLeftDiagonal(int row, int column, boolean[][] chessBoard, int dimension)
		{
			row++;
			column--;
			while(row < dimension && column >= 0 && !chessBoard[row][column])
			{
				row++;
				column--;
			}
			return (row < dimension && column >= 0);
		}
		
		private static boolean isAttackedFromRightDiagonal(int row, int column, boolean[][] chessBoard, int dimension)
		{
			row++;
			column++;
			while(row < dimension && column < dimension && !chessBoard[row][column])
			{
				row++;
				column++;
			}
			return (row < dimension && column < dimension);
		}

		private static boolean isAttackedFromStraightBelow(int row, int column, boolean[][] chessBoard, int dimension)
		{
			row++;
			while(row < dimension && !chessBoard[row][column])
			{
				row++;
			}
			return (row < dimension);
		}
	}

class Position
{
	private int x;
	private int y;
	Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}