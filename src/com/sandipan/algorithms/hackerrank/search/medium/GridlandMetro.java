package com.sandipan.algorithms.hackerrank.search.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GridlandMetro {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		long m = in.nextLong();
		long n = in.nextLong();
		int trains = in.nextInt();
		Map<Long, List<ArrayList<Long>>> matrix = new HashMap<>();
		for (int i = 0; i < trains; i++) {
			long row = in.nextLong();
			long from = in.nextLong();
			long to = in.nextLong();
			boolean isPut = false;
			if (matrix.containsKey(row)) {
				List<ArrayList<Long>> listTrains = matrix.get(row);
				for (ArrayList<Long> train : listTrains) {
					long c1 = train.get(0);
					long c2 = train.get(1);
					if (!((to < c1) || (from > c2))) {
						if (to > c2)
							train.set(1, to);
						if (from < c1)
							train.set(0, from);
					} else {
						ArrayList<Long> tempTrain = new ArrayList<>();
						tempTrain.add(from);
						tempTrain.add(to);
						listTrains.add(tempTrain);
						break;
					}
				}
				isPut = true;
			}
			if (!isPut) { // not containing that row also goes here!
				ArrayList<Long> train = new ArrayList<>();
				train.add(from);
				train.add(to);
				if (!matrix.containsKey(row)) {
					List<ArrayList<Long>> listTrains = new ArrayList<>();
					listTrains.add(train);
					matrix.put(row, listTrains);
				} else {
					List<ArrayList<Long>> listTrains = matrix.get(row);
					listTrains.add(train);
				}
			}

		}

		// Calculate the result
		long sum = 0;
		for (long j : matrix.keySet()) {
			List<ArrayList<Long>> listTrains = matrix.get(j);
			for (ArrayList<Long> train : listTrains) {
				sum += train.get(1) - train.get(0) + 1;
			}
		}
		System.out.println(m * n - sum);
		in.close();
	}
}
