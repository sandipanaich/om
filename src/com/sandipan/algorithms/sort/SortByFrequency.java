package com.sandipan.algorithms.sort;

import static com.sandipan.algorithms.util.Util.print;

import java.util.Scanner;

public class SortByFrequency {

	public static void main(String[] args) {
		print(new int[]{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12});
		print(new SortByFrequency().sort(new int[]{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}));
		
		
/*		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for(int i = 0 ; i < t; t++)
		{
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int j =0 ;j < n ; j++)
				arr[j] = in.nextInt();
			
			print(new SortByFrequency().sort(arr));
		}
		
		in.close();*/
	}
	
	private int[] sort(int[] array){
		int[][] array2 = new int[array.length][2];
		
		for(int i = 0 ; i < array2.length;i++)
			array2[i][0] = Integer.MIN_VALUE;
		
		
		for(int i = 0 ; i < array.length; i++)
		{
			boolean found = false;
			int j = 0;
			for(; array2[j][0] != Integer.MIN_VALUE;j++)
			{
				if(array2[j][0] == array[i])
				{					
					found = true;
					break;
				}
			}
			if(found)
			{
				array2[j][1]++;
			}
			else
			{				
				array2[j][0] = array[i];
				array2[j][1]++;
			}
		}
		
		
		for(int i = 0 ; i < array2.length;i++)
		{
			for(int j = i+1 ; j < array2.length;j++){

				if(array2[i][1] < array2[j][1] && (array2[j][1] != 0))
				{
					int[] temp = array2[i];
					array2[i] = array2[j];
					array2[j] = temp;
				}
				else if(array2[i][1] == array2[j][1] && (array2[j][1] != 0) && array2[i][0] > array2[j][0])
				{
					int[] temp = array2[i];
					array2[i] = array2[j];
					array2[j] = temp;
				}
			}
			
		}
		
		
		int index = 0;
		for(int i = 0 ; i < array2.length;i++)
		{
			for(int j = 0 ; j < array2[i][1];j++)
			{
				array[index++] = array2[i][0];
			}
		}
		return array;
	}
}
