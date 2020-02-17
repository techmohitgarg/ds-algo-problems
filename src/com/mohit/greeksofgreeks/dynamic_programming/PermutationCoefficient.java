package com.mohit.greeksofgreeks.dynamic_programming;

public class PermutationCoefficient {
    public static void main(String[] args) {
        PermutationCoefficient coefficient = new PermutationCoefficient();
        coefficient.permutationCoeff(10, 3);
    }

    static int permutationCoeff(int n, int k) {
        if (k == 0 || k == n) return 1;
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        return fact[n] / fact[n - k];
    }

    static int permutationCoeff1(int n, int k) {
        if (k == 0 || k == n) return 1;
        int fact = 1;
        int num = n;
        while (num > (n - k)) {
            fact = fact * num;
            num--;
        }
        return fact;
    }
}
