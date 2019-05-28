package com.mohit.interviewbit.array;


import java.util.ArrayList;

public class SetMatrixZeros {
    public static void main(String[] args) {
        SetMatrixZeros continuousSubarray = new SetMatrixZeros();


    }

    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if (a.size() == 0) {
            return;
        }
        int[][] num = new int[a.size()][a.get(0).size()];
        // Check left to Right
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (a.get(i).get(j).intValue() == 0) {
                    for (int k = 0; k < num[i].length; k++) {
                        num[i][k] = 2;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < num[0].length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (a.get(j).get(i).intValue() == 0) {
                    for (int k = 0; k < num.length; k++) {
                        num[k][i] = 2;
                    }
                    break;
                }

            }
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                if (num[i][j] == 2) {
                    a.get(i).set(j,0);
                }
            }
        }

    }
}
