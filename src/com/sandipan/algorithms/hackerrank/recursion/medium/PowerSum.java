package com.sandipan.algorithms.hackerrank.recursion.medium;

import static java.lang.Math.pow;

public class PowerSum {

	public static void main(String[] args) {
		System.out.println(findPowerSum(100, 2, 1));
		System.out.println(findPowerSum(13, 2, 1));
	}
	
	private static int findPowerSum(int sum, int index, int num)
	{
		int pow = (int)pow(num, index);

		if(pow < sum)
			return findPowerSum(sum, index, num+1) + findPowerSum(sum-pow, index, num+1);
		
		if((sum - pow) == 0)
			return 1;
		else
			return 0;
	}

}
