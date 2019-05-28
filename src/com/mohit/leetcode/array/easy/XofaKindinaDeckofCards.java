package com.mohit.leetcode.array.easy;

import java.util.HashMap;

public class XofaKindinaDeckofCards {

    public static void main(String[] args) {
        XofaKindinaDeckofCards deckofCards = new XofaKindinaDeckofCards();
        boolean b = deckofCards.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2});
        System.out.println(b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            min = Math.min(min, map.get(key));
        }
        if (min == 1) {
            return false;
        }
        for (Integer key : map.keySet()) {
            if (gcd(min, map.get(key)) == 1) {
                return false;
            }
        }
        return true;
    }


    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    private int hcf(int a, int b) {
        int hcf = 1;
        for (int i = 1; i <= a || i <= b; i++) {
            if (a % i == 0 && b % i == 0)
                hcf = i;
        }
        return hcf;
    }
}
