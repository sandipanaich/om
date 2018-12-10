package com.sandipan.algorithms.hackerrank.array.easy;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

	public static void main(String[] args) {
		
		int[][] array = new int[][]{{1,0,5},{1,1,7},{1,0,3},{2,1,0},{2,1,1}};
		print(dynamicArray(2, array));
	}
	
	private static void print(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
    static int[] dynamicArray(int n, int[][] queries) {
        /*
         * Write your code here.
         */
        
        int lastAnswer = 0;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        
        List<Integer> sol = new ArrayList<Integer>();
        for(int[] query : queries)
        {
            int type = query[0];
            int x = query[1];
            int y = query[2];
            int seq = (x ^ lastAnswer)%n;
            switch(type)
            {
                case 1: 
                    list.get(seq).add(y);
                    break;
                case 2:
                    lastAnswer = y % list.get(seq).size();
                    lastAnswer = list.get(seq).get(lastAnswer);
                    sol.add(lastAnswer);
//                    System.out.println(lastAnswer);
                    break;
            }
        }
        
        int[] solArr = new int[sol.size()];
        
        int i=0;
        for(int num : sol)
        	solArr[i++] = num;
        
        return solArr;
    }
}
