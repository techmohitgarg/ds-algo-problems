package com.mohit.leetcode.dynamic_programming.easy;

public class DivisorGame {

    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(1));
    }


    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

}