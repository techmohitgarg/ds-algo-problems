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
        Stack<Integer> prices = null;
        Stack<Integer> weight = null;

        public StockSpanner() {
            prices = new Stack<>();
            weight = new Stack<>();
        }

        public int next(int price) {
            int days = 1;
                while (!prices.isEmpty() && prices.peek() <= price) {
                    prices.pop();
                    days += weight.pop();
            }
            // Add Current Price Value
            prices.add(price);
            weight.add(days);
            return days;
        }
    }
}