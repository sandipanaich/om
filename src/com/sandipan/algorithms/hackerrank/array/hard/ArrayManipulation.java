package com.sandipan.algorithms.hackerrank.array.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayManipulation {

	public static void main(String[] args) {
		int[][] queries = new int[][]{{1,2,100},{2,5,100},{3,4,100}};
		System.out.println(arrayManipulation(5, queries));
	}
	
    static long arrayManipulation(int n, int[][] queries) {
    	
    	
        int[] list = new int[n];

        for(int i = 0 ; i < queries.length ; i ++)
        {
        	int[] query = queries[i];
        	int a = query[0]-1;
        	int b = query[1];
        	int k = query[2];
        	
        	list[a] += k;
        	
        	if(b < n)
        		list[b] += -1*k;
        }
        
        long max = list[0];
        for(int i = 1; i< n ; i++)
        {
        	list[i] = list[i-1] + list[i];
        	if(max < list[i])
        		max = list[i];
        }
        return max;
    }

}
