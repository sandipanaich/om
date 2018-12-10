package com.sandipan.algorithms.sort;

import java.util.Arrays;

public class EqualArray {

	public static void main(String[] args) {
		System.out.println(new EqualArray().isEqual(new int[]{1, 2,5,4,0}, new int[]{2,4,5,0,1}));
		System.out.println(new EqualArray().isEqual(new int[]{1, 2,5}, new int[]{2,4,15}));
		System.out.println(new EqualArray().isEqual(new int[]{1, 2,5}, null));
		System.out.println(new EqualArray().isEqual(null, new int[]{2,4,15}));
	}

	private boolean isEqual(int[] array1, int[] array2) {
		
		if (!(array1 != null && array2 != null) || array1.length != array2.length)
			return false;

		Arrays.sort(array1);
		Arrays.sort(array2);
		
		for(int i=0 ; i < array1.length; i++ )
		{
			if(array1[i] != array2[i])
				return false;
		}
		
		return true;
	}

}
