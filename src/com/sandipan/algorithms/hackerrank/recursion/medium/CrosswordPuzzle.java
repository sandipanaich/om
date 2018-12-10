package com.sandipan.algorithms.hackerrank.recursion.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrosswordPuzzle {

	static String[] crosswordPuzzle(String[] crossword, String hints) {

		String[] hintsArr = hints.split(";");
		String[][] crosswords = new String[10][10];

		for (int i = 0; i < 10; i++)
			crosswords[i] = crossword[i].split("");

		for (String string : hintsArr)
			System.out.println(string);

		solve(crosswords, hintsArr, hintsArr, 0, 0);

		return crossword;
	}

	static boolean solve(String[][] crossword, String[] hints, String[] leftovers, int i, int j) {

		for (int x = i; x < 10; x++) {
			for (int y = j; y < 10; y++) {

				if ("-".equals(crossword[x][y])) {

					String[] horizontalFittingStrings = findHorizontalFittingStrings(crossword, leftovers, x, y);
					String[] verticalFittingStrings = findVerticalFittingStrings(crossword, leftovers, x, y);
					
					if(horizontalFittingStrings == null || horizontalFittingStrings.length == 0)
					{
						// check only the vertical fitting Strings
						for(String string : verticalFittingStrings)
						{
							int index = updateLeftOver(leftovers, string, -1);
							boolean result = solve(crossword, hints, leftovers, x+1, y);
						}
					}
					else if(verticalFittingStrings == null || verticalFittingStrings.length == 0)
					{
						// check only for the horizontal fitting Strings 
					}
					else
					{
						// check vertical for every horizontal strings or vice versa.
					}
										
					boolean result = solve(crossword, hints, leftovers, x, y);
					if (!result)
						return false;
					
					break;
				}
			}
		}

		return true;
	}
	
	private static int updateLeftOver(String[] leftOver, String string, int index)
	{
		return -1;
	}
	
	static String[] findHorizontalFittingStrings(String[][] crossword, String[] leftovers, int i, int j) {

		int horizontalLength = 0;

		while (j < 10) {
			if (!"-".equals(crossword[i][j]))
				break;
			horizontalLength++;
			j++;
		}

		if (horizontalLength == 0)
			return new String[0];

		return findFittingStringsFromLeftOver(leftovers, horizontalLength);
	}
	
	static String[] findVerticalFittingStrings(String[][] crossword, String[] leftovers, int i, int j) {

		int verticalLength = 0;

		while (i < 10) {
			if (!"-".equals(crossword[i][j]))
				break;
			verticalLength++;
			i++;
		}

		if (verticalLength == 0)
			return new String[0];
		
		return findFittingStringsFromLeftOver(leftovers, verticalLength);
	}
	
	static String[] findFittingStringsFromLeftOver(String[] leftovers, int length)
	{
		List<String> fittingStrings = new ArrayList<>();
		for(int i = 0 ; i < leftovers.length; i++)
		{
			String str = leftovers[i];
			if(str != null && str.length() == length)
				fittingStrings.add(str);
		}
		return  fittingStrings.toArray(new String[fittingStrings.size()]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Test.txt"));

		String[] crossword = new String[10];

		for (int i = 0; i < 10; i++) {
			String crosswordItem = scanner.nextLine();
			crossword[i] = crosswordItem;
		}

		String hints = scanner.nextLine();

		String[] result = crosswordPuzzle(crossword, hints);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(result[i]);

			if (i != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
