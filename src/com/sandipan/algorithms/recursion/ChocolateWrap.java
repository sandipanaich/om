package com.sandipan.algorithms.recursion;

public class ChocolateWrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ChocolateWrap().count(16, 2, 0, 2));
		System.out.println(new ChocolateWrap().count(15, 1, 0, 3));
		System.out.println(new ChocolateWrap().count(20, 3, 0, 5));
	}

	private int count(int money, int value, int wrapCount, int wrappersneeded) {
		int count = 0;
		if (money > 0)
			count += count(money - value, value, wrapCount + 1, wrappersneeded) + ((money - value) >=0 ? 1:0);
		else if (wrapCount >= wrappersneeded)
			count += count(0, 0, wrapCount - wrappersneeded + 1, wrappersneeded) + 1;

		return count;
	}
}
