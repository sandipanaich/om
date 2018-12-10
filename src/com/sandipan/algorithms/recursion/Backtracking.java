package com.sandipan.algorithms.recursion;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Backtracking {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		new Backtracking().permute(in.next());
		in.close();
	}
	
	private void permute(String string) {
		Map<Character, Integer> frequencies = frequencyArr(string.toCharArray());
		Character[] str = frequencies.keySet().toArray(new Character[0]);
		Integer[] count = frequencies.values().toArray(new Integer[0]);
		char[] result = new char[string.length()];
		permute(str, count, result, 0);
	}
	
	private void permute(Character[] str, Integer[] count, char[] result, int level)
	{
		if(level == result.length)
			System.out.println(new String(result));
		
		for(int i = 0 ; i < str.length; i++)
		{
			if(count[i] == 0)
				continue;
			
			result[level] = str[i];
			count[i]--;
			permute(str, count, result, level+1);
			count[i]++;
		}
	}

	private Map<Character, Integer> frequencyArr(char[] arr) {
		
		Map<Character, Integer> map = new TreeMap<>();
		for (int i = 0 ; i < arr.length; i++) {
			map.put(arr[i], (map.get(arr[i]) == null) ? 1 :(map.get(arr[i]) +1));
		}		
		return map;
	}
}
