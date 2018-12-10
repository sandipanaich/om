package com.sandipan.algorithms.dynammic;


public class RodCut {

	public static void main(String[] args) {

		int[] lengths = new int[] { 1 , 2, 3, 4,  5,  6,  7,  8, 9, 10, 11, 12, 13, 15, 14, 16, 17, 18, 19, 20, 21, 22};
		int[] prices  = new int[] { 1,  5, 8, 9, 10, 17, 17, 20, 0, 0, 0, 0, 0, 0, 0 ,0, 0, 0, 0, 0, 0, 0};
		
		System.out.println(rodCut(lengths, prices, 1));
		System.out.println(rodCut(lengths, prices, 2));
		System.out.println(rodCut(lengths, prices, 3));
		System.out.println(rodCut(lengths, prices, 4));
		System.out.println(rodCut(lengths, prices, 5));
		System.out.println(rodCut(lengths, prices, 6));
		System.out.println(rodCut(lengths, prices, 7));
		System.out.println(rodCut(lengths, prices, 8));
		System.out.println(rodCut(lengths, prices, 9));
		System.out.println(rodCut(lengths, prices, 10));
		System.out.println(rodCut(lengths, prices, 11));
		System.out.println(rodCut(lengths, prices, 12));
		System.out.println(rodCut(lengths, prices, 13));
		System.out.println(rodCut(lengths, prices, 14));
		System.out.println(rodCut(lengths, prices, 15));
		System.out.println(rodCut(lengths, prices, 16));
		System.out.println(rodCut(lengths, prices, 17));
		System.out.println(rodCut(lengths, prices, 18));
		System.out.println(rodCut(lengths, prices, 19));
		System.out.println(rodCut(lengths, prices, 20));
		System.out.println(rodCut(lengths, prices, 21));
		System.out.println(rodCut(lengths, prices, 22));
	}

/*	private static int rodCut(int[] lengths, int[] prices, int length)
	{
		int max = 0;
		while(length > lengths.length)
		{
			max += _rodCut(lengths, prices, lengths.length);
			length -= lengths.length;
		}
		if(length > 0)
			max += _rodCut(lengths, prices, length);
		return max;

	}*/
	
	
	
	private static int rodCut(int[] lengths, int[] prices, int length) 
	{
		if(length <= 0)
			return 0;
		
		int max = 0;
		
		for(int len = 1 ; len <= length; len++)
		{
			int price = prices[len -1] + rodCut(lengths, prices, length-len);
			if(price > max)
				max = price;
		}
		return max;
	}

}
