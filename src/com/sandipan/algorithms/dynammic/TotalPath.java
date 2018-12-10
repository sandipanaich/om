package com.sandipan.algorithms.dynammic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalPath {

	private static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// paths(matrix, 0 , 0 , 2, 2, 21, new ArrayList<Integer>());

		matrix = new int[][] { { 1, 2, 3 }, { 4, 6, 5 }, { 3, 2, 1 } };
		System.out.println(paths(matrix, 0, 0, 2, 2, 12, new ArrayList<Integer>()));

	}

	private static int paths(int[][] matrix, int row1, int column1, int targetRow, int targetColumn, int k,
			List<Integer> list) {
		// System.out.println("row1 : " + row1 + " column1:" + column1 + " k:"
		// +k);

		if (row1 > targetRow || column1 > targetColumn || k < 0)
			return 0;

		if ((row1 == targetRow) && (column1 == targetColumn)) {
			if (matrix[row1][column1] == k) {
				System.out.println("FOUND  :: " + Arrays.toString(list.toArray()));
				return 1;
			}
			return 0;
		} else {
			String key = row1 + ":" + column1 + ":" + k;
			list.add(matrix[row1][column1]);
			int val = 0;
			if (map.containsKey(key))
				val = map.get(key);
			else {
				int result = paths(matrix, row1 + 1, column1, targetRow, targetColumn, k - matrix[row1][column1], list)
						+ paths(matrix, row1, column1 + 1, targetRow, targetColumn, k - matrix[row1][column1], list);
				map.put(key, result);
				val = result;
			}
			list.remove(list.size() - 1);
			return val;
		}
	}

}
