package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class OnlineStockSpan {
    public static void main(String[] args) {
        //[],[100],[80],[60],[70],[60],[75],[85];
        StockSpanner spanner = new StockSpanner();
        System.out.print(spanner.next(100));
        System.out.print(spanner.next(80));
        System.out.print(spanner.next(60));
        System.out.print(spanner.next(70));
        System.out.print(spanner.next(60));
        System.out.print(spanner.next(75));
        System.out.print(spanner.next(85));
    }

    static class StockSpanner {
        Stack<int[]> st = null;

        public StockSpanner() {
            st = new Stack<>();
        }

        public int next(int price) {
            int count = 1;
            while (!st.isEmpty() && st.peek()[0] <= price) {
                count += st.pop()[1];
            }
            st.push(new int[]{price, count});
            return count;
        }
    }
    void calculateSpan(int price[]) {
        if (price.length == 0) {
            return;
        }
        int[] stock = new int[price.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < price.length; i++) {
            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }
            stock[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
    }
}