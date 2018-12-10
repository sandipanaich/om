package com.sandipan.algorithms.dynammic;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = new int[]{1,3,5};

		System.out.println("=============Recursive==================================");		

		System.out.println("01 -> " + coinChangeRecursive(coins, 1));
		System.out.println("02 -> " + coinChangeRecursive(coins, 2));
		System.out.println("03 -> " + coinChangeRecursive(coins, 3));
		System.out.println("04 -> " + coinChangeRecursive(coins, 4));
		System.out.println("05 -> " + coinChangeRecursive(coins, 5));
		System.out.println("06 -> " + coinChangeRecursive(coins, 6));
		System.out.println("07 -> " + coinChangeRecursive(coins, 7));
		System.out.println("08 -> " + coinChangeRecursive(coins, 8));
		System.out.println("09 -> " + coinChangeRecursive(coins, 9));
		System.out.println("10 -> " + coinChangeRecursive(coins, 10));
		System.out.println("11 -> " + coinChangeRecursive(coins, 11));
		System.out.println("12 -> " + coinChangeRecursive(coins, 12));
		System.out.println("13 -> " + coinChangeRecursive(coins, 13));
		System.out.println("14 -> " + coinChangeRecursive(coins, 14));
		System.out.println("15 -> " + coinChangeRecursive(coins, 15));

		System.out.println("=============Recursive 2==================================");		

		System.out.println("01 -> " + coinChange(coins, 2, 1));
		System.out.println("02 -> " + coinChange(coins, 2, 2));
		System.out.println("03 -> " + coinChange(coins, 2, 3));
		System.out.println("04 -> " + coinChange(coins, 2, 4));
		System.out.println("05 -> " + coinChange(coins, 2, 5));
		System.out.println("06 -> " + coinChange(coins, 2, 6));
		System.out.println("07 -> " + coinChange(coins, 2, 7));
		System.out.println("08 -> " + coinChange(coins, 2, 8));
		System.out.println("09 -> " + coinChange(coins, 2, 9));
		System.out.println("10 -> " + coinChange(coins, 2, 10));
		System.out.println("11 -> " + coinChange(coins, 2, 11));
		System.out.println("12 -> " + coinChange(coins, 2, 12));
		System.out.println("13 -> " + coinChange(coins, 2, 13));
		System.out.println("14 -> " + coinChange(coins, 2, 14));
		System.out.println("15 -> " + coinChange(coins, 2, 15));

		System.out.println("============Dynamic Top Down ===================================");	
		
		System.out.println("01 -> " + coinChange(coins, 1));
		System.out.println("02 -> " + coinChange(coins, 2));
		System.out.println("03 -> " + coinChange(coins, 3));
		System.out.println("04 -> " + coinChange(coins, 4));
		System.out.println("05 -> " + coinChange(coins, 5));
		System.out.println("06 -> " + coinChange(coins, 6));
		System.out.println("07 -> " + coinChange(coins, 7));
		System.out.println("08 -> " + coinChange(coins, 8));
		System.out.println("09 -> " + coinChange(coins, 9));
		System.out.println("10 -> " + coinChange(coins, 10));
		System.out.println("11 -> " + coinChange(coins, 11));
		System.out.println("12 -> " + coinChange(coins, 12));
		System.out.println("13 -> " + coinChange(coins, 13));
		System.out.println("14 -> " + coinChange(coins, 14));
		System.out.println("15 -> " + coinChange(coins, 15));

		System.out.println("=============Dynamic Bottom Up==================================");	

		
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 1));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 2));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 3));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 4));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 5));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 6));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 7));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 8));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 9));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 10));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 11));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 12));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 13));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 14));
	    System.out.println("15 -> " + coinChangeBU(coins, 3, 15));

		
		
	long start = System.currentTimeMillis();
	System.out.println("5000 -> " + coinChangeRecursive(coins, 5000));
	System.out.println("Recursive :: " + (System.currentTimeMillis() - start));
	System.out.println("===============================================");
	start = System.currentTimeMillis();
	System.out.println("5000 -> " + coinChange(coins, 5000));
	System.out.println("Dynammic :: " + (System.currentTimeMillis() - start));
	System.out.println("15(2,3,5) :: " + coinChange(new int[]{2,3,5},15));
	
	}
	
	
	//Recursive solution of the Coin Change Problem.
	private static int coinChangeRecursive(int[] coins, int value) {

		if(value < 0 || coins.length == 0)
			return 0;
		if(value == 0)
			return 1;
//		return coinChange(Arrays.copyOf(coins, coins.length -1), value) + coinChange(coins, value - coins[coins.length -1]);
		return coinChangeRecursive(Arrays.copyOf(coins, coins.length -1), value) + coinChangeRecursive(coins, value - coins[coins.length -1]);
	}

	//Recursive solution of the Coin Change Problem.
	private static int coinChange(int[] coins, int index, int value) {

		if(value < 0 || index < 0)
			return 0;
		if(value == 0)
			return 1;
//		return coinChange(Arrays.copyOf(coins, coins.length -1), value) + coinChange(coins, value - coins[coins.length -1]);
		return coinChange(coins, index-1, value) + coinChange(coins, index, value - coins[index]);
	}

	
	
	//Dynamic solution of the Coin Change Problem(Top Down).
	
	private static int coinChange(int[] coins, int value)
	{
		int[][] matrix = new int[coins.length+1][value+1];
		for(int[] arr: matrix)
			Arrays.fill(arr, -1);
		return _coinChange(coins, coins.length, value, matrix);
	}
	
	
	private static int _coinChange(int[] coins, int index, int value, int[][] matrix) {

		if(value < 0 || index <= 0)
			return 0;
		if(value == 0)
			return 1;
		
		if(matrix[index-1][value] == -1)
			matrix[index-1][value] = _coinChange(coins, index-1, value, matrix);
		
		if( (value - coins[index-1] >= 0) && matrix[index][value - coins[index-1]] == -1)
			matrix[index][value - coins[index-1]] = _coinChange(coins, index, value - coins[index-1], matrix);
		
		return matrix[index-1][value] + ((value - coins[index-1] >= 0) ? matrix[index][value - coins[index-1]] : 0);
		
//		return coinChange(Arrays.copyOf(coins, coins.length -1), value) + coinChange(coins, value - coins[coins.length -1]);
		//return coinChange(coins, index-1, value, matrix) + coinChange(coins, index, value - coins[index], matrix);
	}
	

	//Dynamic solution of the Coin Change Problem(Bottom Up).
	// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15]
	// [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	// [2,3,5]

	static long coinChangeBU(int coins[], int m, int n)
    {
		if(m == 0)
			return 0;
		
        int[] table = new int[n+1]; 
        Arrays.fill(table, 0);
        table[0] = 1;
 
        for (int i=0; i<m; i++)
            for (int j=coins[i]; j<=n; j++)
                table[j] += table[j-coins[i]];
 
        return table[n];
    }

	
/*	static long coinChangeBU(int coins[], int m)
    {
		if(m == 0)
			return 0;

		int[][] matrix = new int[coins.length][m];
		int n = coins.length;
		
    }*/

	
}
