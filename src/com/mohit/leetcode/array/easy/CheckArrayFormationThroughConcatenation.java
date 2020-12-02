package com.mohit.leetcode.array.easy;

import java.util.HashMap;
import java.util.HashSet;

public class CheckArrayFormationThroughConcatenation {


    /*
     TC : O(N)+(O(i)*O(j)) - > O(I*J)
     SC : O(N)
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {

        HashMap<Integer, int[]> setPieces = new HashMap<>();
        // Form a set of integer with first integer of array from pieces
        for (int[] piece : pieces) { //O(N) length of pieces
            setPieces.put(piece[0], piece);
        }

        int i = 0;
        while (i < arr.length) { //O(i) i means length of "arr"
            if (setPieces.containsKey(arr[i])) {
                int[] data = setPieces.get(arr[i]);
                int j = 0;
                while (i < arr.length && j < data.length && arr[i] == data[j]) { //O(j) j is the length of data array
                    i++;
                    j++;
                }
            } else {
                return false;
            }
        }

        if (i < arr.length) {
            return false;
        }

        return true;
    }


}

