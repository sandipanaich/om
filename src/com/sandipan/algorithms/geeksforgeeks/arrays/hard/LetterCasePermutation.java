package com.sandipan.algorithms.geeksforgeeks.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new LetterCasePermutation().permute("abc".toCharArray(), 0, new ArrayList<String>());
		new LetterCasePermutation().permute("a1b2".toCharArray(), 0,  new ArrayList<String>());
		new LetterCasePermutation().permute("3z4".toCharArray(), 0,  new ArrayList<String>());
		new LetterCasePermutation().permute("12345".toCharArray(), 0,  new ArrayList<String>());
		new LetterCasePermutation().permute("Z".toCharArray(), 0,  new ArrayList<String>());
	}

	public List<String> permute(char[] str, int index, List<String> list) {
		if (index<0)
			return list;
		if(index == str.length){
			list.add(new String(str));
			System.out.println(new String(str));
			return list;
		}
		char ch = str[index];
		char oldCh = ch;

		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			if (ch >= 'a' && ch <= 'z')
				ch = (char) ((int) ch - (int) 'a' + (int) 'A');
			else if (ch >= 'A' && ch <= 'Z')
				ch = (char) ((int) ch - (int) 'A' + (int) 'a');
			
			str[index] = oldCh;
			permute(str, index + 1, list);
			str[index] = ch;
			permute(str, index + 1, list);
			str[index] = oldCh;
		}else
			permute(str, index + 1, list);
		return list;
	}

	
/*	public void permute1(char[] str, int index) {
		if (index >= str.length)
			return;

		char ch = str[index];
		char oldCh = ch;
		
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			if (ch >= 'a' && ch <= 'z')
				ch = (char) ((int) ch - (int) 'a' + (int) 'A');
			else if (ch >= 'A' && ch <= 'Z')
				ch = (char) ((int) ch - (int) 'A' + (int) 'a');

			
			str[index] = ch;
			permute(str, index+1, list);
			str[index] = oldCh;
			permute(str, index+1, list);
		}
		else
			permute(str, index+1, list);

	}*/

}
/**
 * ab
 * aB
 * Ab
 * AB
 * 
 */