package com.mohit.leetcode.array.easy;

public class BitCharacters {

    public static void main(String[] args) {
        BitCharacters array = new BitCharacters();
        System.out.println(array.isOneBitCharacter(new int[]{1, 0, 0}));
    }


    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 0) {
            return false;
        }
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else  {
                i = i + 2;
            }

        }
        if (i >= bits.length) {
            return false;
        }
        return true;
    }

}
