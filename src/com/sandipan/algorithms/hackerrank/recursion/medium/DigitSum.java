package com.sandipan.algorithms.hackerrank.recursion.medium;

public class DigitSum {

	public static void main(String[] args) {
//		digitSum("148", 3);
//		digitSum(148);
		
//		System.out.println(digitSum("148", 3));
		System.out.println(digitSum(148));

	}
	
    static int digitSum(String n, int k) {
        char[] n1 = n.toCharArray();
        long sum = 0;
        for(int j = 0 ; j < n1.length; j++)
              sum +=  n1[j]-'0';

        long sumCopy = sum;
        for(int i = 1; i < k ; i++)
            sum += sumCopy;
        System.out.println(sum);
        
        if(sum < 9)
            return (int)sum;
        else
            return digitSum(sum+"", 1);
    }

    static int digitSum(int n)
    {
    	int res = 0;
    	while(n != 0)
    	{
    		res += n%10;
    		n /= 10;
    	}
    	
    	if(res > 10)
    		res = digitSum(res);
    	return res;
    }
}
