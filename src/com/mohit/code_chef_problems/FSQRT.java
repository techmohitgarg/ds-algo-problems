package com.mohit.code_chef_problems;

import java.util.Scanner;

public class FSQRT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            System.out.println(String.valueOf(squareRoot(sc.nextInt())));
            System.out.println(String.valueOf(squareRoot1(sc.nextInt())));
            t--;
        }
    }


    public static int squareRoot1(int val) {
        if (val == 0 || val == 1) {
            return val;
        }
        int ans = 1;
        int i = 1;
        while (ans <= val) {
            i++;
            ans = i * i;
        }
        return i - 1;
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int i = 1;
        int ans = 1;
        while (ans <= x) {
            i++;
            ans = i * i;
        }
        return ans;
    }

    public static int squareRoot(int val) {
        int left = 1;
        int right = val;
        int ans = 0;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid <= val / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
