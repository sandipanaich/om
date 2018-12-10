package com.sandipan.algorithms.hackerrank.recursion.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import sun.nio.cs.HistoricallyNamedCharset;

public class CrosswordPuzzleSandipan {

	/*
solve(words,grid):
   if words is empty:
       if grid.isValudSol():
          return grid
       else:
          return None
   for each word in words:
       possibleSol <- grid.fillFirst(word)
       ret <- solve(words\{word},possibleSol)
       if (ret != None):
          return ret
   return None
	 */

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
	
	
	static String[] crosswordPuzzle(String[] crossword, String hints) {
		return solve(crossword, hints.split(";"));
	}
	
	static String[] solve(String[] crossword, String[] hints) {

		if(hints == null || hints.length == 0)
		{
			if(isGridValid(crossword))
				return crossword;
			return null;
		}
		
		for(int i = 0; i < hints.length; i++)
		{
			String word = hints[i];
			
		}
		
		return crossword;
	}
	
	private static void fillFirst(String[] crossword, String word)
	{
		
	}
	
	private static boolean isGridValid(String[] crossword)
	{
		
		for(int i = 0 ; i < crossword.length; i++)
		{
			String string = crossword[i];
			for(int j = 0 ; j < string.length(); j++)
			{
				if(string.charAt(j) == '-')
					return false;
			}
		}
		
		return true;
	}
}


/*
solve ( words , grid , filledPositions ) :
    if words is empty :
        if grid is solved :
            return grid
        else :
            raise ( no solution )
    for ( current position ) as the first possible word position in grid 
            that is not of filledPositions :
        for each word in words :
            make a copy of grid
            try :
                fill grid copy, with the current word, at the current position
            except ( cannot fill position ) :
                break
            try :
                return solve ( words\{word} , grid copy , 
                        filledPositions+{current position} )
            except ( no solution ) :
                break
        raise ( no solution )

*/