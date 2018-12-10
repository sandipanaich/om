package com.sandipan.algorithms.dynammic;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.util.HashMap;
import java.util.Map;

public class MinimumEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(distance("Hello".toCharArray(), "Heyllo".toCharArray(), 4, 5));
		System.out.println(distance("Heyllo".toCharArray(), "Hello".toCharArray(), 5, 4));
		System.out.println(distance("Heyllo".toCharArray(), "Hesllo".toCharArray(), 5, 5));
		
		
		String str1 = "sunday", str2 = "saturday";
		System.out.println(distance(str1.toCharArray(), str2.toCharArray(), str1.length()-1, str2.length()-1));
		System.out.println(distanceDynamic(str1.toCharArray(), str2.toCharArray(), str1.length()-1, str2.length()-1));
	}
	
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	
	private static int distance(char[] str1, char[] str2, int i1, int i2)
	{
/*		String key = i1+ ":" + i2;
		
		if(map.containsKey(key))
			return map.get(key);*/

		if(i1 < 0 || i2 <0)
			return abs(i1-i2);
		
		if(str1[i1] == str2[i2])
			return distance(str1, str2, i1-1, i2-1);
		else
			return min(distance(str1, str2, i1, i2-1), // insert
				   min(distance(str1, str2, i1-1, i2), // delete
					distance(str1, str2, i1-1, i2-1))) // update
					+ 1;
		//		return 0;
	}
	
	private static int distanceDynamic(char[] str1, char[] str2, int i1, int i2)
	{
		
		String key = i1 + ":" + i2;
		int distance = 0;
		
		if(map.containsKey(key))
			return map.get(key);
		
		if(i1 < 0 || i2 <0)
			distance = abs(i1-i2);
		else if(str1[i1] == str2[i2])
			distance = distanceDynamic(str1, str2, i1-1, i2-1);
		else
			distance = min(distanceDynamic(str1, str2, i1, i2-1), // insert
						 min(distanceDynamic(str1, str2, i1-1, i2), // delete
					           distanceDynamic(str1, str2, i1-1, i2-1))) // update
					+ 1;
		map.put(key, distance);
		return distance;		
	}

}
