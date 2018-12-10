package com.sandipan.algorithms.recursion;

public class AtoI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new AtoI().atoi("1234", 0));
		long i = new AtoI().atoi2("1234".toCharArray(), 0);
		System.out.println(i);
	}
	
	public long atoi(String str, int index)
	{
		if(index >= str.length())
			return 0;
		
		return (long)Math.pow(10, (str.length() - 1 - index))*(str.charAt(index) - '0') + atoi(str,index+1);
	}

	public long atoi2(char[] str, int index)
	{
		if(index >= str.length)
			return 0;
		
		return (long)Math.pow(10, (str.length- 1 - index))*(str[index] - '0') + atoi2(str,index+1);
	}
}
