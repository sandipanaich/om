package com.sandipan.algorithms.hackerrank.stack.easy;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = in.nextInt();
        for(int i = 0 ; i < n ; i ++)
        {
            String query = in.next();
            switch(Integer.parseInt(query))
            {
                case 1:
                    stack.push(in.nextInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int v = stack.pop();
                    stack.push(v);
                    System.out.println(v);
                    break;
            }
        }
        in.close();
    }
}