package com.mohit;

public class TreeBookPractice {

    public static void main(String[] args) {
        System.out.println(new TreeBookPractice().divisorGame(1));
    }


    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

}